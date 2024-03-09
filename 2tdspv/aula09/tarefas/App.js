import {  Button, Image, 
          ImageBackground, 
          StyleSheet, Switch, 
          Text, TextInput, View } from 'react-native';
import { useState } from 'react';
import imgTarefas from './assets/tarefas.webp';

const estilos = StyleSheet.create({
  principal: {
    flex: 1,
    backgroundColor: 'lightgray',
    alignItems: 'stretch',
    justifyContent: 'center',
  },
  titulo: {
    fontSize: 28,
    backgroundColor: "#AAAA",
    padding: 20,
    borderRadius: 10
  }
});

export default function App() {
  // { nome: "Estudar React", 
  //     data: "15/03/2024", 
  //     prioridade: 1,
  //     concluido: false}, 
  //   { nome: "Fazer exerício 09", 
  //     data: "12/03/2024", 
  //     prioridade: 2,
  //     concluido: true}
  const [lista, setLista] = useState( [] );

  const [nome, setNome] = useState("");
  const [data, setData] = useState("");
  const [prioridade, setPrioridade] = useState("");
  const [concluido, setConcluido] = useState(false);
  

  function mapa( obj, idx ) { 
    return (
      <View key={idx}>
        <Text>{obj.nome}</Text>
        <Text>{obj.data}</Text>
        <Text>{obj.prioridade}</Text>
      </View>
    )
  }

  const listaVisuais = lista.map( mapa )

  const salvar = () => {
    const obj = {
      nome: nome,
      data: data,
      prioridade: prioridade,
      concluido: concluido
    }
    setLista( [ ...lista, obj ] )   
  }

  return (
    <View style={estilos.principal}>
      <View style={{flex: 2}}>
        <ImageBackground source={imgTarefas} 
                resizeMethod="auto" 
                resizeMode="cover"
                style={{flex: 1, 
                justifyContent:"center",
                alignItems: "center"}}>
          <Text style={estilos.titulo}>Gestão de Tarefas</Text>
        </ImageBackground>
      </View>
      <View style={{flex: 3, padding: 30}}>
        <Text>Nome do Tarefa:</Text>
        <TextInput value={nome} onChangeText={setNome}/>
        <Text>Data conclusão:</Text>
        <TextInput value={data} onChangeText={setData}/>
        <Text>Prioridade:</Text>
        <TextInput value={prioridade} onChangeText={setPrioridade}/>
        <Switch value={concluido} onValueChange={
            () => { 
              if (concluido) { 
                setConcluido(false)
              } else { 
                setConcluido(true)
              }
            }
        }/>
        <Button title="Salvar" onPress={ salvar }/>
      </View>
      <View style={{flex: 3, padding: 5}}>
        {listaVisuais}
      </View>
    </View>
  );
}
