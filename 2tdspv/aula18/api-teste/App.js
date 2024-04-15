import { useState } from 'react'; 
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';
import axios from 'axios';

export default function App() {
  const [nome, setNome] = useState("")
  const [telefone, setTelefone] = useState("")
  const [email, setEmail] = useState("")
  return (
    <View style={styles.container}>
      <Text>Teste do Axios</Text>
      <StatusBar style="auto" />
      <TextInput placeholder="Nome Completo"
        value={nome} onChangeText={setNome}/>
      <TextInput placeholder="Telefone"
        value={telefone} onChangeText={setTelefone}/>
      <TextInput placeholder="Email"
        value={email} onChangeText={setEmail}/>
      <Button title="Gravar" onPress={()=>{
          const promessa = axios.post(
            "https://tdspv-9707b-default-rtdb.firebaseio.com/contatos.json",
            {nome, telefone, email});
          promessa.then( (reponse)=>{
            alert("Contato cadastrado com sucesso: " + reponse.data.name);
          } );
          promessa.catch( (err)=>{
            alert("Erro: " + err);
          } );
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
