lista = [
    {"nome": "Joao", "telefone": "(11)111-111", "idade": 24},
    {"nome": "Maria", "telefone": "(11)222-222", "idade": 26},
    {"nome": "Jose", "telefone": "(11)333-333", "idade": 28}    
]

arq1 = open("D:/temp/teste6/nomes-idades.csv", "w", encoding="utf-8")

# indice = 0
# while indice < len(lista):
#     d = lista[indice]
#     # {"nome": "Joao", "telefone": "(11)111-111", "idade": 24}
#     # Joao;(11)111-111;24
#     arq1.write( d["nome"]+";"+d["telefone"]+";"+str(d["idade"])+"\n" )
#     indice = indice + 1

for d in lista:
    # arq1.write(d["nome"]+";"+d["telefone"]+";"+d["idade"]+"\n")
    arq1.write(f"{d['nome']};{d['telefone']};{d['idade']}\n")

arq1.close()