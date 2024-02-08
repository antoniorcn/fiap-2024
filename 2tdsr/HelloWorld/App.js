import React from 'react';
import {View, Text} from 'react-native';


function App() { 
  return (
    <>
      <Text>Ola mundo !!!!</Text>
      <Text>Linha 2</Text>
      <Text>Linha 3</Text>
    </>
  )
}

function App1() { 
  return (
    <React.Fragment>
      <Text>Ola mundo !!!!</Text>
      <Text>Linha 2</Text>
      <Text>Linha 3</Text>
    </React.Fragment>
  )
}

function App2() { 
  return (
    [
      <Text>Ola mundo !!!!</Text>,
      <Text>Linha 2</Text>,
      <Text>Linha 3</Text>
    ]
  )
}

function App3() { 
  return (
    [
      <Text>Ola mundo !!!!</Text>,
      <Text>Linha 2</Text>,
      <Text>Linha 3</Text>
    ]
  )
}

function App4 () { 
  return (
    [<App1/>, <App2/>]
  )
}


export default App4;