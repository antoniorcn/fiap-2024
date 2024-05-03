import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { useCardapioControl } from './control/cardapioControl';
import { Listagem } from './componentes/Listagem';
import { Login } from './componentes/Login';
import { Formulario } from './componentes/Formulario';
import Contexto from './contexto/contexto';

const { Navigator, Screen } = createStackNavigator();

export default function App() {
  const control = useCardapioControl();
  return (
    <Contexto.Provider value={control}>
      <View style={styles.container}>
        <NavigationContainer>
          <Text style={{marginTop: 30, alignSelf: "center"}}>BRISTRO-DONTE</Text>
          <View style={{flex: 1, backgroundColor: "red"}}>
            <Navigator initialRouteName="Login">
                <Screen name="Login">
                  {(navProps)=><Login {...navProps}/>}
                </Screen>
                <Screen name="Formulario">
                  {(navProps)=><Formulario {...navProps} onSalvar={control.salvar}/>}
                </Screen>
                <Screen name="Listagem">
                  {(navProps)=><Listagem {...navProps} lista={control.lista} />}
                </Screen>
            </Navigator>
          </View>
          <StatusBar style="auto" />
        </NavigationContainer>
      </View>
    </Contexto.Provider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
});
