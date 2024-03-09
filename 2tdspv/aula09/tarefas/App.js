import {  Button, Image, 
          StyleSheet, Switch, 
          Text, TextInput, View } from 'react-native';
import imgTarefas from './assets/tarefas.webp';

const estilos = StyleSheet.create({
  principal: {
    flex: 1,
    backgroundColor: 'lightgray',
    alignItems: 'center',
    justifyContent: 'center',
  },
  titulo: {
    fontSize: 28
  }
});


export default function App() {
  return (
    <View style={estilos.principal}>
      <View style={{flex: 2}}>
        <Image source={imgTarefas} resizeMethod="auto" 
                resizeMode="cover"/>
        <Text style={estilos.titulo}>Gestão de Tarefas</Text>
      </View>
      <View style={{flex: 3}}>
        <Text>Nome do Tarefa:</Text>
        <TextInput/>
        <Text>Data conclusão:</Text>
        <TextInput/>
        <Text>Prioridade:</Text>
        <TextInput/>
        <Switch value={false}/>
        <Button title="Salvar"/>
      </View>

    </View>
  );
}
