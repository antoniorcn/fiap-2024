import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [chave, setChave] = useState("");

  return (
    <View style={styles.container}>
      <Text>Teste de Async Storage</Text>
      <StatusBar style="auto" />
      <Text>Nome Completo: </Text>
      <TextInput placeholder='Informe o nome completo...'
        value={nome} onChangeText={setNome}/>
      <Text>Telefone: </Text>
      <TextInput placeholder='Informe o telefone...'
        value={telefone} onChangeText={setTelefone}/>
      <Text>Email: </Text>
      <TextInput placeholder='Informe o email...'
        value={email} onChangeText={setEmail}/>                
      <Button title="Gravar" onPress={()=>{
        const obj = { 
          nome, telefone, email
        }
        const txtObj = JSON.stringify( obj )
        const promessa = AsyncStorage.setItem("OBJETO1", txtObj)
        promessa.catch(( err ) => {
          alert("Erro ao gravar o texto: " + err)
        })
      }}/>
      <Button title="Ler" onPress={()=>{
        const promessa = AsyncStorage.getItem("OBJETO1")
        .then( ( info )=>{
          const obj = JSON.parse( info );
          setNome(obj.nome);
          setTelefone(obj.telefone);
          setEmail(obj.email);
        })
        .catch( (err)=>{
          alert("Erro ao ler a informação: " + err);
        } )
      }}/>
      <Button title="Ler todas as Chaves" onPress={()=>{
        AsyncStorage.getAllKeys()
        .then( ( chaves ) =>{
          alert("Chaves Lidas: " + chaves);
        })
      }}/>
      <TextInput placeholder='Digite o nome da Chave para removê-la'
        value={chave} onChangeText={setChave}/> 
      <Button title="Remover chave" onPress={()=>{
        AsyncStorage.removeItem(chave)
        .then( ()=>{
          alert("A chave " + chave + " foi removida com sucesso");
        })
      }}/>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
