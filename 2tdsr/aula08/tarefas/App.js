import React, {useState} from 'react';
import { Button, Switch, Text, TextInput, View } from 'react-native';

const estilos = {
  input: {  backgroundColor: "lightcyan", 
            borderColor: "red",
            borderWidth: 1,
            borderRadius: 15 }
}

function App() { 
/*
     [ Variavel para consultar a área de memória,
          Função para modificar a área de memória     ]
            */
  // const lista = useState(true);
  // const concluido = lista[0];  // Variavel para consultar a área de memória
  // const setConcluido = lista[1]; // Função para modificar a área de memória

  const [concluido, setConcluido] = useState(false);

  function mudarValor() { 
    if (concluido === false) { 
      // concluido = true;  
      setConcluido(true);
    } else { 
      // concluido = false;
      setConcluido(false);
    }
    // alert("Concluido: " + concluido);
  }

  const [tarefa, setTarefa] = useState("");
  const [dataTermino, setDataTermino] = useState("");
  const [prioridade, setPrioridade] = useState("");

  return (
    <View style={{flex: 1, padding: 30}}>
      <Text style={{fontSize: 18}}>Gestor de Tarefas</Text>
      <Text>Tarefa:</Text>
      <TextInput  value={tarefa} 
                  style={estilos.input}
                  onChangeText={setTarefa}/>
      <Text>Data Termino:</Text>
      <TextInput  value={dataTermino} 
                  style={estilos.input}
                  onChangeText={setDataTermino}/>
      <Text>Prioridade</Text>
      <TextInput  style={estilos.input}
                  value={prioridade}
                  onChangeText={setPrioridade}
      />
      <View style={{flexDirection: "row"}}>
        <Text>Concluido: </Text>
        <Switch value={concluido} onValueChange={mudarValor}/>
      </View>
      <Button title="Salvar" color="navy"/>
    </View>
  );
}

export default App;