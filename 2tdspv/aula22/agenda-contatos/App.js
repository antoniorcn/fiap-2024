import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, Text, TextInput, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState, useEffect } from 'react';
import axios from 'axios';
import {Ionicons} from '@expo/vector-icons';

const api = axios.create({
  baseURL: "https://cb01d14e-5d50-420d-be73-d9ad513bf19a-00-13itt3irdrm1m.kirk.replit.dev"
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

  useEffect( ()=> {
    carregar();
  }, [] )

  const gravar = ( obj ) => { 
    api.post("/contato", obj)
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

  return (
    <View style={{flex: 1}}>
      <Text>Agenda de Contato</Text>
      <StatusBar style="auto" />
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
    </View>
  );
}

