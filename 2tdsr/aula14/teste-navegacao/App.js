import { Text, View, StyleSheet } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import { Entypo } from '@expo/vector-icons';

const Tab = createBottomTabNavigator();
const TelaA = () => { 
  return (
    <View>
      <Text>Componente Tela A</Text>
      <Entypo name="home" size={48}/>
    </View>
  )
}
const TelaB = () => { 
  return (
    <View>
      <Text>Componente Tela B</Text>
    </View>
  )
}


export default function App() {
  return (
    <View style={{flex: 1}}>
      <Text>Navegação</Text>
      <NavigationContainer>
      <Tab.Navigator>
        <Tab.Screen name="A" component={TelaA} 
        options={{ title: "Aba A", 
                    tabBarIcon: ()=><Entypo name="home" size={48}/>  }}/>
        <Tab.Screen name="B" component={TelaB}/>
      </Tab.Navigator>
      </NavigationContainer>
    </View>
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
