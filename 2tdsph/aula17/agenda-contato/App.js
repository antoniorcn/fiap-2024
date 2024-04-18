import { useEffect, useState } from 'react';
import { Button, FlatList, Modal, StyleSheet, Text, TextInput, ToastAndroid, View } from 'react-native';
import { NavigationContainer } from "@react-navigation/native"
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Entypo } from '@expo/vector-icons';
import axios from 'axios';

const {Navigator, Screen} = createBottomTabNavigator();

const api = axios.create({
  baseURL: "https://tdsph-ee91f-default-rtdb.firebaseio.com"
})

const Formulario = ( props ) => {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  return (
    <View style={styles.container}>
        <Text>Formulario</Text>
        <TextInput placeholder="Nome:" value={nome} onChangeText={setNome}/>
        <TextInput placeholder="Telefone:" value={telefone} onChangeText={setTelefone}/>
        <TextInput placeholder="Email:" value={email} onChangeText={setEmail}/>
        <Button title="Salvar" onPress={()=>{
          const obj = {nome, telefone, email}
          props.onSalvar( obj )
        }}/>
    </View>
  )
}

const Item = (props) => { 
  return (
    <View style={[styles.item, {flexDirection: "row"}]}>
      <View style={{flex: 3}}>
        <Text>Nome: {props.item.nome}</Text>
        <Text>Telefone: {props.item.telefone}</Text>
        <Text>Email: {props.item.email}</Text>
      </View>
      <View style={{flex: 1}}>
        <Entypo name="trash" size={32} onPress={()=>{
          props.onApagar( props.item.id )}}/>
      </View>
    </View>
  )
}

const Listagem = (props) => {
  return (
    <View style={styles.container}>
        <Text>Listagem</Text>
        {/* <Button title="Carregar Contatos" onPress={props.onListar}/> */}
        <FlatList data={props.lista} 
          renderItem={(itemProps)=><Item {...itemProps} 
                        onApagar={props.onApagar}/>}/>
    </View>
  )
}

const Login = (props) => { 
  const [user, setUser] = useState("");
  const [pass, setPass] = useState("");
  return (
    <View>
      <TextInput placeholder="Informe o email" 
          value={user} onChangeText={setUser}/>
      <TextInput placeholder="Informe sua senha" secureTextEntry={true}
          value={pass} onChangeText={setPass}/>
      <Button title="Login" onPress={()=>{
          props.onLogar(user, pass);
      }}/>
    </View>
  )
}

export default function App() {

  const [lista, setLista] = useState([])
  const [atualizar, setAtualizar] = useState(0)
  const [logado, setLogado] = useState(false);

  useEffect( ()=>{
      carregarContatos();
    }, [atualizar]
  )

  const salvar = (obj)=>{
    api.post('/contatos.json', obj )
    .then( ()=>{
      ToastAndroid.show("Dados salvos...", ToastAndroid.LONG);
      setAtualizar( atualizar + 1)
    })
    .catch( (err)=>{
      ToastAndroid.show("Erro ao salvar os dados..." + err, ToastAndroid.LONG);
    } )
  }

  const apagar = ( id ) => {
    const uri = "/contatos/" + id + ".json";
    api.delete(uri)
    .then( () => {
      ToastAndroid.show("Registro apagado", ToastAndroid.LONG);
      setAtualizar( atualizar + 1)
    })
    .catch( (err)=>{
      ToastAndroid.show("Erro ao apagar o registro..." + err, ToastAndroid.LONG);
    })
  }

  const carregarContatos = () => {
    api.get('/contatos.json')
    .then( (response)=>{
      const listaTemp = []
      for (let chave in response.data) { 
        const obj = response.data[chave]
        obj.id = chave
        listaTemp.push( obj )
      }
      setLista( listaTemp );
    })
    .catch( (err)=>{
      ToastAndroid.show("Erro ao carregar os dados", ToastAndroid.LONG);
    })
  }

  const logar = ( user, password ) => {
    api.post('/login.json', {user, password})
  }

  return (
    <View style={styles.container}>
      <Modal visible={! logado}>
        <Text style={styles.titulo}>Agenda de Contatos</Text>
        <Login onLogar={logar}/>
      </Modal>
      <Text style={styles.titulo}>Agenda de Contatos</Text>
      <NavigationContainer>
        <Navigator>
          <Screen name="Formulario">
            {(navProps)=><Formulario {...navProps} onSalvar={salvar}/>}
          </Screen>
          <Screen name="Listagem">
            {(navProps)=><Listagem {...navProps} lista={lista} 
                                      onListar={carregarContatos}
                                      onApagar={apagar}/>}
          </Screen>
        </Navigator>
      </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'stretch',
    justifyContent: 'flex-start',
  },
  titulo: { 
    fontSize: 48,
    textAlign: "center"
  },
  item: { 
    backgroundColor: "lightcyan",
    margin: 15,
    padding: 5,
    borderColor: "lightblue",
    borderWidth: 2
  }
});
