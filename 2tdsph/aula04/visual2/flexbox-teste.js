import React from 'react';
import {View} from 'react-native';

function App() { 
  return(

    <View style={{  flexDirection: "column", 
                    backgroundColor: "yellow", flex: 1,
                    justifyContent: "space-evenly",
                    alignItems: "stretch"
                    }}>
      <View style={{height: 50,
                    backgroundColor:"red"}}></View>
      <View style={{height: 50,
                    backgroundColor:"blue"}}></View>
      <View style={{height: 50,
                    backgroundColor:"green"}}></View>                    
    </View>

  )
}

export default App;