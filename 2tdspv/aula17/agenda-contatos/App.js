import {useState} from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, ToastAndroid, View } from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
export default function App() {
  const  [texto, setTexto] = useState("");
  return (
    <View style={styles.container}>
      <Text style={{fontSize:36}}>
        Teste de Async Storage</Text>
      <TextInput placeholder="Digite algo..."
        value={texto} onChangeText={setTexto}/>
      <Button title="Gravar" onPress={()=>{
        AsyncStorage.setItem("TEXTO", texto)
        .then(()=>{
          ToastAndroid.show("Texto gravado", ToastAndroid.LONG)})
        .catch(()=>{
          ToastAndroid.show("Erro ao gravar o Texto", ToastAndroid.LONG)})
      }}/>

      <Button title="Ler" onPress={()=>{
        AsyncStorage.getItem("TEXTO")
        .then(( info )=>{
          setTexto(info);
          ToastAndroid.show("Texto lido com sucesso", ToastAndroid.LONG)
        })
        .catch(( err )=>{
          ToastAndroid.show("Erro ao ler o Texto", ToastAndroid.LONG)
        })
      }}/>
      <StatusBar style="auto" />
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
