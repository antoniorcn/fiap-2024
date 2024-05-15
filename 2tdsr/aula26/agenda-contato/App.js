import { Text, SafeAreaView, StyleSheet, View, FlatList } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useAgendaControl } from './control/agendaControl';
import Formulario from './components/Formulario';

const { Navigator, Screen } = createBottomTabNavigator();

const Item = (props) => 
<View>
  <Text>Nome: {props.item.nome}</Text>
  <Text>Telefone: {props.item.telefone}</Text>
  <Text>Email: {props.item.email}</Text>
</View>

const Listagem = (props) => {
  return (
    <View style={{flex: 1}}>
      <FlatList data={props.lista} renderItem={Item}/>
    </View>
  )
}

export default function App() {
  const {gravar, lista} = useAgendaControl();
  return (
    <SafeAreaView style={styles.container}>
      <Text style={styles.paragraph}>
       Agenda de Contato
      </Text>
      <NavigationContainer>
        <Navigator>
          <Screen name="Formulario">
            {(navProps)=><Formulario {...navProps} 
              onGravar={gravar} />}
          </Screen>
          <Screen name="Listagem">
            {(navProps)=><Listagem {...navProps} 
              lista={lista}/>}
          </Screen>
        </Navigator>
      </NavigationContainer>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#ecf0f1',
    padding: 8,
  },
  paragraph: {
    margin: 24,
    fontSize: 18,
    fontWeight: 'bold',
    textAlign: 'center',
  },
});
