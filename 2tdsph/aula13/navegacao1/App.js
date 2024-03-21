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

const ProdutoForm = () => {
  const [aberto, setAberto] = useState(false);
  const [fabricante, setFabricante] = useState("");
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 28,
          textAlign: "center"}}>Gestão de produtos</Text>
      <Text>Nome do produto</Text>
      <TextInput/>
      <Text>Fabricante</Text>
      <DropDownPicker
        items={listaFabricantes}
        open={aberto}
        setOpen={setAberto}
        value={fabricante}
        setValue={setFabricante}/>
      <Text>Quantidade</Text>
      <TextInput/>
      <Text>Preço</Text>
      <TextInput/>
      <Button title="Salvar"/>
    </View>
  );
}

const ProdutoLista = () => {
  return (
    <View style={{flex: 1}}>
      <View style={{backgroundColor: "lightcyan",
                margin: 5, padding: 5,
                borderWidth: 1,
                borderRadius: 20}}>
        <Text>TV Samsung 43 pol</Text>
        <Text>Qtd: 10</Text>
        <Text>R$ 1.500,00</Text>
      </View>

      <View style={{backgroundColor: "lightcyan",
                margin: 5, padding: 5,
                borderWidth: 1,
                borderRadius: 20}}>
        <Text>Mangá</Text>
        <Text>Qtd: 20</Text>
        <Text>R$ 80,00</Text>
      </View>
    </View>
  )
}

const Principal = () => { 
  return (
    <View style={{flex: 1, 
                  backgroundColor: "lightyellow"}}>
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name="Formulario" 
                      component={ProdutoForm}/>
          <Tab.Screen name="Listagem"
                      component={ProdutoLista}/>
        </Tab.Navigator>
      </NavigationContainer>
    </View>
  )
}


export default Principal;