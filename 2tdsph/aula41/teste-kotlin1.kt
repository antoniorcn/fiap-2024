fun imprimeValor(valor: Any) {
  if (valor is Int) {
    val variavel2 = valor as Int
    var valorInteiro = valor.toInt()
    print("Valor: $valorInteiro")
  }
}

fun imprimeMaisculo(texto: String?) {
  if (texto != null) {
    println(texto.uppercase())
  }
}

fun iguais(valor1: Any, valor2: Any) {
  if (valor1 == valor2) {
    println("São iguais")
  } else {
    println("São diferentes")
  }
}

fun main() {
  iguais("A", "B")
  imprimeMaisculo(null)
  var a = 10
  var strA = a.toString()

  var strX = "A"
  var x = strX.toIntOrNull()

  println("Valor de a: $a")
  println("Valor de X: $x")

  imprimeValor(10)
}
