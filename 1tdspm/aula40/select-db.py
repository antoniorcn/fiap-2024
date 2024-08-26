import os
import oracledb
usuario = os.environ.get("PYTHON_ORACLE_USER")
senha = os.environ.get("PYTHON_ORACLE_PASS")
db_path="oracle.fiap.com.br:1521/orcl"
con = oracledb.connect(
    user=usuario, 
    password=senha, 
    dsn=db_path)

cursor = con.cursor()
sql = "SELECT * FROM times_futebol"
times = cursor.execute(sql)
for time in times:
    print(time)
