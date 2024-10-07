package edu.curso.agendacontatocompleta.model

import java.time.LocalDate
import java.util.Calendar
import java.util.Date

data class Contato(
    var id : String = "",
    var nome : String = "",
    var email : String = "",
    var telefone : String = "",
    var nascimento : Date = Calendar.getInstance().time
)