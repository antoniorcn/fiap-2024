aluno_nome = "João Silva"
aluno_n1 = 6.7
aluno_n2 = 5.2
aluno_n3 = 8.5
aluno_n4 = 9.2
aluno_mf = (aluno_n1 + aluno_n2 + 
            aluno_n3 + aluno_n4) / 4.0

print("Nome             Nota 1      Nota 2      Nota 3      Nota 4            Media")
print(f"{aluno_nome:<17}{aluno_n1:<12}{aluno_n2:<12}{aluno_n3:<12}{aluno_n4:<12}{aluno_mf:>11.1f}")