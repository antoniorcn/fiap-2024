import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, StyleSheet, Text, TextInput, View } from 'react-native';
import { useState } from 'react';
import axios from 'axios';

const apiWeb = axios.create({
  baseURL: "https://tdspv-projeto2-default-rtdb.firebaseio.com"})
export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");

  const [lista, setLista] = useState([
    // {nome: "Joao", telefone: "(11) 1111-1111"}
  ]);

  return (
    <View style={styles.container}>
      <Text>Agenda de Contato</Text>
      <TextInput placeholder="Nome" 
          value={nome} onChangeText={setNome}/>
      <TextInput placeholder="Telefone" 
          value={telefone} onChangeText={setTelefone}/>          
      <Button title="Gravar" onPress={()=>{
        const obj = {nome, telefone}
        apiWeb.post("/contatos.json", obj)
      }}/>
      <Button title="Carregar" 
      onPress={()=>{
        apiWeb.get("/contatos.json")
        .then((resposta)=>{
          const objComplexo = resposta.data;
          console.log(JSON.stringify(objComplexo))
          const listaTemp = []
          for(let chave in objComplexo) { 
            const obj = objComplexo[chave]
            listaTemp.push(obj)
          }
          setLista(listaTemp)
        })
        .catch((e)=>{alert("Erro ao carregar os dados " + e)})
      }}
      />
      <FlatList data={lista} renderItem={(props)=>
        <View>
          <Text>Nome: {props.item.nome}</Text>
          <Text>Telefone: {props.item.telefone}</Text>
        </View>
      }/>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
