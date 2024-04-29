const PORT = 80;
const express = require("express");
const cors = require("cors");
const jwt = require("jsonwebtoken");
const SECRET = process.env.CHAVE_SECRETA;
const appWeb = express();
const lista = [];

appWeb.use(cors());
appWeb.use(express.json());

const filtroToken = (request, response, next) => {
  const authHeader = request.headers["authorization"];
  if (authHeader) {
    const token = authHeader.substring(7, authHeader.length).trim();
    if (token) {
      jwt.verify(token, SECRET, (err, encoded) => {
        if (err) {
          response.status(403).send({ msg: "Token invalido" });
          return;
        } else {
          next();
        }
      });
    }
  }
  response.status(403).send({ msg: "Token inexistente" });
  return;
};

appWeb.get("/", (request, response) => {
  console.log("Recebeu pedido no recurso /");
  response.send("Ola voce acessou o web server em node :-)");
});

appWeb.post("/login", (request, response) => {
  console.log("Recebido: " + JSON.stringify(request.body));
  const token = jwt.sign(
    {
      usuario: request.body.user,
      perfil: "admin",
    },
    SECRET,
  );
  response.send({ msg: "sucesso", token: token });
});

appWeb.post("/contato", filtroToken, (request, response) => {
  lista.push(request.body);
  response.send({ msg: "sucesso" });
});

appWeb.delete("/contato/:id", filtroToken, (request, response) => {
  const id = parseInt(request.params.id);
  lista.splice(id, 1);
  response.send({ msg: "sucesso" });
});

appWeb.get("/contato", filtroToken, (request, response) => {
  response.send({ msg: "sucesso", data: lista });
});

appWeb.listen(PORT, () => {
  console.log("Ouvindo a porta 80");
});
