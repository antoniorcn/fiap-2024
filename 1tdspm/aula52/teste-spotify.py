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
print("CLIENT_ID: ", CLIENT_ID)
print("CLIENT_SECRET: ", CLIENT_SECRET)

response = requests.post("https://accounts.spotify.com/api/token", params=parametros, headers=headers)
dicionario = json.loads(response.content)
access_token=dicionario['access_token']
print("Access Token: ", access_token)

# Check Player State
headers = { 
    'Authorization': f"Bearer {access_token}"
}
print("Headers: ", headers)
response = requests.get("https://api.spotify.com/v1/me/player", headers=headers)
dicionario = json.loads(response.content)
print(dicionario)