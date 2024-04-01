import { useState } from 'react';
import { Button, View, Text, TextInput } from 'react-native';


const Formulario = (props) => {
    const [nome, setNome] = useState("");
    return (
        <View> 
            <Text>Nome Completo</Text>
            <TextInput value={nome} 
                onChangeText={setNome}/>
            <Button title="Salvar" onPress={()=>{
                props.salvar( nome );
            }}/>
        </View>
    );
}

const Listagem = (props) => {
    return (
        <View>
            <Text>Listagem</Text>
            {props.listaVisual}
        </View>
    )
}

const App = () => {
    const [lista, setLista] = useState([]);

    const salvar = ( valor ) => { 
        setLista( [...lista, valor] )
    }

    const listaVisual = lista.map( (item, idx) => { 
        return (
            <View key={idx}>
                <Text>{item}</Text>
            </View>
        )
    })

return (
    <View> 
        <Formulario nome={nome} setNome={setNome}
                    salvar={salvar}/>
        <Listagem listaVisual={listaVisual}/>
    </View>
)
}