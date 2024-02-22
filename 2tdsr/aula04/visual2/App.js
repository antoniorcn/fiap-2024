import React from 'react';
import { Text, View } from 'react-native';
function App() {
  return (
      <View style={{width: "100%", height: "100%"}}>
        <Text style={{position: "absolute", left: 200}}>Ola</Text>
        <Text style={{position: "absolute", bottom: 50, right: 10}}>Mundo</Text>
      </View>
  );
}
export default App;