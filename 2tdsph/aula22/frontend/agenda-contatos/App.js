import { useState } from 'react';
import { Button, FlatList, Modal, StyleSheet, Text, TextInput, ToastAndroid, View } from 'react-native';
import { NavigationContainer } from "@react-navigation/native"
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Entypo } from '@expo/vector-icons';
import { useAgendaControl } from './control/agendaControl';

const {Navigator, Screen} = createBottomTabNavigator();

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
        {/*<Button title="Carregar Contatos" onPress={props.onListar}/>*/}    <FlatList data={props.lista} 
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
  const {logar, salvar, carregarContatos, apagar, lista, logado} = 
      useAgendaControl();
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
