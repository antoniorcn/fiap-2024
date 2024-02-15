import React from 'react';
import {View, Text, StyleSheet} 
    from 'react-native';


function App() { 
  const titulo = {fontSize: 30};
  const amarelo = {backgroundColor: "yellow"};
  const azul = {backgroundColor: "blue"};

  const estilos = StyleSheet.create({
    titulo: {fontSize: 30},
    amarelo: {backgroundColor: "yellow"},
    azul: {backgroundColor: "blue"},
    sombra: {
      shadowRadius: 5,
      shadowColor: "red",
      shadowOffset: {width: 3, height: 3}
    },
    sombraTexto: {
      textShadowRadius: 15,
      textShadowColor: "black",
      textShadowOffset: {width: 8, height: 8}
    },
    acima: {
      top: 50,
      left: 30,
      width: 150,
    },
    
    centroVertical : {
      top: 300,
    },

    abaixo: { 
      top: 500,
      height: 60
    }
  });

  return (
    <View style={{position: 'absolute'}}>
      <Text style={[estilos.titulo, 
            estilos.amarelo,
            estilos.sombra,
            estilos.sombraTexto,
            estilos.acima]}>Ola</Text>
      <Text style={[estilos.titulo, 
            estilos.azul,
            estilos.sombra,
            estilos.sombraTexto,
            estilos.abaixo]}>Mundo</Text>
    </View>
  );
}

export default App;