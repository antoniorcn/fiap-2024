import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View, ScrollView, FlatList } from 'react-native';
import { NavigationContainer, useNavigation } from '@react-navigation/native'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState, useEffect } from 'react';
import Constants from 'expo-constants';
import {Entypo, FontAwesome} from '@expo/vector-icons';
import axios from 'axios';
const {Navigator, Screen} = createBottomTabNavigator();

const api = axios.create({
  baseURL: "https://36ee1d08-7f20-4431-b757-ca72badcc18e-00-2z0ssik3d28ia.riker.replit.dev"
})

const notificacao = ( msg ) => { 
  alert(msg);
}

const Login = (props) => { 
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  return (
    <View style={{flex: 1}}>
      <TextInput style={styles.input} placeholder="Informe seu email"
          value={email} onChangeText={setEmail}/>
      <TextInput style={styles.input} placeholder="Informe sua senha"
          value={senha} onChangeText={setSenha} secureTextEntry={true}/>
      <Button title="Logar" onPress={()=>{
        props.onLogar( {user: email, password: senha} );
      }}/>
    </View>
  )
}

const Formulario = (props) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");

  const navigation = useNavigation();
  return (
    <View style={styles.formulario}>
      <TextInput style={styles.input} placeholder="Nome Completo"
          value={nome} onChangeText={setNome}/>
      <TextInput style={styles.input} placeholder="Telefone"
          value={telefone} onChangeText={setTelefone}/>
      <TextInput style={styles.input} placeholder="Email"
          value={email} onChangeText={setEmail}/>
      <Button title="Salvar" onPress={()=>{
          const obj = { nome, telefone, email };
          props.onSalvar( obj );
          setNome("");
          setTelefone("");
          setEmail("");
          navigation.navigate("Listagem");
      }}/>
    </View>
  )
}

const Item = ({item, onApagar}) => { 
  return (
    <View>
      <Text>{item.nome}</Text>
      <Text>{item.telefone}</Text>
      <Text>{item.email}</Text>
      <Entypo name="trash" size={36} onPress={()=>{
        onApagar(item);
      }}/>
    </View>
  );
}

const Listagem = ({ onCarregar, onApagar, contatos, navigation }) => { 
  return (
    <View style={styles.listagem}>
      <Button title="Carregar" onPress={()=>{
        onCarregar();
      }} />
      <FlatList data={contatos} renderItem={(flatProps)=>
        <Item {...flatProps} onApagar={onApagar}/>
      }/>
      <Button title="Voltar" onPress={()=>{
        navigation.goBack();
      }}/>
    </View>
  )
}

export default function App() {
  const [lista, setLista] = useState([]);
  const [reload, setReload] = useState(0);
  const [logado, setLogado] = useState(false);

  useEffect( ()=> {
    carregar();
  }, [reload]);

  const salvar = ( obj ) => {
    api.post("/contato", obj)
    .then((response)=>{
      notificacao("Objeto salvo com sucesso");
      setReload(reload + 1);
    })
    .catch((err)=>{
      notificacao("Erro ao salvar os dados: "+ err)})
  }

  const carregar = () => {
    api.get("/contato")
    .then( (resposta) => {
      const listaTemp = []
      for (chave in resposta.data) { 
        const obj = resposta.data[chave];
        obj.id = chave;
        listaTemp.push( obj );
      }
      setLista( listaTemp );
    })
    .catch((err)=>{
      notificacao("Erro ao carregar os dados: "+ err)})
  }

  const apagar = ( obj ) => {
    api.delete("/contato/" + obj.id )
    .then(()=>{
      notificacao("Objeto apagado com sucesso");
      setReload(reload + 1);
    })
    .catch((err)=>{
      notificacao("Erro ao carregar os dados: "+ err)
    })
  }

  const logar = ( obj ) => { 
    api.post("/login", obj)
    .then((resposta)=>{
      notificacao("Usuario logado: " + resposta.data.token)
      setLogado(true);
    })
    .catch((err)=>{
      notificacao("Erro ao fazer o login: "+ err)
    })
  }

  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>Agenda de Contatos</Text>
      <StatusBar style="auto" />
      {
      !logado ? 
      <Login onLogar={logar}/> 
      :
      <NavigationContainer>
        <Navigator>
          <Screen name="Formulário" options={{
            tabBarIcon: ()=><Entypo name="edit" size={38}/>
          }}>
              { (navProps) => <Formulario 
                    {...navProps}
                    onSalvar={salvar}/>}
          </Screen>
          <Screen name="Listagem" options={{
            tabBarIcon: ()=><Entypo name="list" size={38}/>
          }}>
              { (navProps) => <Listagem {...navProps} contatos={lista} 
                                        onCarregar={carregar}
                                        onApagar={apagar}/>}
          </Screen>
        </Navigator>
      </NavigationContainer>
      }
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'lightyellow',
    justifyContent: 'flex-start',
    marginTop: Constants.statusBarHeight
  },
  titulo: {
    marginVertical: 10,
    fontSize: 36,
    textAlign: "center",
    textShadowColor: "black",
    textShadowRadius: 5,
    textShadowOffset: {width: 3, height: 3}
  },
  formulario: { 
    flex: 1,
    backgroundColor: "antiquewhite"
  }, 
  listagem: { 
    flex: 1,
    backgroundColor: "azure"
  }, 
  input: {
    backgroundColor: "lavender",
    borderColor: "khaki",
    borderWidth: 2,
    paddingHorizontal: 10,
    paddingVertical: 5,
    margin: 5
  }
});
