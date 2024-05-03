import { useState } from 'react';
import axios from 'axios';

const api = axios.create({
    baseURL: "https://9f6f2eec-b35c-4d9f-8123-8b56994ade09-00-3a8fl1jtulkuh.spock.replit.dev"
})
  
export const notificar = ( mensagem ) => {
    // ToastAndroid.show(mensagem, ToastAndroid.LONG);
    alert(mensagem);
}

export const useCardapioControl = () => {

    const [lista, setLista] = useState([]);

    const logar = (email, password) => {
        if (email === "admin@teste.com" && 
        password === "abc123") { 
            carregar();
            return true;
        } else { 
            return false;
        }
    }

    const salvar = ( obj ) => { 
        api.post("/cardapio", obj)
        .then((response)=>{
            notificar("Cardapio salvo com sucesso");
            carregar();
        })
        .catch( (err)=> { notificar("Erro ao gravar o cardapio: " + err) })
    }
  
    const carregar = () => {
        api.get("/cardapio")
        .then( (response) => {setLista(response.data)} )
        .catch( (err)=> { notificar("Erro ao ler os dados: " + err) })
    }
    return {carregar, salvar, logar, lista}
}


export default {useCardapioControl, notificar};