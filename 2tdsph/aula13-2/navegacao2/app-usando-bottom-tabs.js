import {Button, View, Text, TextInput} from 'react-native';
import { NavigationContainer } from 
    '@react-navigation/native';
import { createBottomTabNavigator } from 
    '@react-navigation/bottom-tabs';
import DropDownPicker from 
    'react-native-dropdown-picker';
import {useState} from 'react';

const Tab = createBottomTabNavigator();

const listaFabricantes = [
  {label: "Samsung", value:"samsung"},
  {label: "LG Eletronics", value: "lg"},
  {label: "Apple", value: "apple"}
] 

const ProdutoForm = ( props ) => {
  const [nomeProduto, setNomeProduto] = useState("");
  const [quantidade, setQuantidade] = useState("");
  const [preco, setPreco] = useState("");
  const [aberto, setAberto] = useState(false);
  const [fabricante, setFabricante] = useState("");
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 28,
          textAlign: "center"}}>Gestão de produtos</Text>
      <Text>Nome do produto</Text>
      <TextInput  value={nomeProduto} 
                  onChangeText={setNomeProduto}/>
      <Text>Fabricante</Text>
      <DropDownPicker
        items={listaFabricantes}
        open={aberto}
        setOpen={setAberto}
        value={fabricante}
        setValue={setFabricante}/>
      <Text>Quantidade</Text>
      <TextInput value={quantidade} onChangeText={setQuantidade}/>
      <Text>Preço</Text>
      <TextInput value={preco} onChangeText={setPreco}/>
      <Button title="Salvar" onPress={()=>{
        const obj = { nomeProduto, fabricante, 
                      quantidade, preco };
        props.setLista( [ ...props.lista, obj ] );
        alert("Lista: " + JSON.stringify(props.lista));
      }}/>
    </View>
  );
}

const ProdutoLista = ( props ) => {
  const listaVisuais = props.lista.map( ( obj )=>{
    return(
      <View style={{backgroundColor: "lightcyan",
                margin: 5, padding: 5,
                borderWidth: 1,
                borderRadius: 20}}>
        <Text>{obj.nomeProduto}</Text>
        <Text>Fabricante: {obj.fabricante}</Text>
        <Text>Qtd: {obj.quantidade}</Text>
        <Text>R$ {obj.preco}</Text>
      </View>
    );
  });
  return (
    <View style={{flex: 1}}>
      {listaVisuais}
    </View>
  )
}

const Principal = () => { 
  const [lista, setLista] = useState([]);
  return (
    <View style={{flex: 1, 
                  backgroundColor: "lightyellow"}}>
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name="Formulario">
            { () => {return (<ProdutoForm lista={lista}
                    setLista={setLista}
            />)}}
          </Tab.Screen>
          <Tab.Screen name="Listagem">
            { () => <ProdutoLista lista={lista}/> }
          </Tab.Screen>
        </Tab.Navigator>
      </NavigationContainer>
    </View>
  )
}


export default Principal;