import { Button, FlatList, Image, Text, TextInput, ToastAndroid, View } from 'react-native';
import { styles } from './estilos/style1';
import imgInstrumentos  from './assets/instrumentos-musicais.jpg';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import ContextoPrincipal from './contexto/contextoPrincipal'
import { useState, useContext, useEffect } from 'react';
import axios from 'axios';
import { Entypo } from '@expo/vector-icons';

const {Navigator, Screen} = createBottomTabNavigator();

const api = axios.create({
  baseURL: "https://31cf5806-1a94-42c4-856a-415c5414c753-00-e8kj8ujc0x8l.riker.replit.dev"
})

const Cadastro = (props) => {
  const [marca, setMarca] = useState("");
  const [tipo, setTipo] = useState("");
  const [modelo, setModelo] = useState("");
  const [preco, setPreco] = useState("");
  const {salvar} = useContext(ContextoPrincipal);
  return (
    <View style={{flex: 1}}>
      <Text> Cadastro </Text>
      <TextInput placeholder="Marca do Instrumento"
        value={marca} onChangeText={setMarca}/>
      <TextInput placeholder="Tipo do Instrumento"
        value={tipo} onChangeText={setTipo}/>
      <TextInput placeholder="Modelo do Instrumento"
        value={modelo} onChangeText={setModelo}/>
      <TextInput placeholder="Preço"
        value={preco} onChangeText={setPreco}/>
      <Button title="Salvar" onPress={()=>{
        const obj = {marca, tipo, modelo, preco}
        salvar( obj );
      }}/>
    </View>
  )
}

const Instrumento = (props) => { 
  // props.item {id: 1, fabricante: "Gianini", tipo: "Violão", 
  // modelo: "es500", preco: 400.0}
  return (
    <View style={{margin: 5, borderWidth: 2, padding: 5}}>
      <Text>Fabricante: {props.item.fabricante}</Text>
      <Text>Tipo: {props.item.tipo}</Text>
      <Text>Modelo: {props.item.modelo}   Preço: {props.item.preco}</Text>
      <Entypo name="trash"  size={32} onPress={()=>{
        props.onApagar( props.item.id );
      }}/>
    </View>
  )
}

const Listagem = (props) => {
  const {lista, apagar} = useContext(ContextoPrincipal);
  return (
    <View style={{flex: 1}}>
      <Text> Listagem </Text>
      <FlatList data={lista} renderItem={( flatProps )=>
        <Instrumento {...flatProps} onApagar={apagar}/>
      }/>
    </View>
  )
}

const Login = (props) => {
  const [user, setUser] = useState("");
  const [pass, setPass] = useState("");
  const { logar } = useContext(ContextoPrincipal);
  return(
    <View style={{flex: 1}}>
      <Text>Login no sistema</Text>
      <TextInput placeholder="Informe o usuário"
        value={user} onChangeText={setUser}/>
      <TextInput placeholder="Digite sua senha" 
        value={pass} onChangeText={setPass}
        secureTextEntry={true} />
      <Button title="Login" onPress={()=>{
        logar(user, pass);
      }}/>
    </View>
  )
}


export default function App() {
  const [lista, setLista] = useState([
    // {fabricante: "Gianini", tipo: "Violão", 
    //   modelo: "ES500", preco: 400.0
    // },
  ]);

  useEffect( ()=> {
    if (token !== null) { 
      notificar("Carregando dados, token atualizado");
      carregar();
    }
  }, [token])

  const [token, setToken] = useState(null);
  // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwidXN1YXJpbyI6ImpvYW8iLCJwZXJmaWwiOiJhZG1pbiJ9.cyKrteeO5wJUJMoQGKtv6DjDDBN5dBSi4DkC3ELtaW4

  const notificar = ( msg ) => { 
    ToastAndroid.show(msg, ToastAndroid.LONG);
  }

  const salvar = ( obj ) => { 
    api.post("/instrumento", obj, {
      headers: {Authorization: "Bearer " + token}
    })
    .then( (resposta)=> {
      notificar("Instrumento Salvo");
      carregar();
    })
    .catch( (err)=> { notificar("Erro ao salvar :" + err) });
  }

  const carregar = () => { 
    api.get("/instrumento", {
      headers: {Authorization: "Bearer " + token}
    })
    .then( (resposta)=> {
      // notificar("Data: " + JSON.stringify(resposta.data));
      setLista( [...resposta.data.data]) 
    })
    .catch( (err)=> { notificar("Erro :" + err) });
  }

  const apagar = ( id ) => { 
    api.delete("/instrumento/" + id, { 
      headers: {Authorization: "Bearer " + token}
    })
    .then( (resposta) => { 
      notificar("Instrumento apagado com sucesso");
      carregar();
    })
    .catch( (err)=> { notificar("Erro ao apagar:" + err) });
  }

  const logar = (user, pass) => { 
    api.post("/login", {user, pass})
    .then((resposta)=>{
      setToken(resposta.data.token);
    })
    .catch( (err)=> { notificar("Erro ao logar:" + err) });
  }

  return (
    <ContextoPrincipal.Provider 
      value={ {lista, salvar, carregar, apagar, logar} }>
      <View style={styles.container}>
        <View style={{flex: 3}}>
          <Image source={imgInstrumentos}/>
        </View>
        { !token ? 
        <View style={{flex: 7}}>
          <Login/>
        </View> 
        : 
        <View style={{flex: 7}}>
          <NavigationContainer>
            <Navigator>
              <Screen name="Cadastrar" component={Cadastro}/>
              <Screen name="Listagem" component={Listagem}/>
            </Navigator>
          </NavigationContainer>
        </View> } 
      </View>
    </ContextoPrincipal.Provider>    
  );
}
