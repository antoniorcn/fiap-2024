import React from 'react';
import { Text, View } from 'react-native';

function App() {
  return (
      <View style={{
        flexDirection: "column",
        justifyContent: "flex-end",
        backgroundColor: "blue",

        height: "100%"

        }}>
        <Text>Texto 1</Text>
        <Text>Texto 2</Text>
        <Text>Texto 3</Text>
      </View>
  );
}

export default App;