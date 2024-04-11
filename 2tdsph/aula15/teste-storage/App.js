import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View, ToastAndroid, TextInput} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage'; 
import { useState } from 'react';

export default function App() {
  const [logado, setLogado] = useState(false);
  const [permiteRegistro, setPermiteRegistro] = useState(true);
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  AsyncStorage.getItem("USER")
  .then((strObj)=>{
    const obj = JSON.parse( strObj );
    if (obj.email != undefined) { 
      setPermiteRegistro(false);
    }
  })
  .catch((erro)=>{
    setPermiteRegistro(true);
  })

  return (
    <View style={styles.container}>
      { logado ?
        <View style={styles.container}> 
          <Text>Menu Principal da Aplicação</Text>
          <Button title="Logout" onPress={()=>{
            setLogado(false);
          }}/>
        </View>
        :
        <View style={styles.container}> 
          <Text>Login</Text>
          <TextInput placeholder="Informe o email"
            value={email} onChangeText={setEmail}/>
          <TextInput placeholder="Informe a senha"
             secureTextEntry={true} 
             value={senha} onChangeText={setSenha}/>
          <Button title="Login" onPress={()=>{
            AsyncStorage.getItem("USER") 
            .then((strObj)=>{
              if (strObj !== undefined) {
                const obj = JSON.parse(strObj);
                if (obj.email === email && obj.senha === senha){
                  setLogado(true);
                } else { 
                  setLogado(false);
                  ToastAndroid.show("Usuário ou senha estão incorretos", ToastAndroid.LONG);
                }
              } else { 
                ToastAndroid.show("Erro ao ler o usuário registrado", ToastAndroid.LONG);
              }
            })
            .catch((err)=>{
              ToastAndroid.show("Erro ao fazer o login " + err, ToastAndroid.LONG);
              setLogado(false);
            })
          }}/>
          <Button title="Registrar" disabled={!permiteRegistro}
          onPress={()=>{
            const obj = {email, senha};
            AsyncStorage.setItem("USER", 
                        JSON.stringify(obj))
            .then(()=>{
              ToastAndroid.show("Usuario registrado", 
                                ToastAndroid.LONG);
            })
            .catch(()=>{
              ToastAndroid.show("Não foi possível registrar o usuário", 
                                ToastAndroid.LONG);
            })
          }}/>
        </View>
      }
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
