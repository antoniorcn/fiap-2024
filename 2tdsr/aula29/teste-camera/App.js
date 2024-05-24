import { StatusBar } from 'expo-status-bar';
import { Button, Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { CameraView, useCameraPermissions } from 'expo-camera';
import { useState, useRef } from 'react';
import * as FileSystem from 'expo-file-system';

export default function App() {
  const docDir = FileSystem.documentDirectory;
  const localFile = docDir + 'photo1.jpg';

  const [permissions, requestPermission] = useCameraPermissions();
  const [face, setFace] = useState("back");

  const cameraRef = useRef(null);

  const [fotoTirada, setFotoTirada] = useState(null);
  
  const [cameraPronta, setCameraPronta] = useState(false);

  const toggleFace = () => { 
    setFace(face == "back" ? "front" : "back");
  }

  const tirarFoto = () => {
    cameraRef.current.takePictureAsync({base64: true})
    .then((pictureData)=>{ 
      console.log(pictureData.base64);
      setFotoTirada("data:image/png;base64," + pictureData.base64);
    // FileSystem.downloadAsync(pictureData.uri, localFile)
    //           .then(({uri}) => {
    //             console.log('Finished downloading to ' + uri);
    //             setFotoTirada(uri);
    //           })
    //           .catch((error) => {
    //             console.error(error);
    //           });
     })
    .catch((err)=>{alert("Erro ao tirar a foto: " + err)})
  }

  if (!permissions) { 
    return (<View/>)
  }

  if (!permissions.granted) {
    return (
      <View>
        <Text>Solicitação de permissão de uso da camera</Text>
        <Button title="Solicitar permissão de câmera"
                onPress={requestPermission}/>
      </View>
    )
  } else { 
    return (
      <View style={styles.container}>
        <Text>Teste de Camera</Text>
        {fotoTirada ? 
        (<Image style={{flex: 1}} source={{uri: fotoTirada}}
          width={300} height={200} />) :
        (<Text style={{margin: 20, flex: 1}}>Sem Foto</Text>)}
        <CameraView style={styles.camera} facing={face} 
                    ref={cameraRef}
                    onCameraReady={()=>{setCameraPronta(true)}}>
          <View style={styles.buttonContainer}>
            <TouchableOpacity style={styles.button} onPress={toggleFace}>
              <Text style={styles.text}>Flip Camera</Text>
            </TouchableOpacity>
            { cameraPronta ? (
              <TouchableOpacity style={styles.button} 
                onPress={tirarFoto}>
                <Text style={styles.text}>Tirar Foto</Text>
              </TouchableOpacity>) : (<></>)
            }
          </View>
      </CameraView>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  camera: {
    flex: 3,
  },
  buttonContainer: {
    flex: 1,
    flexDirection: 'row',
    backgroundColor: 'transparent',
    margin: 64,
  },
  button: {
    flex: 1,
    alignSelf: 'flex-end',
    alignItems: 'center',
  },
  text: {
    fontSize: 24,
    fontWeight: 'bold',
    color: 'white',
  },
});
