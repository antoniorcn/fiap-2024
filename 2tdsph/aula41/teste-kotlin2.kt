data class Cliente(var nome: String = "Anonimo", var telefone: String = "Não informado") {
  operator fun plus(outro: Cliente): Cliente {
    val novo =
        Cliente(
            nome = this.nome + " e " + outro.nome,
            telefone = this.telefone + " / " + outro.telefone
        )
    return novo
  }
}

fun Cliente.imprimir() {
  println("Nome: ${this.nome}")
  println("Telefone: ${this.telefone}")
}

fun main() {
  val c1 = Cliente("Joao", "(11) 1111-1111")
  val c2 = c1
  val c3 = Cliente("Maria", "(11) 2222-2222")
  val c4 = Cliente(telefone = "22222")

  val c5 = c1 + c3

  println("C1")
  c1.imprimir()
  println("C2")
  c2.imprimir()
  println("C3")
  c3.imprimir()
  println("C4")
  c4.imprimir()
  println("C5")
  c5.imprimir()

  if (c1 === c2) {
    println("C1 e igual a C2")
  } else {
    println("C1 e C2 são diferentes")
  }

  if (c1 === c3) {
    println("C1 e igual a C3")
  } else {
    println("C1 e C3 são diferentes")
  }
}
