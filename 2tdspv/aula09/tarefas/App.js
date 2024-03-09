import {  Button, Image, 
          ImageBackground, 
          StyleSheet, Switch, 
          Text, TextInput, View } from 'react-native';
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
  const lista = [
    { nome: "Estudar React", 
      data: "15/03/2024", 
      prioridade: 1,
      concluido: false}, 
    { nome: "Fazer exerício 09", 
      data: "12/03/2024", 
      prioridade: 2,
      concluido: true}
  ] 
  

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
        <TextInput/>
        <Text>Data conclusão:</Text>
        <TextInput/>
        <Text>Prioridade:</Text>
        <TextInput/>
        <Switch value={false}/>
        <Button title="Salvar"/>
      </View>
      <View style={{flex: 3, padding: 5}}>
        {listaVisuais}
      </View>
    </View>
  );
}
