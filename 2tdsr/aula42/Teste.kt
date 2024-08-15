/*

// Codigo em Java

public class Cliente {
  private String nome = "";
  private String telefone = "";
  private String email = "";

  public void setNome(String value) {
    this.nome = value;
  }

  public String getNome() {
    return this.nome;
  }

  @Override
  public String toString() {
    return this.nome + ", " + this.telefone + ", " + this.email
  }
}
*/

data class Cliente(var nome: String = "", var telefone: String = "", var email: String = "")

fun imprimir(elemento: Any?) {
  if (elemento != null) {
    if (elemento is String) {
      println(elemento.lowercase())
      println(elemento.uppercase())
    }
  }
}

fun testaIguais(valor1: Any?, valor2: Any?) {
  if (valor1 != null) {
    if (valor1 === valor2) {
      println("São Iguais")
    } else {
      println("São Diferentes")
    }
  }
}

class Telefone {
  var ddd: String = ""
  var numero: String = ""
}

fun imprimirContato(nome: String = "Anonimo", telefone: String = "Sem telefone de contato") {
  println("Nome: $nome")
  println("Telefone: $telefone")
}

fun main() {

  imprimirContato(telefone = "(11) 1111-1111")

  // var a = "20"
  // // var b: Int = Integer.parseInt(a)
  // var b = a.toInt()
  // print("Valor de B + 1  =  ${b + 1}")

  // var a = "A"
  // var b = a
  // b = b + ""
  // println("A: (${a.hashCode()})")
  // println("B: (${b.hashCode()})")
  // testaIguais("A", "A")

  // var x = 100
  // val t1 = Telefone()
  // t1.ddd = "11"
  // t1.numero = "2222-2222"
  // println("Telefone: (${t1.ddd}) ${t1.numero}")

  // var j : Any
  // j = "10"
  // j = 5
  // j = Cliente()

  // String a = null
  // a.equals("")
  // NullPointerException

  // val lista = ArrayList<String?>()
  // lista.add("texto 1")
  // lista.add(null)

  // imprimeTexto("Teste de Kotlin")

  // var a = "abc123"

  // val c1 = Cliente()
  // val c2 = Cliente("Joao Silva", "(11) 1111-1111")

  // c1.nome = "Maria Silva"
  // c1.telefone = "(11) 2222-2222"

  // println("Cliente 1: " + c1)
  // println("Cliente 2: " + c2)
}
