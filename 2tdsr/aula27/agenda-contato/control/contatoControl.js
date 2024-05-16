import { useState } from 'react';
import { contatoSchema } from '../models/contato';
import { gravarAPI, lerContatosAPI } from '../fetchers/contatoFetcher';
export const useControl = () => { 

    const [lista, setLista] = useState([]);

    const gravar = ( obj ) => { 
        contatoSchema.validate( obj )
        .then(()=>{
            gravarAPI( obj )
            .then(()=>{
                alert("Contato foi gravado com sucesso");
                lerContatos();
            })
            .catch((err)=>{
                alert("Erro ao gravar o contato: " + err)
            })
        })
        .catch(( erro )=>{
            alert("Erro: " + erro.message)
        })
    } 

    const lerContatos = () => { 
        lerContatosAPI()
        .then((response)=>{
            setLista( [...response.data] )
        })
        .catch((err)=>{
            alert("Erro ao ler os contatos: " + err)
        })
    }

    return { gravar, lista, lerContatos }

}

export default { useControl }