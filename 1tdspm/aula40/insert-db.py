import os
import oracledb
usuario = os.environ.get("PYTHON_ORACLE_USER")
senha = os.environ.get("PYTHON_ORACLE_PASS")
db_path="oracle.fiap.com.br:1521/orcl"
con = oracledb.connect(
    user=usuario, 
    password=senha, 
    dsn=db_path)

# sql = """
#     INSERT INTO times_futebol (id, nome, jogadores, 
#     vitorias, derrotas, empates, animo) 
#     VALUES (1, 'Corinthians', 26, 2, 8, 2, 10)
# """

sql = """
    INSERT INTO times_futebol (id, nome, jogadores, 
    vitorias, derrotas, empates, animo) 
    VALUES (2, 'São Paulo', 26, 4, 6, 2, 30)
"""

cursor = con.cursor()
cursor.execute(sql)
con.commit()
print("Registro inserido com sucesso")