import React from 'react';
import {View, Text, TextInput} from 'react-native';
function LabelInput( props ) {
  /*
    atributos = { 
      "label": "Titulo da Tarefa:",
      "cor": "yellow"
    }
  */
  return(
    <View style={{backgroundColor: props.cor}}>
      <Text>{props.label}</Text>
      <TextInput style={{
        backgroundColor: props.corInput,
        borderColor: "black",
        borderWidth: 2,
        borderRadius: 10,
        height: 30,
        color: props.corInputFont,
        margin: 5
    }}/>
    </View>
  )}
function App() { 
  return(
    <View>
      <Text>HelloWorld</Text>
      <LabelInput label="Titulo da Tarefa:" 
                  corInput="lightgray"  
                  corInputFont="black"
                  cor="yellow"/>
      <LabelInput label="Data Termino"
                  corInput="lightgray"  
                  corInputFont="black"
                  cor="yellow"/>
      <LabelInput label="Prioridade"
                  corInput="lightgray"  
                  corInputFont="red"
                  cor="yellow"/>
    </View>
  )
}

export default App;
