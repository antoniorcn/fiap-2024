import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View, ScrollView } from 'react-native';
import { NavigationContainer, useNavigation } from '@react-navigation/native'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState } from 'react';
const {Navigator, Screen} = createBottomTabNavigator();
import Constants from 'expo-constants';
import {Entypo, FontAwesome} from '@expo/vector-icons';

const Formulario = (props) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");

  const navigation = useNavigation();
  return (
    <View style={styles.formulario}>
      <TextInput style={styles.input} placeholder="Nome Completo"
          value={nome} onChangeText={setNome}/>
      <TextInput style={styles.input} placeholder="Telefone"
          value={telefone} onChangeText={setTelefone}/>
      <TextInput style={styles.input} placeholder="Email"
          value={email} onChangeText={setEmail}/>
      <Button title="Salvar" onPress={()=>{
          const obj = { nome, telefone, email };
          props.onSalvar( obj );
          setNome("");
          setTelefone("");
          setEmail("");
          // props.navigation.navigate("Listagem")
          navigation.navigate("Listagem");
      }}/>
    </View>
  )
}

const Listagem = ({ contatos, navigation }) => { 
  const listaVisual = contatos.map( ( item )=> 
    <View>
      <Text>{item.nome}</Text>
      <Text>{item.telefone}</Text>
      <Text>{item.email}</Text>
    </View>
  );

  return (
    <View style={styles.listagem}>
      <ScrollView style={{flex: 1}}>
        {listaVisual}
      </ScrollView>
      <Button title="Voltar" onPress={()=>{
        navigation.goBack();
      }}/>
    </View>
  )
}

export default function App() {
  const [lista, setLista] = useState([
    // {nome: "João Silva", telefone: "(11) 1111-1111", email: "joao@teste.com"}
  ]);

  const salvar = ( obj ) => {
    setLista( [obj, ... lista] )
  }

  return (
    <View style={styles.container}>
      <Text style={styles.titulo}>Agenda de Contatos</Text>
      <StatusBar style="auto" />
      <NavigationContainer>
        <Navigator>
          <Screen name="Formulário" options={{
            tabBarIcon: ()=><Entypo name="edit" size={38}/>
          }}>
              { (navProps) => <Formulario 
                    {...navProps}
                    onSalvar={salvar}/>}
          </Screen>
          <Screen name="Listagem" options={{
            tabBarIcon: ()=><Entypo name="list" size={38}/>
          }}>
              { (navProps) => <Listagem {...navProps} contatos={lista}/>}
          </Screen>
        </Navigator>
      </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'lightyellow',
    justifyContent: 'flex-start',
    marginTop: Constants.statusBarHeight
  },
  titulo: {
    marginVertical: 10,
    fontSize: 36,
    textAlign: "center",
    textShadowColor: "black",
    textShadowRadius: 5,
    textShadowOffset: {width: 3, height: 3}
  },
  formulario: { 
    flex: 1,
    backgroundColor: "antiquewhite"
  }, 
  listagem: { 
    flex: 1,
    backgroundColor: "azure"
  }, 
  input: {
    backgroundColor: "lavender",
    borderColor: "khaki",
    borderWidth: 2,
    paddingHorizontal: 10,
    paddingVertical: 5,
    margin: 5
  }
});
