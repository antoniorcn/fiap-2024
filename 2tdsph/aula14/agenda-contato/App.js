import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import Constants from 'expo-constants';
import { Button, StyleSheet, Text, TextInput, View } from 'react-native';

export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [lista, setLista] = useState([]);

  const Componente = (props) => 
    <View style={styles.item}>
      <Text style={styles.itemFonte}>Nome: {props.objeto.nome}</Text>
      <Text style={styles.itemFonte}>Telefone: {props.objeto.telefone}</Text>
      <Text style={styles.itemFonte}>Email: {props.objeto.email}</Text>
    </View>

  const listaVisual = lista.map( (elemento, indice) => 
            <Componente key={"key_" + indice} objeto={elemento}/> ) 
  const statusHeight = Constants.statusBarHeight;
  return (
    <View style={[styles.container, {marginTop: statusHeight}]}>
      <StatusBar style="auto" />
      <View style={styles.cabecalho}>
        <Text style={styles.titulo}>Agenda de Contatos</Text>
      </View>
      <View style={styles.formulario}>
        <TextInput style={styles.input} placeholder="Nome completo"
                  value={nome} onChangeText={setNome}/>
        <TextInput style={styles.input} placeholder="Telefone (DDD) XXXXX-XXXX"
                  value={telefone} onChangeText={setTelefone}/>
        <TextInput style={styles.input} placeholder="e-Mail"
                  value={email} onChangeText={setEmail}/>
        <Button title="Salvar" color="green" onPress={()=>{
            const obj = {nome, telefone, email}
            setLista([...lista, obj])
        }}/>
      </View>
      <View style={styles.listagem}>
        {listaVisual}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'lemonchiffon',
    alignItems: 'stretch',
    justifyContent: 'flex-start',
  },
  cabecalho: {
    flex: 1,
    backgroundColor: "lightseagreen",
    justifyContent: "center",
    alignItems: "stretch",
    padding: 5,
    margin: 5
  },
  titulo: {
    textAlign: "center",
    fontSize: 28,
    color: "white",
    textShadowRadius: 5,
    textShadowColor: "black",
    textShadowOffset: {width: 3, height: 3}
  },
  formulario: { 
    flex: 2,
    backgroundColor: "mediumseagreen",
    padding: 5,
    margin: 5,
    alignItems: "stretch",
  },
  input: {
    backgroundColor: "seashell",
    borderColor: "sandybrown",
    borderWidth: 2,
    borderRadius: 30,
    paddingHorizontal: 10,
    margin: 5
  }, 
  listagem: { 
    flex: 4,
    backgroundColor: "aquamarine",
    padding: 5,
    margin: 5
  },
  item: { 
    backgroundColor: "darkseagreen",
    borderColor: "sandybrown",
    borderWidth: 2,
    borderRadius: 30,
    marginVertical: 10,
    paddingHorizontal: 20,
    paddingVertical: 5
  },
  itemFonte: {
    fontSize: 18,
    color: "white",
    fontWeight: "bold"
  }
});
