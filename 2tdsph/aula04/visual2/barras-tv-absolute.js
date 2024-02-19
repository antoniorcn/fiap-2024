import React from 'react';
import {View} from 'react-native';

function App() { 
  return(
    <View style={{position: "absolute", 
                  width: "100%", 
                  height: "100%",
                  backgroundColor: "black"}}>
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "white"}}>
      </View>
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "yellow", left: "14%"}}>
      </View>
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "cyan", left: "28%"}}>
      </View>      
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "lightgreen", left: "42%"}}>
      </View>    
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "magenta", left: "56%"}}>
      </View>        
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "red", left: "70%"}}>
      </View>                 
      <View style={{position: "absolute", width: "14%", height: "80%", backgroundColor: "blue", left: "84%"}}>
      </View>     
      <View style={{position: "absolute", width: "16%", height: "20%", backgroundColor: "navy", left: "0%", bottom: "0%"}}></View>     
      <View style={{position: "absolute", width: "16%", height: "20%", backgroundColor: "white", left: "16%", bottom: "0%"}}></View>      
      <View style={{position: "absolute", width: "16%", height: "20%", backgroundColor: "purple", left: "32%", bottom: "0%"}}></View>         
    </View>
  )
}

export default App;