import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { TextInput, Text, View, Switch, Button } from 'react-native';
function Componente( props ) {
  /*
    props = { label: "Nome"  } 
  */
   return (
    <View style={{flexDirection: "row", 
                  width: "100%",
                  backgroundColor: "yellow"}}>
      <Text style={{flex: 1}}>{props.label}</Text>
      <TextInput style={{borderWidth: 2}}/>
    </View>
   )
}
export default function App() {

  let lista = useState(false);
  let done = lista[0];
  let setDone = lista[1];
  let palavra = "Não Concluido";

  let quantidade = 0;

  function apertado() { 
    alert("Botão foi apertado");
  }

  if (done === true) { 
    palavra = "Concluido";
  }

  function mudarDone() { 
    //done = ! done;
    setDone( !done );
    //alert("Done: " + done);
  }

  return (
    <View style={{flex: 1}}>
      { /* Componente() */ }
      <Componente label="Nome"/>
      <Componente label="Data de Termino"/>
      <View style={{flexDirection: "row"}}>
        <Text>{palavra}</Text>
        <Switch value={done} onValueChange={mudarDone}/>
      </View>
      <Componente label="Prioridade"/>
      <Button title="Salvar" onPress={apertado}/>
      <StatusBar style="auto" />
    </View>
  );
}

