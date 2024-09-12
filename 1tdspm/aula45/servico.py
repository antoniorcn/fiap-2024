import requests

class Servico:

    url = "https://tdspm-f7cb0-default-rtdb.firebaseio.com/contatos.json"

    def __init__(self):
        pass

    def cadastrar_firebase(self, contato):
        contato_dict = {
            "nome": contato.nome,
            "id": contato.contato_id,
            "telefone": contato.telefone,
            "email": contato.email,
            "nascimento": contato.nascimento.strftime("%d/%m/%Y")
        }
        response = requests.post( self.url, json=contato_dict, timeout=100 )
        return response
