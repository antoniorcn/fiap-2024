import { SafeAreaView, Button, View,
  Text, TextInput, StyleSheet, ScrollView } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState } from 'react';
import Constants from 'expo-constants';

const estilos = StyleSheet.create({
  input: {
    backgroundColor: "lightcyan",
    borderColor: "red",
    borderWidth: 2,
    borderRadius: 20,
    paddingHorizontal: 10,
    marginVertical: 10,
    marginHorizontal: 5,
  }
})

// SET ANDROID_SDK=D:\usr\Android\Sdk
// { Navigator, Screen } 
// const Tab = createBottomTabNavigator();
const {Navigator, Screen} = createBottomTabNavigator();

// const Formulario = (props) => { 
// ...    props.onGravar();
const Formulario = ( {onGravar, navigation} ) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  return (
    <View style={{flex: 1}}>
      <Text> Formulario </Text>
      <TextInput style={estilos.input} placeholder="Digite o nome" 
                  value={nome} onChangeText={setNome}/>

      <TextInput style={estilos.input} placeholder="Digite o telefone" 
                  value={telefone} onChangeText={setTelefone}/>

      <TextInput style={estilos.input} placeholder="Digite o email" 
                  value={email} onChangeText={setEmail}/>
      <Button title="Salvar" onPress={()=>{
        const obj = {nome, telefone, email}
        onGravar( obj );
        setNome("")
        setEmail("")
        setTelefone("")
        navigation.navigate("Lista");
      }}/>
    </View>
  )
}

// const Listagem = ( props ) => { 
//   const listaVisual = props.lista.map( (item, idx) => {
const Listagem = ( { lista, corFundo } ) => { 
  const listaVisual = lista.map( (item, idx) => {
    return (
      <View style={{  margin: 5, 
                      borderWidth: 2, 
                      borderRadius: 20,
                      paddingHorizontal: 10,
                      paddingVertical: 5,
                      backgroundColor: corFundo,
                      // shadowColor: "black",
                      // shadowRadius: 20,
                      // shadowOffset: {width: 3, height: 3},
                      borderColor: "orange"}} key={"obj-" + idx}>
        <Text>{item.nome}</Text>
        <Text>{item.telefone}</Text>
        <Text>{item.email}</Text>
      </View>
    )
  })

  return (
    <ScrollView style={{flex: 1}}>
      <Text> Listagem </Text>
      {listaVisual}
    </ScrollView>
  )
}

export default function App() {
  const [lista, setLista] = useState([
    {nome: "João Silva", telefone: "(11) 1111-1111", email: "joao@teste.com"},
    {nome: "Maria Silva", telefone: "(11) 2222-2222", email: "maria@teste.com"}
  ]);

  const gravar = ( obj ) => {
      setLista([...lista, obj ])
  }

  return (
    <SafeAreaView style={{flex: 1, 
                marginTop: Constants.statusBarHeight}}>
      <Text style={{fontSize: 32}}>Agenda de Contatos 2</Text>
      <NavigationContainer>
        <Navigator>
          <Screen name="Form">
            {(navProps)=><Formulario {...navProps} onGravar={gravar}/>}
          </Screen>

          <Screen name="Lista">
            {(navProps)=><Listagem {...navProps} corFundo="lightyellow" lista={lista} />}
          </Screen>
        </Navigator>
      </NavigationContainer>
    </SafeAreaView>
  );
}
