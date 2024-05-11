import {useState} from 'react';
import {Button, Text, TextInput, View} from 'react-native';

export const Login = (props) => { 
    const [usuario, setUsuario] = useState("");
    const [senha, setSenha] = useState("");
    return ( 
      <View>
        <Text>Login</Text>
        <TextInput placeholder="Usuario:" 
          value={usuario} onChangeText={setUsuario}/>
        <TextInput placeholder="Senha:"
          value={senha} onChangeText={setSenha} secureTextEntry={true}/>
        <Button title="Login" onPress={()=>{
          props.onLogar(usuario, senha);
        }}/>
      </View>
    )
  }
  
export default { Login }