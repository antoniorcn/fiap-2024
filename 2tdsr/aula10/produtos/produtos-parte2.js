import { Button, Text, TextInput, View } 
  from 'react-native';
import { useState } from 'react';

export default function App() {
  const [nome, setNome] = useState("");
  const [lista, setLista] = useState([]);

  /* const lista = [
    { texto: "Texto 1" },   // 0
    { texto: "Texto 2" },   // 1
    { texto: "Texto 3" },   // 2
  ] 
    lista.length;  // 3
  */   

  /*
  const listaVisual = [];
  for (let i = 0; i < lista.length; i++) {
    const obj = lista[i];
    listaVisual.push(
      <View>
        <Text>{obj.texto}</Text>
      </View>
    );
  }
  */
  const listaVisual = lista.map(( obj ) =>{
    return(
      <View>
        <Text>{obj.nome}</Text>
      </View>
    )
  }); 

  return (
    <View>
      <Text>Cadastro de Produtos</Text>
      <Text>Nome</Text>
      <TextInput value={nome} 
            onChangeText={setNome}/>
      <Button title="Salvar" onPress={()=>{
        const obj = { nome: nome };
        setLista( [...lista, obj] );
        // alert("Lista: " + JSON.stringify(lista));
      }}/>
      {listaVisual}
    </View>
  );
}
