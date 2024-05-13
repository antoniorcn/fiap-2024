import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';
import MapView, { Marker } from 'react-native-maps';
import { useEffect, useRef, useState } from 'react';

export default function App() {
  const [zoom, setZoom] = useState(1);
  const latDelta = 0.0922 / zoom;
  const lonDelta = 0.0421 / zoom;
  const mapRef = useRef(null);

  const [titulo, setTitulo] = useState("");
  const [descricao, setDescricao] = useState("");
  const [latitude, setLatitude] = useState("");
  const [longitude, setLongitude] = useState("");

  const [listaPontos, setListaPontos] = useState([
    {title: "Masp", description: "Museu de Arte de São Paulo",
    latitude: -23.56131565602221, longitude: -46.65580679820002},

    {title: "Estação Paraiso", description: "Estação de Metrô Paraiso - Linha Azul",
    latitude: -23.57512823325926, longitude: -46.64025131350388}
  ]);

  useEffect(()=>{
    const region = {
      latitude: -23.56436658522442, 
      longitude: -46.65243330991436,
      latitudeDelta: latDelta,
      longitudeDelta: lonDelta
    };
    mapRef.current.animateToRegion(region);
  }, [zoom])

  return (
    <View style={styles.container}>
      <Text>Open up App.js to start working on your app!</Text>
      <StatusBar style="auto" />
      <View style={{flex: 4}}>
        <TextInput placeholder="Titulo" value={titulo} onChangeText={setTitulo}/>
        <TextInput placeholder="Descrição" value={descricao} onChangeText={setDescricao}/>
        <TextInput placeholder="Latitude" value={latitude} onChangeText={setLatitude}/>
        <TextInput placeholder="Longitude" value={longitude} onChangeText={setLongitude}/>
        <Button title="Salvar" onPress={()=>{
          const region = { 
            title: titulo,
            description: descricao,
            latitude: parseFloat(latitude),
            longitude: parseFloat(longitude)
          }
          setListaPontos([...listaPontos, region]);
          mapRef.current.animateToRegion(region);
        }}/>
      </View>
      <View style={{flex: 15}}>
        <Button title="Zoom (-)" onPress={()=>{
          if (zoom > 1) {
            setZoom(zoom - 1);
          }
        }}/>
        <Button title="Zoom (+)" onPress={()=>{
          if (zoom < 10) {
            setZoom(zoom + 1);
          }
        }}/>
        <MapView style={{flex: 1}} ref={mapRef}
          initialRegion={{
            latitude: -23.56436658522442, 
            longitude: -46.65243330991436,
            latitudeDelta: latDelta,
            longitudeDelta: lonDelta
          }}>
            {listaPontos.map(( token )=> {
              const reg = {latitude: token.latitude, 
                longitude: token.longitude}
              return (
                <Marker 
                  title={token.title}
                  description={token.description}
                  coordinate={reg}
                />)}
              )}
            
        </MapView>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff'
  },
});
