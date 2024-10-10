import json
import requests
from Contato import Contato

class ContatoService:
    def __init__(self):
        self.URL_BASE = "https://tdspm-f7cb0-default-rtdb.firebaseio.com"

    def salvar(self, contato : Contato) -> bool:
        # contato_json = json.dumps( contato.dicionario() )
        # print("Contato JSON: ", contato_json)
        response = requests.post(url=f"{self.URL_BASE}/contatos.json",
                      json=contato.dicionario(), timeout=5.0)
        # if response.status_code == 200:
        #     return True
        # else:
        #     return False
        return response.status_code == 200
        # print("Response Status: ", response.status_code)
        # print("Response Body: ", response.text)

    def ler_todos(self) -> list:
        response = requests.get(url=f"{self.URL_BASE}/contatos.json", timeout=5.0)
        # print("Response Status: ", response.status_code)
        lista = []
        if response.status_code == 200:
            # print("Response Body:", response.text)
            dicionario = json.loads(response.text)
            for item in dicionario.items():
                # print(item)
                contato_dict = item[1]
                c1 = Contato(nome=contato_dict.get("nome", ""),
                             email=contato_dict.get("email", ""),
                             telefone=contato_dict.get("telefone", ""))
                lista.append( c1 )
        return lista


# c1 = Contato("Joao Silva", "(11) 1111-1111", "joao@teste.com")
# contato_service = ContatoService()
# # contato_service.salvar( c1 )
# lista = contato_service.ler_todos()
# print("Lista: ")
# for contato in lista:
#     print(contato)