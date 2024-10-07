import requests
import json
import os
import certifi

CLIENT_ID = os.getenv('SPOTIFY_CLIENT_ID')
CLIENT_SECRET = os.getenv('SPOTIFY_CLIENT_SECRET')

parametros = {
    'grant_type': 'client_credentials',
    'client_id': CLIENT_ID,
    'client_secret': CLIENT_SECRET
} 

headers = { 
    'Content-Type': 'application/x-www-form-urlencoded'
}

print("Certification File: ", certifi.where())

response = requests.post("https://accounts.spotify.com/api/token", verify=False, params=parametros, headers=headers)
# print(response.content)
# dicionario = json.loads(response.content)
print(response.content)