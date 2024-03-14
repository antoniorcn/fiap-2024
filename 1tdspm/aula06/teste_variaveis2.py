a = 79

# Como pegar este valor da variavel (a) 
# como sendo octal

a_em_octal = oct( a )
print("A em octal: ", a_em_octal)

# Bases numericas
# Algarismos Binários:  0 ou 1
# Algarismos Octais: 0, 1, 2, 3, 4, 5, 6, 7
# Algarismos Decimais: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
# Algarismos Hexadecimais: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F

n1 = 8170990732  # 8.170.990.732
numero_em_binario = bin(n1)
numero_em_octal = oct(n1)
numero_em_hexadecimal = hex(n1)
print("N1: ", n1)
print("Numero Binario: ", numero_em_binario)
print("Numero Octal: ", numero_em_octal)
print("Numero Hexadecimal: ", numero_em_hexadecimal)

n1       #  8170990732
str(n1)  #  "8170990732"
print("Habitantes da terra são: " + str(n1) )
print("Habitantes da terra são: ", n1)

f = 971.72424726
i = int(f)      # 971
s = str(i)      # "971"
print("Numero Float: ", f)
print("Parte Inteira: ", i)
print("Parte Inteira: " + s)