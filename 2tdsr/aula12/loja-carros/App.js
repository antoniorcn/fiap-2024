import { Button, StyleSheet, Text, View, TextInput, ImageBackground } from 'react-native';
import imgCarros from './assets/car-store.jpg';
import {useState} from 'react';
import DropDownPicker from 'react-native-dropdown-picker';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'stretch',
    justifyContent: 'flex-start',
  },
  logo: {
    width: "100%",
    height: "50%",
    flex: 1,
    justifyContent: "center",
    alignItems: "center"
  },
  textoLogo: {
    color: "white",
    fontSize: 18,
    backgroundColor: "#DDDB",
    textAlign: "center",
    padding: 5,
    textShadowColor: "black",
    textShadowRadius: 5,
    textShadowOffset: {width: 3, height: 3},
    paddingHorizontal: 20,
    borderRadius: 20
  },
  formulario : { 
    flex: 3,
    backgroundColor: "lightcyan"
  },
  listagem : { 
    flex: 2,
    backgroundColor: "lightyellow"
  },
  listaItem : { 
    backgroundColor: "lightgreen",
    borderWidth: 1,
    margin: 10,
    borderRadius: 10,
    padding: 5
  }
});
/* import {useState} from 'react'; */ 
export default function App() {
  const [fabricante, setFabricante] = useState("");
  const [modelo, setModelo] = useState("");
  const [preco, setPreco] = useState("");
  const [lista, setLista] = useState([]);

  const [aberto, setAberto] = useState(false);

  // const numeros = [3, 6, 9, 12, 16];
  // const funcaoTransforma = ( num ) => {return num * num};
  // const novaListNumeros = 
  //     numeros.map( funcaoTransforma  ) 
  //     //  [9, 36, 81, 144, 256]

  // const listaVisual = []

  const listaFabricantes = [
    {label: "Honda", value: "honda"},
    {label: "Hyundai", value: "hyundai"},
    {label: "Volkswagen", value: "vw"}
  ]

  const listaVisual = lista.map(( obj, idx )=>{ return(
    <View style={styles.listaItem} key={idx}>
      <Text>{obj.fabricante}</Text>
      <Text>{obj.modelo}</Text>
      <Text>R$ {obj.preco}</Text>
    </View>
  )})

  return (
    <View style={styles.container}>
      <ImageBackground source={imgCarros}
        style={styles.logo}
        resizeMode='auto'
        resizeMethod='cover'>
        <Text style={styles.textoLogo}>Loja de Carros</Text>
      </ImageBackground>

      {/* Formulario */}
      <View style={styles.formulario}>
        <Text>Fabricante: </Text>
        <DropDownPicker 
          items={listaFabricantes}
          open={aberto}
          setOpen={setAberto}
          setValue={setFabricante}
          value={fabricante}/>
        <Text>Modelo: </Text>
        <TextInput value={modelo} onChangeText={setModelo}/>
        <Text>Preço: </Text>
        <TextInput value={preco} onChangeText={setPreco}/>
        <Button title="Salvar" onPress={()=>{
            const obj = { 
                fabricante,
                modelo, 
                preco } 

            setLista([ ...lista, obj ]);
        }}/>
      </View>

      {/* Listagem */}
      <View style={styles.listagem}>
        {listaVisual}
      </View>
    </View>
  );
}


