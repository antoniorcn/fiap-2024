import { Ionicons } from '@expo/vector-icons';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { NavigationContainer } from '@react-navigation/native';
import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { Button, FlatList, Text, TextInput, ToastAndroid, View } from 'react-native';
import { object, string } from 'yup';
import * as Notifications from 'expo-notifications';

const {Navigator, Screen} = createBottomTabNavigator();

Notifications.setNotificationHandler({
  handleNotification: async () => {
    return { 
      shouldPlaySound: true,
      shouldSetBadge: false,
      shouldShowAlert: true
    }
  }
});

const schedulerNotificationHandler = (title, body, tempoEmSegundos) => { 
  Notifications.scheduleNotificationAsync({
    content: {
      title,
      body
    },
    trigger: {
      seconds: tempoEmSegundos
    }
  })
}
  
  

const contatoSchema = object( { 
  nome: string().required().min(5).max(50),
  telefone: string().required().min(8).max(20),
  email: string().required().email()
} )

const Formulario = ( props ) => { 
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");

  const [nomeErro, setNomeErro] = useState("");
  const [telefoneErro, setTelefoneErro] = useState("");
  const [emailErro, setEmailErro] = useState("");  

  const validar = ( obj ) => { 
    setNomeErro("");
    setTelefoneErro("");
    setEmailErro("");
    contatoSchema.validate(obj, {abortEarly: false})
    .then(()=>{
      props.onGravar( obj );
      schedulerNotificationHandler(
        "Contato: " + obj.nome + " gravado",

        "Nome: " + obj.nome + "\n" + 
        "Telefone: " + obj.telefone + "\n" + 
        "Email: " + obj.email, 
        
        5
      );
    })
    .catch((erros)=>{
      // let texto = "";
      erros.inner.forEach(erro => {
        if (erro.path === "nome") { 
          setNomeErro(erro.message);
        } else if (erro.path === "telefone") { 
          setTelefoneErro(erro.message);
        } else if (erro.path === "email") { 
          setEmailErro(erro.message);
        }
        // texto += erro.path + ": " + erro.message + "\n";
      });
      // ToastAndroid.show(texto, ToastAndroid.LONG);
    })
  }

  return (
    <View style={{flex: 1}}>
      <Text> Formulario de cadastro de contatos </Text>
      <TextInput placeholder="Informe o nome completo:"
        value={nome} onChangeText={setNome}/>
      <Text style={{color: "red", fontSize: 10}}>{nomeErro}</Text>
      <TextInput placeholder="Informe o telefone:"
        value={telefone} onChangeText={setTelefone}/>
      <Text style={{color: "red", fontSize: 10}}>{telefoneErro}</Text>
      <TextInput placeholder="Informe o email:"
        value={email} onChangeText={setEmail}/>
      <Text style={{color: "red", fontSize: 10}}>{emailErro}</Text>        
      <Button title="Gravar" onPress={()=>{
        const obj = {nome, telefone, email};
        validar( obj );
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

  const gerarId = () => { 
    const contadorAtual = contador;
    setContador( contador + 1 );
    return contadorAtual;
  }

  const gravar = ( obj ) => { 
    obj.id = gerarId();
    setLista( [...lista, obj ] )
  }

  const apagar = ( id ) => { 
    const novaLista = [];
    for (let i = 0; i < lista.length; i++) { 
      const obj = lista[i];
      if ( obj.id !== id ) {
        novaLista.push( obj );
      }
    }
    setLista( [...novaLista] );
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

