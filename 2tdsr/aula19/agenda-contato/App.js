import { SafeAreaView, Button, View,
  Text, TextInput, StyleSheet, ScrollView, 
  ToastAndroid
} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState, useEffect } from 'react';
import Constants from 'expo-constants';
import {Entypo} from '@expo/vector-icons';
import axios from 'axios';

const estilos = StyleSheet.create({
  input: {
    backgroundColor: "lightcyan",
    borderColor: "red",
    borderWidth: 2,
    borderRadius: 20,
    paddingHorizontal: 10,
    marginVertical: 10,
    marginHorizontal: 5,
  }
})

const apiWeb = axios.create({
  baseURL: "https://tdsr-61a49-default-rtdb.firebaseio.com/"
})
const CONTATOS_RESOURCE = "/contatos";

const {Navigator, Screen} = createBottomTabNavigator();

const Formulario = ( {onGravar, navigation} ) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  return (
    <View style={{flex: 1}}>
      <Text> Formulario </Text>
      <TextInput style={estilos.input} placeholder="Digite o nome" 
                  value={nome} onChangeText={setNome}/>

      <TextInput style={estilos.input} placeholder="Digite o telefone" 
                  value={telefone} onChangeText={setTelefone}/>

      <TextInput style={estilos.input} placeholder="Digite o email" 
                  value={email} onChangeText={setEmail}/>
      <Button title="Salvar" onPress={()=>{
        const obj = {nome, telefone, email}
        onGravar( obj );
        setNome("")
        setEmail("")
        setTelefone("")
        navigation.navigate("Lista");
      }}/>
    </View>
  )
}

const Listagem = ( { lista, corFundo, onLerDados, onApagar } ) => { 
  const listaVisual = lista.map( (item, idx) => {
    return (
      <View style={{  margin: 5, 
                      borderWidth: 2, 
                      borderRadius: 20,
                      paddingHorizontal: 10,
                      paddingVertical: 5,
                      backgroundColor: corFundo,
                      borderColor: "orange"}} key={"obj-" + idx}>
        <Text>{item.nome}</Text>
        <Text>{item.telefone}</Text>
        <Text>{item.email}</Text>
        <Entypo name="trash" size={36} onPress={()=>{
          onApagar( item );
        }}/>
      </View>
    )
  })

  return (
    <ScrollView style={{flex: 1}}>
      <Text> Listagem </Text>
      {/* <Button title="Ler Dados" onPress={()=>{
          onLerDados();
      }}/> */}
      {listaVisual}
    </ScrollView>
  )
}

export default function App() {
  const [lista, setLista] = useState([]);

  const gravar = ( obj ) => {
    apiWeb.post(
      CONTATOS_RESOURCE + ".json", 
      obj
    )
    .then(()=>{
      ToastAndroid.show("Contato salvo com sucesso", ToastAndroid.LONG);
      lerDados();
    })
  }

  const lerDados = () => {
    apiWeb.get(CONTATOS_RESOURCE + ".json")
    .then((response)=>{
      const listaTemp = []
      for (const chave in response.data) { 
        const obj = response.data[chave];
        obj.id = chave;
        listaTemp.push( obj );
      }
      setLista(listaTemp);
      ToastAndroid.show("Dados lidos com sucesso", ToastAndroid.LONG);
      // alert("Dados lidos com sucesso");
    })
    .catch((err)=>{
      ToastAndroid.show("Erro ao ler os dados: " + err, ToastAndroid.LONG);
      // alert("Erro ao ler os dados: " + err);
    })
  }

  const apagar = ( obj ) => { 
    apiWeb.delete(CONTATOS_RESOURCE + "/" + obj.id + ".json")
    .then(()=>{
      ToastAndroid.show("Contato apagado com sucesso", ToastAndroid.LONG);
      lerDados();
    })
    .catch((err)=>{
      ToastAndroid.show("Erro ao apagar o contato: " + err, ToastAndroid.LONG);
    })   
  }

  useEffect (()=>{
    lerDados();
  }, [])


  return (
    <SafeAreaView style={{flex: 1, 
                marginTop: Constants.statusBarHeight}}>
      <Text style={{fontSize: 32}}>Agenda de Contatos 2</Text>
      <NavigationContainer>
        <Navigator>
          <Screen name="Form" options={{
            tabBarIcon: ()=><Entypo name="edit" size={36}/>
          }}>
            {(navProps)=><Formulario {...navProps} onGravar={gravar}/>}
          </Screen>

          <Screen name="Lista" options={{
            tabBarIcon: ()=><Entypo name="list" size={36}/>
          }}>
            {(navProps)=><Listagem {...navProps} 
                corFundo="lightyellow" lista={lista} 
                onLerDados={lerDados}
                onApagar={apagar}/>}
          </Screen>
        </Navigator>
      </NavigationContainer>
    </SafeAreaView>
  );
}
