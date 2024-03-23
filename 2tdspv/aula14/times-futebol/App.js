import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, ImageBackground, StyleSheet, Text,
          TextInput, View, ScrollView } from 'react-native';
import imgEstadio from './assets/futebol-estadio.jpg';
import {useState} from 'react';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'stretch',
    justifyContent: 'flex-start',
  },
  image : { 
    flex: 1,
    width: "100%",
    height: "20%"
  },
  titulo: { 
    textAlign: "center",
    fontSize: 24,
    color: "gray",
    backgroundColor: "#FFFF8090",
    marginHorizontal: 20,
    marginVertical: 20,
    padding: 5,
    borderRadius: 20,
  },
  formulario: {
    backgroundColor: "lightcyan",
    flex: 2
  },
  listagem: { 
    backgroundColor: "lightyellow",
    flex: 2
  },
  input: { 
    backgroundColor: "white",
    borderColor: "red",
    borderWidth: 1,
    borderRadius: 20
  },
  item: { 
    borderWidth: 1,
    borderColor: "red",
    margin: 5,
    padding: 5,
  }
});


const Item = ( props ) => {
  return (
    <View>
      <Text>{props.item.nomeTime}</Text>
      <Text>{props.item.nomeJogador}</Text>
    </View>
  )
}


export default function App() {
  const [nomeTime, setNomeTime] = useState("");
  const [nomeJogador, setNomeJogador] = useState("");
  const [numeroCamisa, setNumeroCamisa] = useState("");
  const [posicaoCampo, setPosicaoCampo] = useState("");
  const [lista, setLista] = useState([]);

  return (
    <View style={styles.container}>
      <ImageBackground style={styles.image}
          source={imgEstadio} 
          resizeMethod='auto' resizeMode='cover'>
        <Text style={styles.titulo}>Escalação de Times</Text>
      </ImageBackground>
      <View style={styles.formulario}>
        <Text>Nome do Time:</Text>
        <TextInput style={styles.input}
          value={nomeTime} onChangeText={setNomeTime}/>
        <Text>Nome do Jogador:</Text>
        <TextInput style={styles.input}
          value={nomeJogador} onChangeText={setNomeJogador}/>
        <Text>Numero da Camiseta: </Text>
        <TextInput style={styles.input}
          value={numeroCamisa} onChangeText={setNumeroCamisa}/>
        <Text>Posição no Campo</Text>
        <TextInput style={styles.input}
          value={posicaoCampo} onChangeText={setPosicaoCampo}/>
        <Button title="Salvar" onPress={()=>{
          const obj = {nomeTime, nomeJogador, numeroCamisa, 
                      posicaoCampo}
          setLista( [...lista, obj] )
        }}/>
      </View>
      <FlatList 
        data={lista}
        renderItem={Item}
        keyExtractor={(obj)=>{return obj.nomeJogador}}
        style={styles.listagem}
      /> 
    </View>
  );
}


