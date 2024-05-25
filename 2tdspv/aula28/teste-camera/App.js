import { StatusBar } from 'expo-status-bar';
import { Image, TouchableOpacity, Button, StyleSheet, Text, View, ToastAndroid } from 'react-native';
import { CameraView, CameraType, useCameraPermissions } 
	from 'expo-camera'; 
import { useState, useRef } from 'react';


export default function App() {
  const [permissions, requestPermission] = useCameraPermissions();
  const [cameraFace, setCameraFace] = useState("back");
  const [cameraFuncionando, setCameraFuncionando] = useState(false);
  const [imagem, setImage] = useState(null);
  const cameraRef = useRef(null);

  const takePicture = () => { 
    cameraRef.current.takePictureAsync({base64: true})
    .then(( picture )=>{
      const tempImg = 'data:image/jpeg;base64,' + picture.base64;
      // const tempImg = 'data:image/jpg;base64,' + 'iVBORw0KGgoAAAANSUhEUgAAADMAAAAzCAYAAAA6oTAqAAAAEXRFWHRTb2Z0d2FyZQBwbmdjcnVzaEB1SfMAAABQSURBVGje7dSxCQBACARB+2/ab8BEeQNhFi6WSYzYLYudDQYGBgYGBgYGBgYGBgYGBgZmcvDqYGBgmhivGQYGBgYGBgYGBgYGBgYGBgbmQw+P/eMrC5UTVAAAAABJRU5ErkJggg==';
      setImage(tempImg);
      console.log("Width: ", picture.width, 
        "   Height: ", picture.height,
        "Base64: ", tempImg.substring(0, 50))
      ToastAndroid.show("Foto tirada", ToastAndroid.LONG);
    })
    .catch((err)=>{ 
      ToastAndroid.show("Erro ao tirar a foto: " + err, 
      ToastAndroid.LONG)})
  }

  const cameraPronta = () => { 
    setCameraFuncionando(true);
  }

  if (!permissions) {
    return (
      <View style={{flex: 1, justifyContent: "center"}}>
        <Text>Camera não está disponível</Text>
      </View>
    )
  }

  if (!permissions.granted) { 
    return (
      <View style={{flex: 1, justifyContent: "center"}}>
        <Text>{JSON.stringify(permissions)}</Text>
        <Button title="Permitir uso da Camera" onPress={()=>{
          requestPermission();
        }}/>
      </View>
    )
  }

  return (
    <View style={styles.container}>
      <Text>Teste de Camera</Text>
      <View style={{flex: 1}}>
        {imagem ? 
          <Image style={{flex: 1}} resizeMethod="resize"
          resizeMode="contain"
          source={{
            uri: imagem,
          }}/>
        : <View style={{flex: 1}}></View>
        }
        <CameraView ref={cameraRef}
            style={{flex: 2}} facing={cameraFace}
            onCameraReady={cameraPronta}>
          <TouchableOpacity onPress={()=>{
            setCameraFace( 
              cameraFace === "back" ? "front": "back"
            )
          }}
          style={{
              position: "absolute",
              backgroundColor: "blue", 
              width: 50, height: 50,
              right: 30,
              bottom: 100,
              borderRadius: 25,
              justifyContent: "center",
              alignItems: "center"}}>
              <Text style={{
                color: "white",
                fontSize: 20}}>Flip</Text>
          </TouchableOpacity>
          { cameraFuncionando ? <TouchableOpacity
          onPress={takePicture}
          style={{
              position: "absolute",
              backgroundColor: "red", 
              width: 50, height: 50,
              right: 30,
              bottom: 30,
              borderRadius: 25,
              justifyContent: "center",
              alignItems: "center"}}>
              <Text style={{
                color: "white",
                textAlign: "center",
                fontSize: 12}}>Take Picture</Text>
          </TouchableOpacity>
          : <></> }
        </CameraView>
      </View>
   
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    justifyContent: 'center',
  },
});
