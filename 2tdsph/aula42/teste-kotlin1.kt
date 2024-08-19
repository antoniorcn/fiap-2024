fun imprime(a: String?) {
  var b = a ?: "<texto não informado>"
  println(b)
}

fun main() {
  imprime("Teste")
  imprime(null)
  imprime("Depois do nulo")
  imprime("Texto com espacos trocados".trocarEspacos())
}

fun String.trocarEspacos(): String {
  return this.replace(" ", "-")
}
