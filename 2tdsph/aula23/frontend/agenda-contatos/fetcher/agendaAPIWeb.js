import axios from 'axios';

const api = axios.create({
  baseURL: "https://23e86c1b-f548-43e3-ad64-3b22bf894ee5-00-2vrq5tocvve5x.worf.replit.dev"
});

export const salvar = (token, obj ) => { 
    return api.post('/contato', obj, {
      headers: {"Authorization": "Bearer " + token}
    });
}

export const apagar = (token, id ) => { 
  const uri = "/contato/" + id;
  return api.delete(uri, {
    headers: {"Authorization": "Bearer " + token}
  })
}

export const carregarTodos = (token) => { 
  return api.get('/contato', {
      headers: {"Authorization": "Bearer " + token}
    })
}

export const logar = (user, password) => {
  return api.post('/login', {user, password})
}

export default {logar, carregarTodos, apagar, salvar}