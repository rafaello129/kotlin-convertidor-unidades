data class RegistroConversion(
    val categoria: String,
    val unidadOrigen: String,
    val unidadDestino: String,
    val valorOriginal: Double,
    val resultado: Double
)

fun mostrarHistorial(historial: List<RegistroConversion>) {
    println()
    println("=== Historial de conversiones ===")

    if (historial.isEmpty()) {
        println("Todavía no hay conversiones registradas.")
        return
    }

    historial.forEachIndexed { indice, registro ->
        println("${indice + 1}. Categoria: ${registro.categoria}")
        println("   Valor original: ${registro.valorOriginal} ${registro.unidadOrigen}")
        println("   Resultado: ${registro.resultado} ${registro.unidadDestino}")
    }
}
