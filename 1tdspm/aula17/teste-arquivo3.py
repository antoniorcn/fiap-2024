lista = [
    {"nome": "Joao Silva", "tel": "1111", "email": "joao@teste.com"},
    {"nome": "Maria Silva", "tel": "2222", "email": "maria@teste.com"},
    {"nome": "Rodrigo Alberto", "tel": "3333", "email": "rodrigo@teste.com"},
    {"nome": "Valeria Carraro", "tel": "4444", "email": "valeria@teste.com"},
]

# Comma Separated Value (CSV)
#   Joao Silva, 1111, joao@teste.com
#   Maria Silva, 2222, maria@teste.com

arq1 = open("./contatos.csv", "w", encoding="utf-8")

# o1 = {"nome": "Joao Silva", "tel": "1111", "email": "joao@teste.com"}
# arq1.write(o1["nome"] + ", " + o1["tel"] + ", " + o1["email"])

# Escreve o cabecalho
arq1.write("Nome, Telefone, Email")
for contato in lista:
    arq1.write(contato["nome"] + ", " + contato["tel"] + ", " + contato["email"])
    arq1.write("\n")
arq1.close()