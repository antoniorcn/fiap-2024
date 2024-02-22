import React from 'react';
import { Text, View } from 'react-native';
function App() {
  return (
      <View style={{
        flexDirection: "column",
        justifyContent: "flex-end",
        backgroundColor: "blue",
        flex: 1,
        }}>
          <View style={{flex: 2, backgroundColor: "yellow"}}/>
          <View style={{  flex: 6, 
                          backgroundColor: "pink", 
                          flexDirection: "row",
                          justifyContent: "space-evenly",
                          alignItems: "stretch"}}>
             <View style={{width: 50, backgroundColor:"black"}}/>
             <View style={{width: 50, backgroundColor:"purple"}}/>
             <View style={{width: 50, height: 50, 
                            alignSelf: "flex-start", 
                            backgroundColor:"green"}}/>
          </View>
          <View style={{flex: 2, backgroundColor: "orange"}}/>
      </View>
  );
}
export default App;