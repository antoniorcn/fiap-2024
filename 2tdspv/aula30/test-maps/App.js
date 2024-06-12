import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';
import MapView, {Marker} from 'react-native-maps';
import { useState, useRef } from 'react'
export default function App() {
  const [lista, setLista] = useState([]);
  const mapaRef = useRef(null);
  return (
    <View style={{flex: 1}}>
      <Text>Mapa do Google</Text>
      <Button title="Regiao Aleatoria" 
      onPress={()=>{
        const obj = lista[0];
        mapaRef.current.animateToRegion({ longitude: obj.longitude, latitude: obj.latitude,
          latitudeDelta: 0.004, longitudeDelta: 0.004}, 1000);
      }}
      />
      <MapView ref={mapaRef} style={{flex: 1}} initialRegion={{
        latitude: -23.564316580274077, longitude: -46.652427518019735,  
        latitudeDelta: 0.00922,  longitudeDelta: 0.00421 }}
      onPress={(e)=>{
        console.log("Coordinate: ", e.nativeEvent.coordinate)
        console.log("Position: ", e.nativeEvent.position)
        const obj = { ... e.nativeEvent.coordinate,  title: "Titulo",  description: "Descrição" }
        setLista( [ ...lista, obj ])
      }}
      >
        {lista.map( (item) => <Marker coordinate={{latitude: item.latitude, longitude: item.longitude}}
          title={item.title} description={item.description}/>)}
      </MapView>
      <StatusBar style="auto" />
    </View>
  );}