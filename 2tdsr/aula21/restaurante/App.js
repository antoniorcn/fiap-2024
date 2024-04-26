import { StatusBar } from 'expo-status-bar';
import { Button, FlatList, StyleSheet, Text, TextInput, ToastAndroid, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { useState } from 'react';
import axios from 'axios';

const api = axios.create({
  baseURL: "https://61c6aafe-c1b5-4ade-a02d-dfc4e1f447c4-00-2bmzm4k0z9mip.worf.replit.dev"
})

const {Navigator, Screen} = createStackNavigator();

const Login = ( props ) => { 
  const [email, setEmail] = useState("admin@teste.com");
  const [password, setPassword] = useState("abc123");
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 38}}>Tela de Login</Text>
      {/* <Text>{JSON.stringify(props)}</Text> */}
      <TextInput placeholder="informe o email"
       value={email} onChangeText={setEmail}/>
      <TextInput placeholder="informe a senha" 
        secureTextEntry={true}
        value={password} onChangeText={setPassword}/>
      <Button title="Login" onPress={()=>{
        if (email === "admin@teste.com" && 
            password === "abc123") { 
          props.navigation.navigate("Formulario")
        } else { 
          alert("Usuario ou senha inválidos");
        }
      }}/>
    </View>
  )
}

const Formulario = ( props ) => { 
  const [nome, setNome] = useState("");
  const [tipo, setTipo] = useState("");
  const [calorias, setCalorias] = useState("");
  const [imagem, setImagem] = useState("");
  const [ingredientes, setIngredientes] = useState("");
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 38}}>Tela de Formulário</Text>
      {/* <Text style={{fontSize: 38}}>Props: {JSON.stringify(props)}</Text> */}
      <TextInput placeholder="Nome da refeição" 
        value={nome} onChangeText={setNome}/>
      <TextInput placeholder="Tipo da refeição" 
        value={tipo} onChangeText={setTipo}/>
      <TextInput placeholder="Calorias" 
        value={calorias} onChangeText={setCalorias}/>
      <TextInput placeholder="Nome da imagem" 
        value={imagem} onChangeText={setImagem}/>
      <TextInput placeholder="Ingredientes" 
        numberOfLines={5} multiline={true}
        scrollEnabled={true} 
        value={ingredientes} onChangeText={setIngredientes}/>
      <Button title="Salvar" onPress={()=>{
        const obj = { nome, tipo, calorias, imagem, ingredientes };
        props.onSalvar( obj );
      }}/>        
      <Button title="Listagem" onPress={()=>{
        props.navigation.navigate("Listagem")
      }}/>
      <Button title="Logout" onPress={()=>{
        props.navigation.navigate("Login")
      }}/>
    </View>
  )
}

const Item = (props) => { 
  return (
    <View style={{borderWidth: 2, padding: 5, margin: 5}}>
      <Text>{props.item.nome}</Text>
      <Text>{props.item.tipo}</Text>
      <Text>{props.item.calorias}</Text>
    </View>
  )
}

const Listagem = (props) => { 
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 38}}>Tela de Listagem</Text>
      <Button title="Formulario" onPress={()=>{
        props.navigation.navigate("Formulario")
      }}/>
      <Button title="Logout" onPress={()=>{
        props.navigation.navigate("Login")
      }}/>
      <FlatList data={props.lista} renderItem={Item} />
    </View>
  )
}
export default function App() {
  const [lista, setLista] = useState([]);

  const salvar = ( obj ) => { 
    // api.post("/cardapio", obj)
    // .then((response)=>{
    //   carregar();
    // })
    // .catch( (err)=> { ToastAndroid.show("Erro ao gravar o cardapio: " + err) })
    setLista([...lista, obj]);
    const strLista = JSON.stringify(lista);
    AsyncStorage.setItem("RESTAURANTES", strLista);
  }

  const carregar = () => {
    // api.get("/cardapio")
    // .then( (response) => {setLista(response.data)} )
    // .catch( (err)=> { ToastAndroid.show("Erro ao ler os dados: " + err) })
    AsyncStorage.getItem("RESTAURANTES")
    .then(( texto )=>{ 
      const objLista = JSON.parse(texto);
      setLista(objLista);
    })
    .catch( (err)=> { ToastAndroid.show("Erro ao ler os dados: " + err) })
  }

  return (
    <View style={styles.container}>
      <NavigationContainer>
        <Text style={{marginTop: 30, alignSelf: "center"}}>BRISTRO-DONTE</Text>
        <View style={{flex: 1, backgroundColor: "red"}}>
          <Navigator initialRouteName="Login">
              <Screen name="Login" component={Login}/>
              <Screen name="Formulario">
                {(navProps)=><Formulario {...navProps} onSalvar={salvar}/>}
              </Screen>
              <Screen name="Listagem">
                {(navProps)=><Listagem {...navProps} lista={lista} />}
              </Screen>
          </Navigator>
        </View>
        <StatusBar style="auto" />
      </NavigationContainer>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
