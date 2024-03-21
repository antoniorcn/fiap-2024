print("Programa para calcular a média")

executar = True

while executar:
    print("Por favor digite o nome do estudante:")
    nome = input()
    print("Informe a 1ª nota do estudante: ")
    n1 = float(input())
    print("Informe a 2ª nota do estudante: ")
    n2 = float(input())
    print("Informe a 3ª nota do estudante: ")
    n3 = float(input())
    media = (n1 + n2 + n3) / 3
    print("Nome        Nota 1   Nota 2   Nota 3   Media")
    print(f"{nome:<12}{n1:<9.1f}{n2:<9.1f}{n3:<9.1f}{media:>5.1f}")

    print("Deseja calcular a media de outro estudante (S/N) ?")
    # escolha = input()
    # escolha_minusculo = escolha.lower()
    # if escolha_minusculo == 'n':
    #     executar = False
    #     # break
    # input()  "NAO"        "NAO".lower()  ==> "nao"
    escolha = input().lower()

    #  escolha = "nao"
    #   0   1   2
    # | n | a | o |
    # escolha[0]     ==> n
    # escolha[1]     ==> a

    if escolha[0] == 'n':
        executar = False

print("Fim do programa")