import requests
import json


print("Programa Horario Mundial")
cidade = input("Digite o nome da cidade no mundo para saber o horário local: ")

parametros = {
    'key': '16a4068f7acd49c88cb120121240710',
    'q': cidade
} 
response = requests.get("https://api.weatherapi.com/v1/timezone.json", params=parametros)
# print(response.content)
dicionario = json.loads(response.content)
print(f"O horario atual de {cidade} é {dicionario['location']['localtime']}")