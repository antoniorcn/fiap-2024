import requests

url = "https://tdspm-f7cb0-default-rtdb.firebaseio.com/contatos.json"

contato = { "nome": "Aberto Santos", 
            "telefone": "(13) 4444-4444",
            "email": "alberto@teste.com"
        }

response = requests.post( url, json=contato )
print(response)