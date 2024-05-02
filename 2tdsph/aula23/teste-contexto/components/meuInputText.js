import { Text, TextInput, View } from "react-native";


export const MeuInputText = ( props ) => {
    return (
        <View>
            <TextInput {...props}/>
            <Text style={{
              color: "red",
              fontSize: 9  
            }}>{props.errorMessage}</Text>
        </View>
    )
}

export default {MeuInputText}