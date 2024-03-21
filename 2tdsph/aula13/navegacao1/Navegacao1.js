import { Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { Entypo } from '@expo/vector-icons';
const {Screen, Navigator} = createBottomTabNavigator();

function Principal ()  {
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 30}}>
          Tela Principal</Text>
    </View>
  )
}

const Config = () => {
  return (
    <View style={{flex: 1}}>
      <Text style={{fontSize: 30}}>
        Tela de configuração</Text>
    </View>
  )
}

export default function App() {
  return (
    <View style={{  margintop: 50, flex: 1, 
                    backgroundColor: "lightyellow",
                    }}>
      <Text style={{fontSize: 24,
                    textAlign: "center"}}>
        Navegação com Abas
      </Text>
      <NavigationContainer>
        <Navigator screenOptions={{
                headerShown: false
              }}>
          <Screen name="Principal" component={Principal}
            options={{
              tabBarIcon: () => 
                <Entypo name="home"
                        size={32}
                        color="red"/>
            }}
          />
          <Screen name="Config" component={Config}
            options={{
              tabBarIcon: () => 
                <Entypo name="cog"
                        size={32}
                        color="red"/>
          }}/>
        </Navigator>
      </NavigationContainer>
    </View>
  );
}