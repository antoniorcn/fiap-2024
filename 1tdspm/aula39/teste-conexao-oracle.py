import os
import oracledb

usuario = os.environ.get("FIAP_ORACLE_USER")
senha = os.environ.get("FIAP_ORACLE_PASS")

con = oracledb.connect(user=usuario, 
                       password=senha, 
                       dsn="oracle.fiap.com.br:1521/orcl")
print("Database version:", con.version)


while True:
    os.system("CLS")
    cursor = con.cursor()
    print("Menu de opções para acesso ao banco de dados")
    print("(T)Criar Tabela Contatos")
    print("(X)Drop Tabela Contatos")
    print("(I)nserir um novo contato na tabela")
    print("(L)istar os contatos da tabela")
    print("(S)air")
    opcao = input("Por favor digite uma opção: ").upper()[0]

    if opcao == 'T':
        cursor.execute("""
            CREATE TABLE Contatos (
                id NUMBER(9) not null,
                nome VARCHAR2(100),
                telefone VARCHAR2(30),
                email VARCHAR2(100),
                CONSTRAINT Contato_pk PRIMARY KEY (id)
            )
        """)
    elif opcao == 'X':
        cursor.execute("""
            ALTER TABLE Contatos DROP CONSTRAINT Contato_pk
        """)
        cursor.execute("""
            DROP TABLE Contatos
        """)
    elif opcao == 'I':
        print("Informe o id do Contato: ")
        id = int(input())
        print("Informe o nome do Contato: ")
        nome = input()
        print("Informe o telefone do Contato: ")
        telefone = input()
        print("Informe o email do Contato: ")
        email = input()
        sql = f"""
                    INSERT INTO Contatos (id, nome, telefone, email) 
                    VALUES (:1, :2, :3, :4)
                """
        print("SQL: ", sql)
        cursor.execute(sql, (id, nome, telefone, email) )
        con.commit()
    elif opcao == 'L':
        print("Listando Contatos:")

        lista = cursor.execute("SELECT * FROM Contatos")
        for row in lista:
            print(row)

    elif opcao == 'S':
        print("Tchau até breve...")
        break
    else:
        print("Opção invalida")

    input("Tecle <ENTER> para continuar")