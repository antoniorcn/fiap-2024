import { object, string, number } from 'yup';

export const contatoSchema = object({
  nome: string()
        .required("O nome é obrigatório")
        .min(3, "O nome precisa ter no minimo ${min} letras")
        .max(50, "O nome precisa ter no maximo ${max} letras"),
  telefone: string().required().min(10).max(20),
  email: string().required().email(),
  endereco: string().nullable(),
  numero: number().integer().positive(),
  cep: string().min(8).max(9),
  idade: number().integer().positive().required()
})

export default { contatoSchema }