import {Button, SectionList, Switch, Text, TouchableOpacity, TextInput, View, ToastAndroid } from 'react-native';
import {useState} from 'react';


const usuarios = [
  {id: 1, nome: "João Silva", email: "joao@teste.com", senha: "1234"},
  {id: 2, nome: "Maria Silva", email: "maria@teste.com", senha: "1234"},
  {id: 3, nome: "Alberto Campos", email: "alberto@teste.com", senha: "1234"},
]

const admins = [
  {id: 4, nome: "Admin1", email: "admin1@teste.com", senha: "123456"},
  {id: 5, nome: "Admin2", email: "admin2@teste.com", senha: "123456"},
]


function SecaoCabecalho( props ) { 
  const secao = props.section;

  return (
    <View style={{backgroundColor: "lime"}}>
      <Text style={{fontSize: 24}}>{secao.title}</Text>
    </View>
  )
}

function SecaoItem( props ) { 
  const item = props.item;
  return (
    <View style={{  backgroundColor: "lightgray", 
                    margin: 5, padding: 5,
                    borderWidth: 1}}>
      <Text>{item.nome}</Text>
      <Text>{item.email}</Text>
    </View>
  )
}


export default () => {
  const [nome, setNome] = useState("");
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  const [admin, setAdmin] = useState(false);

  const [listaUsuarios, setListaUsuarios] = useState(usuarios);
  const [listaAdmins, setListaAdmins] = useState(admins);

  return (
    <View  style={{flex: 1, marginTop: 40}}>
      <View style={{flex: 1}}>
        <View style={{flex: 1, backgroundColor:"lightyellow"}}>
          <Text style={{fontSize: 24, textAlign:"center"}}>
              Administração de Usuarios
          </Text>
          <Text>Nome do Usuario</Text>
          <TextInput value={nome} onChangeText={setNome}/>
          <Text>Email</Text>
          <TextInput value={email} onChangeText={setEmail}/>
          <Text>Senha</Text>
          <TextInput value={senha} onChangeText={setSenha}/>
          <Text>Administrador: </Text>
          <Switch value={admin} onValueChange={setAdmin}/>
          <TouchableOpacity onPress={()=>{
            const obj = {
              nome, 
              email,
              senha,
            }
            if (admin === true) { 
              setListaAdmins([...listaAdmins, obj]);
            } else {
              setListaUsuarios([...listaUsuarios, obj]);
            }
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
        </View>
        <View style={{flex: 2, backgroundColor:"lightgray"}}>
          <SectionList sections={[
            {title: "Usuarios Administrativos", data: listaAdmins},
            {title: "Usuarios Comuns", data: listaUsuarios}
          ]}
          renderSectionHeader={SecaoCabecalho}
          renderItem={SecaoItem}
          keyExtractor={ obj => obj.id }/>
        </View>
      </View>
    </View>
  );
}
