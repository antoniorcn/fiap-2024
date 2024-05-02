import { useEffect, useState } from 'react';
import fetcher from '../fetcher/agendaAPIWeb';


const useAgendaControl = () => { 
  
  const [lista, setLista] = useState([])
  const [atualizar, setAtualizar] = useState(0)
  const [logado, setLogado] = useState(false);
  const [token, setToken] = useState(null);

  const notificar = ( msg ) => {
    alert(msg);
    // ToastAndroid.show( msg, ToastAndroid.LONG);
  }

  useEffect( () => { 
    if(token) {
      carregarContatos();
    }
  }, [atualizar]);

  const salvar = (obj)=>{
    fetcher.salvar( token, obj )
    .then( ()=>{
      notificar("Dados salvos...");
      setAtualizar(atualizar + 1)
    })
    .catch( (err)=>{
      notificar("Erro ao salvar os dados..." + err);
    } )
  }

  const apagar = ( id ) => {
    fetcher.apagar( token, id )
    .then( () => {
      notificar("Registro apagado");
      setAtualizar(atualizar + 1);
    })
    .catch( (err)=>{
      notificar("Erro ao apagar o registro..." + err);
    })
  }

  const carregarContatos = () => {
    fetcher.carregarTodos( token )
    .then( (response)=>{
      const listaTemp = []
      // notificar("Dados Carregados: " + JSON.stringify(response.data.data));
      for (let i = 0; i < response.data.data.length; i++) {
        const obj = response.data.data[i];
        obj.id = i;
        listaTemp.push( obj )
      }
      setLista( listaTemp );
    })
    .catch( (err)=>{
      notificar("Erro ao carregar os dados: " + err);
    })
  }

  const logar = ( user, password ) => {
    fetcher.logar( token, user, password )
    .then((resposta)=>{
      // notificar("Dados: " + JSON.stringify(resposta.data));
      setToken(resposta.data.token);
      setLogado(true);
      setAtualizar(atualizar + 1);
    })
    .catch((err)=>{
      notificar("Erro ao fazer o login: " + err);
    })
  }

  return {logar, salvar, carregarContatos, apagar, lista, logado}

}

export {useAgendaControl};