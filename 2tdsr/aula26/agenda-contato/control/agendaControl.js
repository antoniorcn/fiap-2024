import { useState } from 'react'; 

export const useAgendaControl = () => { 
    const [lista, setLista] = useState([]);
    const gravar = ( obj ) => { 
      setLista([...lista, obj]);
    }
    return { gravar, lista }
}

export default { useAgendaControl }