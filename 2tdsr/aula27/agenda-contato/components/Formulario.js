import { useState } from 'react';
import { View, Text, TextInput, Button } from 'react-native';

const Formulario = (props) => { 
    const [nome, setNome] = useState("");
    const [telefone, setTelefone] = useState("");
    const [email, setEmail] = useState("");
    const [endereco, setEndereco] = useState("");
    const [numero, setNumero] = useState("");
    const [cep, setCep] = useState("");
    const [idade, setIdade] = useState("");
    
    return (
        <View style={{flex: 1}}>
            <Text>Cadastro</Text>
            <TextInput placeholder="Nome do contato"
                value={nome} onChangeText={setNome}/>
            <TextInput placeholder="Telefone"
                value={telefone} onChangeText={setTelefone}/>
            <TextInput placeholder="Email"
                value={email} onChangeText={setEmail}/>
            <TextInput placeholder="Endereço"
                value={endereco} onChangeText={setEndereco}/>
            <TextInput placeholder="Numero da casa"
                value={numero} onChangeText={setNumero}/>
            <TextInput placeholder="CEP"
                value={cep} onChangeText={setCep}/>
            <TextInput placeholder="Idade"
                value={idade} onChangeText={setIdade}/>
            <Button title="Gravar" onPress={()=>{
                const obj = {nome, telefone, email, 
                    endereco, numero, cep, idade};
                props.onGravar( obj );
            }}/>
        </View>
    )
}

export default Formulario