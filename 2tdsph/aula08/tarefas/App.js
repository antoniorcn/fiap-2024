import React, { useState } from 'react';
import { Text, View, Switch, TextInput } from 'react-native';

// function LabelInput( props ) { 
  // props : { 
  //    label : "Texto",
  //    cor: "Cor a ser colocada"
  // }
  // const {label, cor} = props;
function LabelInput( {label, cor} ) {   
  return (
    <View>
      <Text>{label}</Text>
      <TextInput style={{
        borderWidth: 2,
        borderColor: 'red',
        backgroundColor: cor}} />
    </View>
  )
}

export default function App() {
  // const tempLista = useState(false);
  // tempLista = [ <variavel para consultar o dado>,
  //                  <função para modificar o dado> ]
  // const done = tempLista[0];
  // const setDone = tempLista[1];

  const [done, setDone] = useState(false);

  // obj = {
  //   nome: "Tomar banho",
  //   data: "04/03/2024",
  //   prioridade: 1,
  //   concluido : false,
  // }

  const lista = [
    {
      nome: "Tomar banho",
      data: "04/03/2024",
      prioridade: 1,
      concluido : false,
    },
    {
      nome: "Fazer o almoço",
      data: "04/03/2024",
      prioridade: 2,
      concluido : true,
    },  
    {
      nome: "Terminar o Shift",
      data: "06/03/2024",
      prioridade: 2,
      concluido : false,
    },
    {
      nome: "Fazer rotina para tranformar objeto em componente visual",
      data: "04/03/2024",
      prioridade: 1,
      concluido : true,
    },
  ]

  const componentesVisuais = [];
  for(let i = 0; i < lista.length; i++) { 
    const obj = lista[i];

    componentesVisuais.push(
      <View style={{borderWidth: 1, padding: 5}}>
        <Text>Nome: {obj.nome}</Text>
        <Text>Entrega: {obj.data}</Text>
        <Text>Prioridade: {obj.prioridade}</Text>
        <Text>Concluido: {obj.concluido}</Text>
      </View>
    );
  }

/*
  const componentesVisuais = [
    <View style={{borderWidth: 1, padding: 5}}>
      <Text>Nome: Tomar banho</Text>
      <Text>Entrega: 04 / 03 / 2024</Text>
      <Text>Prioridade: 1</Text>
      <Text>Concluido: false</Text>
    </View>,
    <View style={{borderWidth: 1, padding: 5}}>
      <Text>Nome: Fazer o almoço</Text>
      <Text>Entrega: 04 / 03 / 2024</Text>
      <Text>Prioridade: 2</Text>
      <Text>Concluido: true</Text>
    </View>,
    <View style={{borderWidth: 1, padding: 5}}>
      <Text>Nome: Terminar o Shift</Text>
      <Text>Entrega: 06 / 03 / 2024</Text>
      <Text>Prioridade: 2</Text>
      <Text>Concluido: false</Text>
    </View>
  ]
  */

  return (
    <View>
      <Text>Hello Tarefas</Text>
      <LabelInput label="Nome da tarefa: " cor="lightcyan"/>
      <LabelInput label="Data entrega: " cor="lightcyan"/>
      <LabelInput label="Prioridade: " cor="lightgray"/>
      <Switch value={done} onValueChange={setDone}/>
      {componentesVisuais}
    </View>
  );
}