import React from 'react';
import {Text, View, Button, StyleSheet, Image} from 'react-native';
import puppy from './assets/puppy.png';

function App() { 
  const estilos = StyleSheet.create({
    texto: {  flex: 1, 
              textAlignVertical: "center",
              borderBottomColor: "black",
              borderBottomWidth: 2,
              paddingHorizontal: 10}
  })
  return (
    <View style={{flex: 1, backgroundColor: "lightgray"}}>
      <View style={{flex: 1}}>
        <Image source={puppy} style={{width: "100%", height:"100%"}}/>
      </View>
      <View style={{flex: 2}}>
        <Text style={estilos.texto}>Nome do Pet</Text>
        <Text style={estilos.texto}>Raça</Text>
        <Text style={estilos.texto}>Peso</Text>
        <Text style={estilos.texto}>Nascimento</Text>
        <Text style={estilos.texto}>Nome do Dono</Text>
        <Button title="Cadastrar"/>
      </View>
    </View>
  )
}

export default App;