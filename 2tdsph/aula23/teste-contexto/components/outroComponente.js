import {View, Text} from 'react-native';
import { Contexto } from '../contexto/contexto';

export const OutroComponente = () => { 
    return (
      <Contexto.Consumer>
        { ( {nome, telefone, email} )=>
          <View>
            <Text>Nome:  {nome}</Text>
          </View>
        }
      </Contexto.Consumer>
    )
  }
export default { OutroComponente };