import { StatusBar } from 'expo-status-bar';
import { Button, StyleSheet, Text, View } from 'react-native';
import * as Notifications from 'expo-notifications';

Notifications.setNotificationHandler({
  handleNotification: async () => ({
    shouldShowAlert: true,
    shouldPlaySound: false,
    shouldSetBadge: true,
  }),
});

export default function App() {

  const localNotification = async (titulo, descricao) => { 
    await Notifications.scheduleNotificationAsync({
      content: { 
        title: titulo,
        body: descricao
      },
      trigger: { 
        seconds: 5
      }
    });
  }

  return (
    <View style={styles.container}>
      <Text>Teste de notificação</Text>

      <Button title="Agenda notificação para 5 segundos"
        onPress = {()=> { 
          console.log("Botão clicado");
          localNotification("Agenda de Contato Ligar para o João",
          "Precisa entrar com contato com o João para fazer Rapport")
          .then(()=>{console.log("Notificacao enviada")})
        }}/>
      <StatusBar style="auto" />
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
