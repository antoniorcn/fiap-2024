import socket

HOST = "127.0.0.1"
PORT = 10000

servidor = socket.socket(socket.AF_INET,
                        socket.SOCK_STREAM)
print("Servidor criado")

servidor.bind( (HOST, PORT) )
print(f"Servidor conectado na interface {HOST} na porta {PORT}")

servidor.listen()
print(f"Aguardando cliente se conectar na porta {PORT}")

cliente_conexao, cliente_addr = servidor.accept()
print(f"Cliente no endereço: {cliente_addr} conectou no servidor")

mensagem = """
HTTP/1.1 200 OK
Date: Thu, 05 Sep 2024 12:28:53 GMT
Server: Apache/2.2.14 (Win32)
Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT
Content-Length: 88
Content-Type: text/html
Connection: Closed

<html>
<body>
<h1>Hello, World!</h1>
</body>
</html>



"""


# cliente_conexao.sendall("Olá eu sou o servidor feito em Python...".encode("latin1"))
cliente_conexao.sendall(mensagem.encode("utf-8"))

while True:
    menssagem_bytes = cliente_conexao.recv(1024)
    texto = menssagem_bytes.decode("utf-8")
    # print("Mensagem Recebida do cliente: ", texto)
    print(texto, end="")
    if texto == "X":
        break


cliente_conexao.close()