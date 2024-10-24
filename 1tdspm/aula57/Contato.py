class Contato:
    contato_id : int
    nome : str
    telefone : str
    email : str

    def __init__(self, contato_id : int = 0, nome : str = "",
                 telefone : str = "", email : str = ""):
        self.contato_id = contato_id
        self.nome = nome
        self.email = email
        self.telefone = telefone

    def __str__(self):
        return f"ID: {self.contato_id}\tNome: {self.nome}\nTelefone: {self.telefone}\nEmail: {self.email}"
    
    def from_dict(self, dicionario):
        # {"nome": "Maria", "email": "maria@teste.com", "telefone": "(11)2222-2222"}
        self.contato_id = dicionario.get("id", "")
        self.nome = dicionario.get("nome", "")
        self.email = dicionario.get("email", "")
        self.telefone = dicionario.get("telefone", "")

    def to_dict(self) -> dict:
        dicionario = {}
        dicionario["id"] = self.contato_id
        dicionario["nome"] = self.nome
        dicionario["telefone"] = self.telefone
        dicionario["email"] = self.email
        return dicionario


if __name__ == "__main__":
    c1 = Contato(nome="Joao Silva",
            email="joao@teste.com",
            telefone="(11)1111-1111")
    
    c2 = Contato()
    c2.from_dict( {"id": 0, "nome": "Maria Silva", "telefone": "(11) 2222-2222", "email": "maria@teste.com"} )
    print(f"Contato: {c2.to_dict()}")

