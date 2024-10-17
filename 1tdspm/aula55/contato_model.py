class Contato:
    contato_id : int
    nome : str
    telefone : str
    email : str

    def __init__(self, contato_id = 0, nome = "",
                 email = "", telefone = "" ):
        self.contato_id = contato_id
        self.nome = nome
        self.email = email
        self.telefone = telefone

    def __str__(self) -> str:
        return f"""Contato({self.contato_id} - 
        {self.nome} - {self.telefone} - {self.email})"""