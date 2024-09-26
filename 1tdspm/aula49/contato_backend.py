from http.server import BaseHTTPRequestHandler, HTTPServer
import json
from contato_repository import ContatoRepository
from contato_model import Contato

class ContatoBackend( BaseHTTPRequestHandler ):
    def do_GET(self):
        print("Conexão GET recebida")
        try:
            lista = []
            lista.extend(repository.ler_todos())
            self.send_response(200)
            self.send_header("content-type", "application/json")
            self.end_headers()
            texto_json = json.dumps(lista, default=vars)
            self.wfile.write(texto_json.encode('latin1'))
            # self.wfile.write(texto_json)
        except Exception:
            self.send_response(500)
            self.send_header("content-type", "text/plain")
            self.end_headers()
            self.wfile.write("Erro ao acessar o banco de dados".encode('utf-8'))

    def do_POST(self):
        print("Conexão POST recebida")
        try:
            self.send_response(200)
            self.send_header("content-type", "application/json")
            self.end_headers()

            # Ler corpo do request para pegar os dados do contato
            texto = ""
            remaining_bytes = int(self.headers['content-length'])
            lido = self.rfile.read(remaining_bytes)
            # texto = lido.decode("latin1")
            texto = lido
            print("Lido: ", texto)
            dicionario_contato = json.loads( texto )
            contato = Contato(
                contato_id = 0,
                nome = dicionario_contato.get("nome", ""),
                email = dicionario_contato.get("email", ""),
                telefone = dicionario_contato.get("telefone", ""))
            repository.salvar( contato )
        except Exception:
            self.send_response(500)
            self.send_header("content-type", "text/plain")
            self.end_headers()
            self.wfile.write("Erro ao acessar o banco de dados".encode('utf-8'))

if __name__=="__main__":
    repository = ContatoRepository()
    print("Backend iniciado")
    http_server = HTTPServer( ('127.0.0.1', 80), ContatoBackend )
    print("HTTP Server iniciado aguardando conexões")
    http_server.serve_forever()