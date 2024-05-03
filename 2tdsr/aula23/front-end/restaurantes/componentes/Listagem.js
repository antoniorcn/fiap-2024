import {Button, FlatList, Text, View} from 'react-native';
import { Item } from './Item';

export const Listagem = (props) => { 
    return (
      <View style={{flex: 1}}>
        <Text style={{fontSize: 38}}>Tela de Listagem</Text>
        <Button title="Formulario" onPress={()=>{
          props.navigation.navigate("Formulario")
        }}/>
        <Button title="Logout" onPress={()=>{
          props.navigation.navigate("Login")
        }}/>
        <FlatList data={props.lista} renderItem={Item} />
      </View>
    )
  }

  export default { Listagem }