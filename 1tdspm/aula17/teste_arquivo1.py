arq1 = open("./teste.txt", "w", encoding="utf-8")
arq1.write("ABC")
# A informação é mandada para um elemento
# chamado Buffer
arq1.write("DEF")
# A informação é mandada para um elemento
# chamado Buffer

arq1.flush()
print("Tecle enter")
input()

print("Fim do programa")