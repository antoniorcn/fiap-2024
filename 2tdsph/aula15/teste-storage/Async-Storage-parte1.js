import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View, ToastAndroid} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage'; 

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Teste AsyncStorage</Text>
      <Button title="Salvar" onPress={()=>{
        const promessa = AsyncStorage.setItem("NOME", "João Silva");
        promessa.then( ()=> { 
          ToastAndroid.show("Foi gravado com sucesso", ToastAndroid.LONG)});
        promessa.catch( (err)=> { 
          ToastAndroid.show("Erro ao gravar: " + err, ToastAndroid.LONG)});
        // Linha é executada mesmo antes do promisse ser executado
        ToastAndroid.show("Linha executada", ToastAndroid.LONG);
      }} />
      <Button title="Ler" onPress={()=>{
        const promessa = AsyncStorage.getItem("NOME");
        promessa.then( (info)=>{ 
          ToastAndroid.show("Informação lida com sucesso ==> " + info, ToastAndroid.LONG) });
        promessa.catch( (err) => {
          ToastAndroid.show("Erro ao ler: " + err, ToastAndroid.LONG);});
        // Linha é executada mesmo antes do promisse ser executado
        ToastAndroid.show("Linha executada", ToastAndroid.LONG);
      }}/>
      <Button title="Ver as Chaves" onPress={()=>{
        const promessa = AsyncStorage.getAllKeys();

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
