import { View, Text, FlatList } from 'react-native';

const Item = (props) =>
    <View>
        <Text>Nome: {props.item.nome}</Text>
        <Text>Telefone: {props.item.telefone}</Text>
    </View>

export default Listagem = (props) => {
    return (
        <View style={{flex: 1}}> 
            <FlatList data={props.lista}
                renderItem={Item}/>
        </View>
    );
}