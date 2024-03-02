import React from 'react';
import {View, Text, TextInput} from 'react-native';

function LabelInput( {cor, label, 
                          corInput, corInputFont} ) {

  //function LabelInput( props ) {
  /*
    props = { 
      "label": "Titulo da Tarefa:",
      "cor": "yellow"
    }
  */
  // let cor = props.cor;
  // let label = props.label;
  // let corInput = props.corInput;
  // let corInputFont = props.corInputFont;
  // let {label, cor} = props;
  const estilos = {
  textInput : {
      backgroundColor: corInput,
      borderColor: "black",
      borderWidth: 2,
      borderRadius: 10,
      height: 30,
      color: corInputFont,
      margin: 5
    }
  };

  return(
    <View style={{backgroundColor: cor}}>
      <Text>{label}</Text>
      <TextInput style={estilos.textInput}/>
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
