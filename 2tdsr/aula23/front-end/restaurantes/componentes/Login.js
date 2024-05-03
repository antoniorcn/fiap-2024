import {Button, Text, TextInput, View} from 'react-native';
import { useState, useContext } from 'react';
import { notificar } from '../control/cardapioControl';
import Contexto from '../contexto/contexto';

export const Login = ( props ) => {
    const ctx = useContext( Contexto );
    const [email, setEmail] = useState("admin@teste.com");
    const [password, setPassword] = useState("abc123");

    return (
    <View style={{flex: 1}}>
        <Text style={{fontSize: 38}}>Tela de Login</Text>
        <TextInput placeholder="informe o email"
        value={email} onChangeText={setEmail}/>
        <TextInput placeholder="informe a senha" 
        secureTextEntry={true}
        value={password} onChangeText={setPassword}/>
        <Button title="Login" onPress={()=>{
            if (ctx.logar( email, password )) {
                props.navigation.navigate("Formulario");
            } else { 
                notificar("Usuario ou senha inválidos");
            }
        }}/>
    </View>
    )
}

export default { Login }