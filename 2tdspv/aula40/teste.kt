import kotlin.text.uppercase

fun compararTextos(a: String = "", b: String = "") {

  if (a == b) {
    println("São iguais")
  } else {
    println("São diferentes")
  }
}

fun imprimir(texto: String?) {
  if (texto != null) {
    println(texto.uppercase())
  }
}

fun teste() {
  var x = 10L
  x += 2
  var y = 8.9f

  val a = "20"
  val b = y.toInt()

  imprimir(null)

  print("Valor de X: ${x + y} ")

  if (y > 10 && y < 50) {
    print("Maior que 10")
  } else if (y < 20) {
    print("Maior que 20")
  } else {
    print("Não é maior que 10")
  }
}

fun mostrarContato(nome: String? = "Anonimo", telefone: String = "Sem telefone") {
  println("Nome: $nome")
  println("Telefone: $telefone")
}

fun main() {
  mostrarContato(null, "(11) 1111-1111")
}
