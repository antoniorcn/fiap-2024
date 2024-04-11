import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

export default function App() {
  const [texto, setTexto] = useState("");

  return (
    <View style={styles.container}>
      <Text>Teste de Async Storage</Text>
      <StatusBar style="auto" />
      <TextInput placeholder='Digite algo...'
        value={texto} onChangeText={setTexto}/>
      <Button title="Gravar" onPress={()=>{
        // const promessa1 = AsyncStorage.setItem("NOME", "João Silva")
        //                                     Chave       Valor
        const promessa = AsyncStorage.setItem("MEU_TEXTO", texto)
        promessa.then(() => {
          alert("Texto foi gravado com sucesso")
        })
        promessa.catch(( err ) => {
          alert("Erro ao gravar o texto: " + err)
        })
        // alert("Foi pedido para gravar no asyncstorage")
      }}/>
      <Button title="Ler" onPress={()=>{
        const promessa = AsyncStorage.getItem("MEU_TEXTO")
        .then( ( info )=>{
          // alert("Informação lida com sucesso: " + info);
          setTexto(info);
        })
        .catch( (err)=>{
          alert("Erro ao ler a informação: " + err);
        } )
        // alert("Lendo chave MEU_TEXTO");
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
