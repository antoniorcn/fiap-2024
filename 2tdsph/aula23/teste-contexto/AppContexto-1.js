import { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, TextInput, View } from 'react-native';
import { Contexto } from './contexto/contexto';
import { OutroComponente } from './components/outroComponente'; 
export default function App() {
  const [nome, setNome] = useState("");
  return (
    <Contexto.Provider value={nome}>
      <View style={styles.container}>
        <Text>Teste de Contexto</Text>
        <TextInput placeholder="Digite o nome"
          value={nome}  onChangeText={setNome} />
        <OutroComponente/>
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
