from random import randint
from http.server import BaseHTTPRequestHandler, HTTPServer
def numeros_mega_sena():
    numeros = []
    i = 0
    while i < 6:
        numero = randint(1, 60)
        if numero not in numeros:
            numeros.append(numero)
            i = i + 1
    return numeros
class MeuRequestHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        print("Cliente se conectou e pediu um GET")
        self.send_response(200)
        self.send_header("content-type", "text/plain")
        self.end_headers()
        self.wfile.write(b"Servidor de Numeros da Mega Sena")
        numeros = numeros_mega_sena()
        self.wfile.write( f"{numeros}".encode('utf-8') )
print("Iniciando o servidor")
servidor = HTTPServer( ('127.0.0.1', 80), MeuRequestHandler)
print("Aguardando conexao")
servidor.serve_forever()
