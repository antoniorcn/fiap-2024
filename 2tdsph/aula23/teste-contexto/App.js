import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';
import { Contexto } from './contexto/contexto';
import { OutroComponente } from './components/outroComponente'; 

import { object, string, number, email, date } from 'yup';
import { MeuInputText } from './components/meuInputText';
const phoneRegExp = /^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/

const contatoSchema = object({
  nome: string().required().min(5),
  telefone: string().matches(phoneRegExp),
  email: string().email().required() 
});

export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [nomeErro, setNomeErro] = useState("");
  const [telefoneErro, setTelefoneErro] = useState("");
  const [emailErro, setEmailErro] = useState("");
  return (
    <Contexto.Provider value={{nome, telefone, email}}>
      <View style={styles.container}>
        <Text>Teste de Contexto</Text>
        <MeuInputText placeholder="Digite o nome"
          value={nome}  onChangeText={setNome}
          errorMessage={nomeErro}/>
        <MeuInputText placeholder="Digite o telefone"
          value={telefone}  onChangeText={setTelefone} 
          errorMessage={telefoneErro}/>
        <MeuInputText placeholder="Digite o email"
          value={email}  onChangeText={setEmail} 
          errorMessage={emailErro}/>                    
        <OutroComponente/>
        <Button title="Validar" onPress={()=>{
          const obj = {nome, telefone, email};
          setNomeErro(""); 
          setTelefoneErro("");
          setEmailErro("");
          contatoSchema.validate( obj, {abortEarly: false} )
          .then(()=>{alert("Dados validados");})
          .catch((err)=>{
            err.inner.forEach((erro)=>{
              if (erro.path=='nome') { 
                setNomeErro(erro.message);
              } else if (erro.path=='telefone') { 
                setTelefoneErro(erro.message);
              } else if (erro.path=='email') { 
                setEmailErro(erro.message);
              }
            })
          })
        }}/>
        <StatusBar style="auto" />
      </View>
    </Contexto.Provider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
