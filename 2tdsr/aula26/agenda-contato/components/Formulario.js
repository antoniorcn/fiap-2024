import { useState } from 'react';
import { View, TextInput, Button } from 'react-native';
export default Formulario = ( props ) => { 
    const [nome, setNome] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
  
    return (
      <View style={{flex: 1}}>
        <TextInput placeholder="Nome completo" 
          value={nome} onChangeText={setNome}/>
        <TextInput placeholder="Telefone"
          value={telefone} onChangeText={setTelefone}/>
        <TextInput placeholder="Email"
          value={email} onChangeText={setEmail}/>
        <Button title="Gravar" onPress={()=>{
          props.onGravar( {nome, telefone, email} );
        }} />
      </View>
    )
  }