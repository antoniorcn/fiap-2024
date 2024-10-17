import os
import oracledb
from oracledb import Connection
from contato_model import Contato

class ContatoRepository:

    user : str = ""
    password : str = ""
    db_url : str = "oracle.fiap.com.br:1521/orcl"

    def __init__(self):
        self.user = os.environ.get("FIAP_ORACLE_USER")
        self.password = os.environ.get("FIAP_ORACLE_PASS")
        print("ContatoReposity gerado")

    def gerar_conexao(self) -> Connection:
        con = oracledb.connect(
            user=self.user,
            password=self.password,
            dsn=self.db_url)
        return con

    def ler_todos(self):
        con = self.gerar_conexao()
        cursor = con.cursor()
        cursor.execute("SELECT id, nome, telefone, email FROM contatos")
        resultado = []
        for registro in cursor:
            c1 = Contato(contato_id=registro[0],
                         nome=registro[1],
                         telefone=registro[2],
                         email=registro[3])
            resultado.append(c1)
        con.close()
        return resultado

    def salvar(self, contato : Contato):
        con = self.gerar_conexao()
        cursor = con.cursor()

        cursor.execute("""INSERT INTO contatos 
                       (nome, telefone, email) 
               VALUES (:1, :2, :3)""",
               (contato.nome, contato.telefone, contato.email))
        con.commit()
        con.close()