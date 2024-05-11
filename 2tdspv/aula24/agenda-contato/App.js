import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, Text, TextInput, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState, useEffect } from 'react';
import axios from 'axios';
import {Ionicons} from '@expo/vector-icons';
import { Login } from './components/Login';

const api = axios.create({
  baseURL: "https://12084d2d-ef85-44bb-b22a-1ce3cc295dfa-00-30197hktpob4v.worf.replit.dev"
})

const {Navigator, Screen} = createBottomTabNavigator();

const Formulario = ( props ) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");

  return (
    <View style={{flex: 1}}>
      <Text> Formulario de cadastro de contatos </Text>
      <TextInput placeholder="Informe o nome completo:"
        value={nome} onChangeText={setNome}/>
      <TextInput placeholder="Informe o telefone:"
        value={telefone} onChangeText={setTelefone}/>
      <TextInput placeholder="Informe o email:"
        value={email} onChangeText={setEmail}/>
      <Button title="Gravar" onPress={()=>{
        const obj = {nome, telefone, email};
        props.onGravar( obj );
      }} />
    </View>
  )
}

const Item = (props) => 
  <View>
    <Text>Nome: {props.item.nome}</Text>
    <Text>Telefone: {props.item.telefone}</Text>
    <Text>Email: {props.item.email}</Text>
    <Ionicons name="trash" size={28} onPress={()=>{
      props.onApagar(props.item.id)
    }}/>
  </View>

const Listagem = ( props ) => { 
  return (
    <View style={{flex: 1}}>
      <Text> Listagem de contatos </Text>
      <FlatList data={props.lista} 
          renderItem={(flatProps)=>
            <Item {...flatProps} onApagar={props.onApagar}/>}/>
    </View>
  )
}

export default function App() {
  const [lista, setLista] = useState([]);
  const [token, setToken] = useState(null);

  useEffect( ()=> {
    carregar();
  }, [] )

  const gravar = ( obj ) => { 
    api.post("/contato", obj, {
      headers: {
        Authorization: "Bearer " + token
      }
    })
    .then(()=>{
      carregar();
    })
    .catch((err)=>{
      alert("Erro ao gravar o objeto: " + err);
    })
  }

  const carregar = () => { 
    api.get("/contato")
    .then( ( response ) => {
      setLista(response.data);
    })
    .catch( () => {
      alert("Erro ao carregar a lista");
    })
  }

  const apagar = ( id ) => { 
    api.delete("/contato/" + id)
    .then( () => {
      carregar();
    })
    .catch( () => {
      alert("Erro ao apagar item da lista");
    })
  }

  const logar = ( usuario, senha ) => { 
    api.post("/login", { user: usuario, password: senha })
    .then((response)=>{
      setToken(response.data.token);
    })
    .catch((err)=>{
      alert("Usuario ou senha incorretos");
    })
  }

  return (
    <View style={{flex: 1}}>
      <Text>Agenda de Contato</Text>
      <StatusBar style="auto" />
      { token != null ? 
        <NavigationContainer>
          <Navigator>
            <Screen name="Formulario">
              {()=><Formulario onGravar={gravar} />}
            </Screen>
            <Screen name="Listagem">
              {()=><Listagem lista={lista} onApagar={apagar}/>}
            </Screen>
          </Navigator>
        </NavigationContainer>
        :
        <Login onLogar={logar}/>
      }
    </View>
  );
}

