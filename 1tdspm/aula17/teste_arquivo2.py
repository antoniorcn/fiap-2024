arq1 = open("./teste.txt", "a", encoding="utf-8")

arq1.write("GHI")
arq1.flush()

print("Tecle enter")
input()