import requests
import json
url = "https://tdspm-f7cb0-default-rtdb.firebaseio.com/contatos.json"
response = requests.get( url, timeout=100 )
texto = response.text
print("Response: ", response)
print("Corpo: ", texto)
contatos = json.loads( texto )
print("Chaves dos contatos:")
# for chave in contatos.keys():
#    print(chave)
for contato in contatos.values():
    print(f"Nome: {contato['nome']}\tEmail: {contato['email']}")
