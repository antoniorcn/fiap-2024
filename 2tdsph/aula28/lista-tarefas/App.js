import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, StyleSheet, Text, TextInput, View } from 'react-native';
import { useState, useEffect } from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import axios from 'axios';
const {Navigator, Screen} = createBottomTabNavigator();

const apiweb = axios.create({
  baseURL: "https://b166ea46-9ece-4c35-803c-bbec72322e7e-00-33ly5fi0exrm5.janeway.replit.dev"
})

const Formulario = ( props ) => { 
  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");

  return(
    <View style={{flex: 1}}>
      <Text> Editar Tarefa </Text>
      <Text>Titulo</Text>
      <TextInput value={titulo} onChangeText={setTitulo}/>
      <Text>Descricao</Text>
      <TextInput value={descricao} onChangeText={setDescricao}/>
      <Button title="Gravar" onPress={()=>{
        const obj = {titulo, descricao}
        props.funcaoInserir( obj );
      }}/>
    </View>
  )
}

const Tarefa = ( {item} ) => {
  const {titulo, descricao} = item;
  return (
    <View style={{borderWidth: 2, margin: 5, padding: 5}}>
      <Text>{titulo}</Text>
      <Text>{descricao}</Text>
    </View>
  );
}

const ListaTarefas = ( props ) => { 
  return (
    <View style={{flex: 1}}>
      <FlatList data={props.variavelLista} renderItem={Tarefa}/>
    </View>
  )
}


export default function App() {
  const [lista, setLista] = useState([]);

  useEffect(()=>{
    carregar();
  }, [])

  const inserir = ( obj ) => { 
    apiweb.post("/tarefa", obj)
    .then(()=>{
      carregar();
      alert("Dados gravados com sucesso");
    })
    .catch(( err )=>{
      alert("Erro ao gravar os dados: " + err);
    })
  }

  const carregar = () => { 
    apiweb.get("/tarefa")
    .then((response)=>{
      setLista( [...response.data.lista] );
    })
    .catch(( err )=>{
      alert("Erro ao ler os dados: " + err);
    })
  }

  return (
    <View style={styles.container}>
      <NavigationContainer>
        <Navigator>
          <Screen name="Cadastro">
            {( navProps )=><Formulario {...navProps}
                                      funcaoInserir={inserir}  />}
          </Screen>
          
          <Screen name="Lista">
            {( navProps )=><ListaTarefas {...navProps}
                                        variavelLista={lista}/>}
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
  },
});
