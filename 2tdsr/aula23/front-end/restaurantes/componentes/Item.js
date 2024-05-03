import {Text, View} from 'react-native';

export const Item = (props) => { 
    return (
      <View style={{borderWidth: 2, padding: 5, margin: 5}}>
        <Text>{props.item.nome}</Text>
        <Text>{props.item.tipo}</Text>
        <Text>{props.item.calorias}</Text>
      </View>
    )
  }

export default { Item }