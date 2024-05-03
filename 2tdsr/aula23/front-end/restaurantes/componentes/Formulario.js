import { useState } from 'react';
import { Button, Text, TextInput, View } from 'react-native';

export const Formulario = ( props ) => { 
    const [nome, setNome] = useState("");
    const [tipo, setTipo] = useState("");
    const [calorias, setCalorias] = useState("");
    const [imagem, setImagem] = useState("");
    const [ingredientes, setIngredientes] = useState("");
    return (
      <View style={{flex: 1}}>
        <Text style={{fontSize: 38}}>Tela de Formulário</Text>
        <TextInput placeholder="Nome da refeição" 
          value={nome} onChangeText={setNome}/>
        <TextInput placeholder="Tipo da refeição" 
          value={tipo} onChangeText={setTipo}/>
        <TextInput placeholder="Calorias" 
          value={calorias} onChangeText={setCalorias}/>
        <TextInput placeholder="Nome da imagem" 
          value={imagem} onChangeText={setImagem}/>
        <TextInput placeholder="Ingredientes" 
          numberOfLines={5} multiline={true}
          scrollEnabled={true} 
          value={ingredientes} onChangeText={setIngredientes}/>
        <Button title="Salvar" onPress={()=>{
          const obj = { nome, tipo, calorias, imagem, ingredientes };
          props.onSalvar( obj );
        }}/>        
        <Button title="Listagem" onPress={()=>{
          props.navigation.navigate("Listagem")
        }}/>
        <Button title="Logout" onPress={()=>{
          props.navigation.navigate("Login")
        }}/>
      </View>
    )
  }

  export default { Formulario }