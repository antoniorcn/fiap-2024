import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Alert, Button, Modal, Pressable, StyleSheet, Text, 
  View, TextInput, ToastAndroid, TouchableHighlight } from 'react-native';

export default function App() {
  const [precisaLogin, setPrecisaLogin] = useState(true);
  return (
    <View style={styles.container}>
      <StatusBar style="auto"/>
      <Text selectable={true}>Teste de Texto </Text>
      <TextInput numberOfLines={5} style={{borderWidth: 2}}
      keyboardType='email-address' multiline={true}/>
      <Button title="Aperte-me" onPress={()=>{
        // Alert.alert("Titulo", "Mensagem");
        ToastAndroid.show("O botão foi apertado", 
          ToastAndroid.LONG
        );
      }}/>
      <TouchableHighlight onPress={()=>{
        ToastAndroid.show("Botão customizado foi apertado",
        ToastAndroid.LONG)
      }}>
        <Text style={{backgroundColor: "lime", 
                fontSize: 32,
                marginHorizontal: 20,
                marginVertical: 5,
                paddingHorizontal: 20,
                paddingVertical: 5,
                borderRadius: 20,
                shadowColor: "black",
                shadowRadius: 10,
                shadowOffset: {height: 3, width: 3},
                elevation: 15
                }}>Aperte-me</Text>
      </TouchableHighlight>
      <Button title="Logout"  onPress={()=>{
        setPrecisaLogin(true);
      }}/>
      <Modal style={{flex: 1}} visible={precisaLogin}
        transparent={true}
      >
        <View style={{flex: 1, backgroundColor: "#FFFFFFBB"}} >
          <Text>Você não está logado</Text>
          <Text>Por favor faça o login</Text>
          <Text> Usuário: </Text>
          <TextInput/>
          <Text> Senha: </Text>
          <TextInput/>
          <Button title="Login" onPress={()=>{
            setPrecisaLogin(false);
          }}/>
        </View>
      </Modal>
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
