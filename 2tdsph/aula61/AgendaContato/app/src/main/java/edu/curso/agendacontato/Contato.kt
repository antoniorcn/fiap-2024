package edu.curso.agendacontato

import java.time.LocalDate

data class Contato(
    var id : String = "",
    var nome : String = "",
    var email : String = "",
    var telefone : String = "",
    var nascimento : String = ""
)
