import React from "react";
import {View,Text,TextInput} from "react-native-web";
function LabelInput (props){
  function LabelInput(props) {
  /* atributos ={
    "label": "Titulo da Tarefa:",
    "cor": "yellow"
  }
  ?
  */
 //let cor =props.cor;
 //let label = props.label;
 //let corInput = props.corInput;
 //let corInputFont = props.corInputFont;
 
    return(
      <View style = {{BackgrondColor: props.cor}}>
        <Text>{props.label}</Text>
        <TextInput style = {{BackgrondColor: "navy",
         borderColor:atributos.corInput,
         borderWidth: 2,
         borderRadius: 10,
         height:30,
         color:props.corInputFont,
         margin: 5
      }}/>
      </View>
    )
  }
  function App(){
    return(
    <View>
      <Text>HelloWord</Text>
      <LabelInput label = "Titulo da Tarefa:"
                  corInput="lightgray"
                  corInputFont = "black"
                  cor="yellow"/>
      <LabelInput label= "Data Termino"
                  corInput="lightgray"
                  corInputFont = "black"
                  cor="yellow"/>
      <LabelInput label= "Prioridade"
                  corInput="lightgray"
                  corInputFont = "black"
                  cor="yellow"
      />
    </View>
    )
  }
}
  export default App;