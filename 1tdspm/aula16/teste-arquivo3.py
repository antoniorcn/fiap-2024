arq1 = open("./nomes.txt", "r", encoding="utf-8")
texto = arq1.readline()
print(texto)

texto = arq1.readline()
print(texto)

arq1.close()