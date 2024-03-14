import { Button, Text, TextInput, View } 
  from 'react-native';
import { useState } from 'react';

export default function App() {
  const [nome, setNome] = useState("");
  const [preco, setPreco] = useState("");
  const [fabricante, setFabricante] = useState("");
  const [lista, setLista] = useState([]);
  

  const listaVisual = lista.map(( obj ) =>{
    return(
      <View style={{  borderWidth: 2, 
                      margin: 10, 
                      padding: 10 }}>
        <Text>{obj.nome}</Text>
        <Text>{obj.preco}</Text>
        <Text>{obj.fabricante}</Text>
      </View>
    )
  }); 

  return (
    <View>
      <Text>Cadastro de Produtos</Text>
      <Text>Nome:</Text>
      <TextInput value={nome} 
            onChangeText={( txt )=>{
              // alert("Texto: " + txt);
              setNome(txt);
            }}/>
      <Text>Preço:</Text>
      <TextInput value={preco}
            onChange={( obj )=>{
              setPreco(obj.target.value);
            }}/>
      <Text>Fabricante:</Text>
      <TextInput value={fabricante}
            onChangeText={setFabricante}/>
      <Button title="Salvar" onPress={()=>{
        const obj = { 
          nome,
          preco,
          fabricante
        };
        setLista( [...lista, obj] );
      }}/>
      {listaVisual}
    </View>
  );
}
