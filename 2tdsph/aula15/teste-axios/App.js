import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, ToastAndroid, View } from 'react-native';
import axios from 'axios';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>Teste do Axios</Text>
      <StatusBar tyle="auto" />
      <Button title="Ler" onPress={()=>{
        axios.get("https://tdsph-ee91f-default-rtdb.firebaseio.com/contatos.json")
        .then(( response )=>{
          console.log("Dados: ", response.data);
          ToastAndroid.show("GET Efetuado com sucesso", ToastAndroid.LONG);
        })
        .catch(()=>{
          ToastAndroid.show("Erro ao fazer o GET", ToastAndroid.LONG);
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
