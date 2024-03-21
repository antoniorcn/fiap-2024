print("Programa para calcular a area de um retangulo")
while True:
    print("Informe o tamanho da base em centimetros: ")
    base = float(input())
    # input() ==> "42"
    # float( "42" ) ==> 42.0
    print("Informe a altura do retângulo em centimetros: ")
    altura = float(input())
    area = base * altura
    print(f"O tamanho da área é: {area:5.1f} cm²")
    #print ("O tamanho da area é: ", area, " cm²")

    print("Você deseja calcular novamente (S/N): ")
    novamente = input()
    if novamente == 'N':
        break
print("Fim do programa")