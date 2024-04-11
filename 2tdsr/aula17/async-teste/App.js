import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View, Modal, FlatList} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

const Principal = () => {
  return (
    <View styles={styles.container}>
      <Text style={{fontSize: 28}}>Componente Principal</Text>
    </View>
  );
}

const Login = ( props ) => {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  return (
    <View styles={styles.container}>
      <Text style={{fontSize: 28, marginBottom: 20}}>Login</Text>
      <TextInput  placeholder="Digite seu email..."
        value={email} onChangeText={setEmail}/>
      <TextInput  placeholder="Digite sua senha..." secureTextEntry={true}
        value={senha} onChangeText={setSenha}/>
      <Button title="Login" onPress={()=>{
        props.onLogin( email, senha );
      }}/>
      {/* <Button title="Registrar Usuario" onPress={()=>{
        props.onRegistrar();
      }}/> */}
      <Button title="Registrar Usuario" onPress={props.onRegistrar}/>
    </View>
  );
}


export default function App() {
  const [logado, setLogado] = useState(false);
  const registrar = () => { 
    const obj = {email: "admin@teste.com", senha: "123456"};
    // AsyncStorage.setItem("REGISTRO", 
    //     '{"email": "admin@teste.com", "senha": "123456"}');
    AsyncStorage.setItem("REGISTRO", JSON.stringify( obj ));
  }

  const login = ( email, senha ) => { 
    AsyncStorage.getItem("REGISTRO")
    .then(( strObj ) => {
      const obj = JSON.parse( strObj );
      if (obj.email === email && obj.senha === senha) { 
        setLogado(true);
      }
    })
  }

  return (
    <View style={styles.container}>
      <Principal/>
      <Modal visible={!logado}>
        <Login onRegistrar={registrar} onLogin={login}/>
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
