import {View, Text} from 'react-native';
import { Contexto } from '../contexto/contexto';

export const OutroComponente = () => { 
    return (
      <Contexto.Consumer>
        { ( valor )=>
          <View>
            <Text>Nome:  {valor}</Text>
          </View>
        }
      </Contexto.Consumer>
    )
  }
export default { OutroComponente };