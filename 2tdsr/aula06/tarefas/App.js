import { useState } from 'react';
import { Button, Text, View, TextInput, Switch } 
              from 'react-native';

function LabelInput( props ) { 
  /*
    props : {
      label: "Tarefa: ",
      cor: "yellow"
    }
  */
  return (
    <View style={{backgroundColor: props.cor, 
                  padding: 10, flex: 1}}>
      <Text>{props.label}</Text>
      <TextInput style={{ borderWidth: 2, 
                          borderRadius: 10,
                          height: 35,
                          backgroundColor: "navy"}}/>
    </View>
  );
}


export default function App() {
  let temp = useState( false ); 
  // temp [<consulta a area de memoria>, <funcao que altera>] 
  let feita = temp[0];
  let setFeita = temp[1];

  function teste() { 
    if (feita === false) { 
      setFeita(true);
    } else { 
      setFeita(false);
    }
    // alert("Feita: " + feita);
  }

  return (
    <View style={{flexDirection: "column", 
                    flex: 1}}>
      <Text>Tarefas</Text>
      <LabelInput label="Tarefa: " cor="lightgray"/>
      <LabelInput label="Data Termino: " cor="lightgray"/>
      <LabelInput label="Prioridade: " cor="lightgray"/>
      <View style={{flexDirection: "row", 
                    justifyContent: "space-between",
                    padding: 10,
                    flex: 1,
                    backgroundColor: "lightgray"}}>
        <Text>Concluido</Text>
        <Switch value={feita} onValueChange={teste}/>
      </View>
      <Button title="Salvar" color="navy"/>
    </View>
  );
}
