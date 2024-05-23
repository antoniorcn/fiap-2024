import os
tabuleiro = [
    ["TW", "HW", "BW", "KW", "QW", "BW", "HW", "TW"],
    ["PW", "PW", "PW", "PW", "PW", "PW", "PW", "PW"],
    ["", "", "", "", "", "", "", ""],
    ["", "", "", "", "", "", "", ""],
    ["", "", "", "", "", "", "", ""],
    ["", "", "", "", "", "", "", ""],
    ["PB", "PB", "PB", "PB", "PB", "PB", "PB", "PB"],
    ["TB", "HB", "BB", "QB", "KB", "BB", "HB", "TB"]
]

def mover_peca(linha_origem, coluna_origem, linha_destino, coluna_destino): 
    tabuleiro[linha_destino][coluna_destino] = \
    tabuleiro[linha_origem][coluna_origem]
    tabuleiro[linha_origem][coluna_origem] = ""


def mostrar_tabuleiro():
    os.system("CLS")
    print("   ", "-"*41)
    for numero_linha, linha in enumerate(tabuleiro):
        print(numero_linha + 1, " ", end="")
        for casa in linha:
            print(f"|{casa:^4}", end="")
        print("|")
        print("   ", "-"*41)
    print("   ", end="") 
    for caractere in "ABCDEFGH":
        print(f" {caractere:^4}", end="")
    print(" ")


def ler_movimento():
    mapa = {"A": 0, "B": 1, "C": 2, "D": 3, "E": 4, "F": 5, "G": 6, "H": 7}
    print("Informe qual é a casa de origem ==> ", end="")
    casa_origem = input().upper()
    letra = casa_origem[0]
    coluna_origem = mapa[letra]
    linha_origem = int(casa_origem[1]) - 1
    print("Informe qual é a casa de destino ==> ", end="")
    casa_destino = input().upper()
    letra = casa_destino[0]
    coluna_destino = mapa[letra]
    linha_destino = int(casa_destino[1]) - 1
    mover_peca(linha_origem, coluna_origem, linha_destino, coluna_destino)



while True:
    mostrar_tabuleiro()
    ler_movimento()
