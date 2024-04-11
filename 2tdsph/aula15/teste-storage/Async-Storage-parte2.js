import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View, ToastAndroid} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage'; 

export default function App() {
  const lista = [1, 2, 3, "João", "Maria", 
     {nome: "Alberto", telefone:"11-1111-1111", email: "alberto@teste.com"}]
  const strLista = JSON.stringify( lista );
  return (
    <View style={styles.container}>
      <Text>Teste AsyncStorage</Text>
      <Text>Texto: {strLista}</Text>
      <Button title="Salvar" onPress={()=>{
        const promessa = AsyncStorage.setItem("LISTA", strLista);
        promessa.then( ()=> { 
          ToastAndroid.show("Foi gravado com sucesso", ToastAndroid.LONG)});
        promessa.catch( (err)=> { 
          ToastAndroid.show("Erro ao gravar: " + err, ToastAndroid.LONG)});
        // Linha é executada mesmo antes do promisse ser executado
        ToastAndroid.show("Linha executada", ToastAndroid.LONG);
      }} />
      <Button title="Ler" onPress={()=>{
        const promessa = AsyncStorage.getItem("LISTA");
        promessa.then( (info)=>{ 
          ToastAndroid.show("Informação lida com sucesso ==> " + info, ToastAndroid.LONG);
          const novaLista = JSON.parse(info);
          ToastAndroid.show("Telefone:  ==> " + novaLista[5].telefone, ToastAndroid.LONG);
        });
        promessa.catch( (err) => {
          ToastAndroid.show("Erro ao ler: " + err, ToastAndroid.LONG);});
        // Linha é executada mesmo antes do promisse ser executado
        ToastAndroid.show("Linha executada", ToastAndroid.LONG);
      }}/>
      <Button title="Ver as Chaves" onPress={()=>{
        // const promessa = AsyncStorage.getAllKeys();
        // promessa.then( ()=>{} );
        // promessa.catch( ()=>{} ); 
        AsyncStorage.getAllKeys()
        .then( (chaves)=>{
          ToastAndroid.show("Chaves: " + chaves, ToastAndroid.LONG);
        })
        .catch( (err)=>{
          ToastAndroid.show("Erro ao ler: " + err, ToastAndroid.LONG);
        });
      }}/>
      <Button title="Remover Chave NOME" onPress={()=>{
        AsyncStorage.removeItem("NOME")
        .then(()=> {
          ToastAndroid.show("Chave nome removida", ToastAndroid.LONG);
        })
        .catch((err)=>{
          ToastAndroid.show("Erro ao ler: " + err, ToastAndroid.LONG);
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
