import axios from 'axios';

const apiweb = axios.create({ 
  baseURL: "https://ccf4a5f3-12f3-4c98-be87-c8f753e6ef93-00-cnhwmnaaj8im.riker.replit.dev"
})

export const gravarAPI = ( obj ) => { 
    return apiweb.post("/contato", obj)
}

export const lerContatosAPI = () => { 
    return apiweb.get("/contato")
}

export default { gravarAPI, lerContatosAPI }