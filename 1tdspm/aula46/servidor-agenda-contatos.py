from http.server import BaseHTTPRequestHandler, HTTPServer
import json

lista = []

class MeuRequestHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("content-type", "application/json")
        self.end_headers()
        texto_json = json.dumps(lista)
        self.wfile.write(texto_json.encode('utf-8'))
    def do_POST(self):
        self.send_response(200)
        self.send_header("content-type", "application/json")
        self.end_headers()
        texto = ""
        remaining_bytes = int(self.headers['content-length'])
        while remaining_bytes > 0:
            line = self.rfile.readline()
            texto += line.decode("utf-8")
            print("Lido: ", texto)
            remaining_bytes -= len(line)
            print("Remaining Bytes: ", remaining_bytes)
        print("Texto final: ", texto)
        lista.append(json.load(texto))
        
print("Iniciando o servidor")
servidor = HTTPServer( ('127.0.0.1', 80), MeuRequestHandler)
print("Aguardando conexao")
servidor.serve_forever()
