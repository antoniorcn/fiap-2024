arq1 = open("d:/temp/teste6/nomes.txt", "r")

caracteres = arq1.read(5)
print("Caracteres-1: ", caracteres)

caracteres = arq1.read(3)
print("Caracteres-2: ", caracteres)
# 01234 56789
# Joao\nMaria


# arq1.readline()
# arq1.readlines()

arq1.close()