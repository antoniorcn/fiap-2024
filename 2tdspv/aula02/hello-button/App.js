import React from 'react';
import {Text, View, Button} from 'react-native';

function apertado() { 
  alert("Botão apertado");
}

function App() {
  const vermelho = {backgroundColor:"red"};
  const amarelo = {
    backgroundColor:"yellow",
    padding: 50};

  return (
    <View style={amarelo}>
      <Text style={vermelho}>Hello World</Text>
      <Button title="Aperte-me" onPress={apertado}/>
    </View>
  );
}

export default App;

/*

  <View>     .....      </View>
  <Text> coloca seu texto </Text>

  <Button title="nome do botão"/>

*/
