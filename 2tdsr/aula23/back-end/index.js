const express = require("express");
const cors = require("cors");
const api = express();
const lista = [];
api.use(express.json());
api.use(cors());
api.post("/cardapio", (request, response) => {
  lista.push(request.body);
  response.status(200).send({
    msg: "Prato do cardapio cadastrado com sucesso",
  });
  console.log("Cardapio gravado");
});

api.get("/cardapio", (request, response) => {
  response.status(200).send(lista);
  console.log("Cardapio lido");
});

api.get("/", (request, response) => {
  console.log("recurso / acionado...");
  response.send("Bem vindo ao sistema de Restaurante em NodeJS");
});

api.listen(80, () => {
  console.log("Servidor iniciado");
});
