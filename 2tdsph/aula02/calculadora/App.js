import React, {useState} from 'react';
import {Text, TextInput, Button, View} from 'react-native';


function App() { 
  const [num1, setNum1] = useState("10");
  const [num2, setNum2] = useState("0");

  function somar() { 
    let soma = parseInt(num1) + parseInt(num2);
    console.log("Soma: ", soma);
    alert("Soma: " + soma);
  }

  return (
    <View style={{position: "absolute", 
                  top: 200, 
                  left: 200,
                  padding: 50,
                  backgroundColor: "lightcyan"}}>
      <Text style={{
        fontSize: 20
      }}>Digite o 1º numero</Text>
      <TextInput style={{
        backgroundColor: "lightyellow"
      }}
          value={num1}
          onChangeText={setNum1}/>
      <Text style={{
        fontSize: 20
      }}>Digite o 2º numero</Text>
      <TextInput style={{
        backgroundColor: "lightyellow"
      }}
          value={num2}
          onChangeText={setNum2}/>
      <Button title="Somar" onPress={somar}/>
    </View>
  );
}

export default App;