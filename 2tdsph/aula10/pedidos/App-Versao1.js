import { useState } from 'react';
import { Button, Image, StyleSheet, Text, TextInput, View } from 'react-native';
import imgLanchonete from './assets/lanchonete.png';

const estilos = StyleSheet.create({
  imagem: {
    height: 200
  },
  principal: { 
    flex: 1,
    padding: 5
  },
  cabecalho: {
    flex: 2
  },
  formulario: {
    flex: 2
  },
  lista: {
    flex: 3
  }
});

function Pedido( props ) { 
  return (
    <View key={props.id}>
      <Text>{props.produto}</Text>
      <Text>{props.qtd} - {props.pago}</Text>
      <Text>{props.cliente}</Text>
    </View>
  )
}

export default function App() {
  const [produto, setProduto] = useState("");
  const [qtd, setQtd] = useState("");
  const [pago, setPago] = useState("");
  const [cliente, setCliente] = useState("");
  const [lista, setLista] = useState([]);

  const listaVisual = [];


  for(let i = 0; i < lista.length; i++) {
    const p1 = lista[i];
    listaVisual.push(
      <Pedido produto={p1.produto}
              qtd={p1.qtd}
              pago={p1.pago}
              cliente={p1.cliente}
              id={i}/>
    )
  }

  return (
    <View style={estilos.principal}>
      <View style={estilos.cabecalho}>
        <Image source={imgLanchonete}
          resizeMethod="resize"
          resizeMode="center"/>
        <Text>Registro de Pedidos</Text>
      </View>
      <View style={estilos.formulario}>
        <Text>Nome do Produto:</Text>
        <TextInput  value={produto} 
                    onChangeText={setProduto}/>
        <Text>Quantidade:</Text>
        <TextInput  value={qtd}
                    onChangeText={setQtd}/>
        <Text>Pago:</Text>
        <TextInput  value={pago}
                    onChangeText={setPago}/>
        <Text>Nome do Cliente</Text>
        <TextInput  value={cliente}
                    onChangeText={setCliente}/>
        <Button title="Salvar" onPress={
          () => {
            // const obj = {
            //   produto: produto,
            //   qtd: qtd,
            //   pago: pago,
            //   cliente: cliente
            // }
            const obj = {
              produto,
              qtd,
              pago,
              cliente
            };

            setLista( [...lista, obj] );
          }
        }/>
      </View>
      <View style={estilos.lista}>
        {listaVisual}
      </View>
    </View>
  );
}