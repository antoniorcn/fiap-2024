const express = require("express");
const cors = require("cors");
const api = express();
const lista = [];
api.use(express.json());
api.use(cors());
console.log("Backend iniciado");

api.get("/", (request, response) => {
  console.log("Pedido GET atendido no recurso raiz (/)");
  response.send("Backend para gestão de Contatos");
});

api.post("/contato", (request, response) => {
  console.log("Recebido POST com JSON");
  response.send("Contato adicionado com sucesso");
  console.log("Objeto de contato ==> " + JSON.stringify(request.body));
  lista.push(request.body);
});

api.get("/contato", (request, response) => {
  response.send(lista);
});

api.delete("/contato/:index", (request, response) => {
  const indice = parseInt(request.params.index);
  lista.splice(indice, 1);
  response.send("Objeto " + indice + " apagado com sucesso");
});

api.listen(80, () => {
  console.log("Servidor está sendo executado...");
});
