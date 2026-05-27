fun convertirTiempo(historial: MutableList<RegistroConversion>) {
    println()
    println("Conversion de tiempo")

    val factoresTiempo = mapOf(
        "Segundos" to 1.0,
        "Minutos" to 60.0,
        "Horas" to 3600.0
    )

    println("Unidades disponibles:")
    factoresTiempo.keys.forEach { unidad ->
        println("- $unidad")
    }

    val unidadOrigen = leerUnidadTiempo(factoresTiempo, "Escribe la unidad de origen: ")
    val unidadDestino = leerUnidadTiempo(factoresTiempo, "Escribe la unidad de destino: ")
    val valorOriginal = leerCantidad()

    val factorOrigen = factoresTiempo[unidadOrigen] ?: 1.0
    val factorDestino = factoresTiempo[unidadDestino] ?: 1.0
    val valorEnSegundos = valorOriginal * factorOrigen
    val resultado = valorEnSegundos / factorDestino

    println("Resultado: $valorOriginal $unidadOrigen = $resultado $unidadDestino")

    historial.add(
        RegistroConversion(
            categoria = "Tiempo",
            unidadOrigen = unidadOrigen,
            unidadDestino = unidadDestino,
            valorOriginal = valorOriginal,
            resultado = resultado
        )
    )
}

fun leerUnidadTiempo(factoresTiempo: Map<String, Double>, mensaje: String): String {
    while (true) {
        print(mensaje)
        val entrada = readlnOrNull()?.trim()
        val unidad = factoresTiempo.keys.firstOrNull { it.equals(entrada, ignoreCase = true) }

        if (unidad != null) {
            return unidad
        }

        println("Unidad no valida. Escribe una unidad de la lista.")
    }
}
