package edu.curso.columnselazycolumns

interface Destino {
    val rota : String
}

val destinoFormulario = object : Destino { override val rota = "FORMULARIO"}
val destinoConfiguracoes = object : Destino { override val rota = "CONFIGURACOES"}