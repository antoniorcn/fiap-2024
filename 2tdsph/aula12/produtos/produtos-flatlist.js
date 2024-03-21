import {Button, FlatList, Modal, Text, TouchableOpacity, TextInput, View, ToastAndroid } from 'react-native';
import {useState} from 'react';

function ProdutoItem( props ) { 
  /*
    item 
  */
  const obj = props.item;
  return (
    <View>
      <Text>{obj.nome}</Text>
      <Text>{obj.preco}</Text>
      <Text>{obj.fabricante}</Text>
    </View>
  )
}

export default () => {
  const [nome, setNome] = useState("");
  const [preco, setPreco] = useState("");
  const [fabricante, setFabricante] = useState("");

  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  const [logado, setLogado] = useState(false);

  const [lista, setLista] = useState([]);

  return (
    <View  style={{flex: 1, marginTop: 40}}>
      <Modal style={{flex: 1}} visible={!logado}>
        <Text style={{fontSize: 32}}>Logon</Text>
        <Text>Email: </Text>
        <TextInput value={email} onChangeText={setEmail}/>
        <Text>Senha:</Text>
        <TextInput value={senha} onChangeText={setSenha}/>
        <Button title="Login" onPress={()=>{
          if (email === "joao@teste.com" && senha === "1234") { 
            setLogado(true);
          } else { 
            setLogado(false);
            ToastAndroid.show("Usuario ou senha incorretos", ToastAndroid.LONG);
          }
        }}/>
      </Modal>
      <View style={{flex: 1}}>
        <View style={{flex: 1, backgroundColor:"lightyellow"}}>
          <Text style={{fontSize: 24, textAlign:"center"}}>
              Produtos Eletronicos
          </Text>
          <Text>Nome Produto</Text>
          <TextInput value={nome} onChangeText={setNome}/>
          <Text>Preco</Text>
          <TextInput value={preco} onChangeText={setPreco}/>
          <Text>Fabricante</Text>
          <TextInput value={fabricante} onChangeText={setFabricante}/>
          <TouchableOpacity onPress={()=>{
            const obj = {
              nome, 
              preco,
              fabricante,
            }
            setLista([...lista, obj]);
          }}>
            <Text style={{
              backgroundColor: "lime",
              marginVertical: 10,
              marginHorizontal: 30,
              padding: 10,
              fontSize: 18,
              textAlign: "center",
              borderRadius: 10,
            }}>Salvar</Text>
          </TouchableOpacity>
          <Button title="Sair" onPress={()=>{
            setLogado(false);
          }}/>
        </View>
        <View style={{flex: 2, backgroundColor:"lightgray"}}>
          <FlatList data={lista} 
                    renderItem={ProdutoItem}
                    keyExtractor={(item)=>{
                      return item.fabricante + "-" + item.nome
                    }}/>
        </View>
      </View>
    </View>
  );
}
