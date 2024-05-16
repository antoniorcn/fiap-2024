import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { useControl } from './control/contatoControl';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Formulario from './components/Formulario';
import Listagem from './components/Listagem';
const {Navigator, Screen} = createBottomTabNavigator()

export default function App() {
  const { gravar, lista } = useControl();

  return (
    <View style={styles.container}>
      <Text>Agenda de Contatos</Text>
      <NavigationContainer>
        <Navigator>
          <Screen name="Formulario">
            { (navProps)=>
              <Formulario {...navProps} 
                          onGravar={ gravar }/> }
          </Screen>
          <Screen name="Listagem">
            { (navProps)=>
              <Listagem {...navProps} 
                          lista={ lista }/> }
          </Screen>
        </Navigator>
      </NavigationContainer>
      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'stretch',
    justifyContent: 'center',
  },
});
