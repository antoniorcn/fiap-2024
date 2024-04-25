arq1 = open("./contatos.csv", "r", encoding="utf-8")
linha = "-"
while linha != "":
    linha = arq1.readline().replace("\n", "").strip()
    if linha != "": 
        campos = linha.split(",")
        contato = {}
        contato["nome"] = campos[0].strip()
        contato["telefone"] = campos[1].strip()
        contato["email"] = campos[2].strip()
        print("Linha: ", linha)
        print("Contato: ", contato)

# Replace
# texto = "ola Mundo"
# texto.replace("o", "0")
# print(texto) => "0la Mund0"

# Strip
# texto = "   A B C 1 23   "
# texto.strip()
# print(texto)  => "A B C 1 23"

# Split
# texto = "O mundo é perfeito"
# lista = texto.split(" ")
# print(lista) => ["O", "mundo", "é", "perfeito"]

# Palavra para Lista
# texto = "ABCDE"
# lista = list(texto)
# print(lista) => ['A', 'B', 'C', 'D', 'E']