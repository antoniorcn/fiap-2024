import requests
import json
import os

CLIENT_ID = os.environ['SPOTIFY_CLIENT_ID']
CLIENT_SECRET = os.environ['SPOTIFY_CLIENT_SECRET']

parametros = {
    'grant_type': 'client_credentials',
    'client_id': CLIENT_ID,
    'client_secret': CLIENT_SECRET
} 

headers = { 
    'Content-Type': 'application/x-www-form-urlencoded'
}
response = requests.post("https://accounts.spotify.com/api/token", params=parametros, headers=headers)
# print(response.content)
dicionario = json.loads(response.content)
print(dicionario)