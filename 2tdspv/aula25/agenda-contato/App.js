import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, Text, TextInput, ToastAndroid, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useState } from 'react';
import { Ionicons } from '@expo/vector-icons';
import { object, string, number } from 'yup'; 

const {Navigator, Screen} = createBottomTabNavigator();

const contatoSchema = object({ 
  nome: string().required().min(5),
  telefone: string().required().max(20),
  email: string().required().email(),
  idade: number().required().integer().positive()
})

const Formulario = ( props ) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [idade, setIdade] = useState("");

  return (
    <View style={{flex: 1}}>
      <Text> Formulario de cadastro de contatos </Text>
      <TextInput placeholder="Informe o nome completo:"
        value={nome} onChangeText={setNome}/>
      <TextInput placeholder="Informe o telefone:"
        value={telefone} onChangeText={setTelefone}/>
      <TextInput placeholder="Informe o email:"
        value={email} onChangeText={setEmail}/>
      <TextInput placeholder="Informe a idade:"
        value={idade} onChangeText={setIdade}/>        
      <Button title="Gravar" onPress={()=>{
        const obj = {nome, telefone, email, idade};
        props.onGravar( obj );
      }} />
    </View>
  )
}

const Item = (props) => 
  <View>
    <Text>Nome: {props.item.nome}</Text>
    <Text>Telefone: {props.item.telefone}</Text>
    <Text>Email: {props.item.email}</Text>
    <Ionicons name="trash" size={28} onPress={()=>{
      props.onApagar(props.item.id)
    }}/>
  </View>

const Listagem = ( props ) => { 
  return (
    <View style={{flex: 1}}>
      <Text> Listagem de contatos </Text>
      <FlatList data={props.lista} 
          renderItem={(flatProps)=>
            <Item {...flatProps} onApagar={props.onApagar}/>}/>
    </View>
  )
}

export default function App() {
  const [lista, setLista] = useState([]);
  const [contador, setContador] = useState(0);

  const gravar = ( obj ) => { 
    contatoSchema.validate(obj)
    .then(()=>{
      obj.id = contador;
      setContador( contador + 1 );
      setLista( [...lista, obj]);
      ToastAndroid.show("Contato gravado", ToastAndroid.LONG);
    })
    .catch(( err )=>{
      ToastAndroid.show("Erro: " + err.message, 
          ToastAndroid.LONG);
    })
    
  }


  const apagar = ( id ) => { 
    const novaLista = []
    for( let i = 0; i < lista.length; i++ ) {
      const obj = lista[i];
      if (obj.id !== id ) { 
        novaLista.push( {...obj} );
      }
    }
    setLista( novaLista );
  }

  return (
    <View style={{flex: 1}}>
      <Text>Agenda de Contato</Text>
      <StatusBar style="auto" />
        <NavigationContainer>
          <Navigator>
            <Screen name="Formulario">
              {()=><Formulario onGravar={gravar} />}
            </Screen>
            <Screen name="Listagem">
              {()=><Listagem lista={lista} onApagar={apagar}/>}
            </Screen>
          </Navigator>
        </NavigationContainer>
    </View>
  );
}

