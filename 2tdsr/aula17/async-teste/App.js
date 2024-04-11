import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, TextInput, View, Modal, FlatList} from 'react-native';

const Principal = () => {
  return (
    <View styles={styles.container}>
      <Text style={{fontSize: 28}}>Componente Principal</Text>
    </View>
  );
}

const Login = () => {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");
  return (
    <View styles={styles.container}>
      <Text style={{fontSize: 28, marginBottom: 20}}>Login</Text>
      <TextInput  placeholder="Digite seu email..."
        value={email} onChangeText={setEmail}/>
      <TextInput  placeholder="Digite sua senha..." secureTextEntry={true}
        value={senha} onChangeText={setSenha}/>
      <Button title="Login"/>
    </View>
  );
}

export default function App() {
  const [nome, setNome] = useState("");
  const [telefone, setTelefone] = useState("");
  const [email, setEmail] = useState("");
  const [chave, setChave] = useState("");

  return (
    <View style={styles.container}>
      <Principal/>
      <Modal>
        <Login/>
      </Modal>
    </View>
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
