import React from 'react';
import {Text, View, StyleSheet} from 'react-native';


function App () { 

  const paddingTextos = 10;

  const sombras = StyleSheet.create({
    texto: {
      textShadowColor: "black",
      textShadowRadius: 10,
      textShadowOffset: {width: -15, height: -10},
    },
    caixa: {
      shadowColor: "red",
      shadowOffset: {width: 10, height: 10},
      shadowRadius: 5,
      shadowOpacity: 0.9
    }
  })

  const generico = StyleSheet.create({
    espaco: {
      padding: paddingTextos,
      margin: 20
    }
  });

  const titulo = StyleSheet.create({
    fonte: {
      fontWeight: "bold",
      fontSize: 36,
      backgroundColor: "cyan",
      color: 'rgba( 255, 0, 255, 0.05 )'
    },
  })

  const subTitulo = StyleSheet.create({
    fonte: {
      fontWeight: "200",
      fontSize: 28,
      backgroundColor: "yellow",
    },
  })

  const a1 = "Ola...";
  return (
    <View style={{
        position: "absolute",
        backgroundColor: "deepskyblue",
        width: "100%",
        height: "100%"
        }}>
      <Text style={[titulo.fonte, 
          generico.espaco,
          sombras.texto,
          sombras.caixa]}>{a1}</Text>
      <Text style={[subTitulo.fonte, 
        generico.espaco,
        sombras.texto,
        sombras.caixa, {left: 0, top: 200, width: 150, height: 100}]}>World</Text>
    </View>
  )
}

export default App;