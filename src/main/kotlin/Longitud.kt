fun convertirLongitud(historial: MutableList<RegistroConversion>) {
    println()
    println("Conversion de longitud")

    val factoresLongitud = mapOf(
        "Metros" to 1.0,
        "Kilometros" to 1000.0,
        "Centimetros" to 0.01,
        "Millas" to 1609.34
    )

    println("Unidades disponibles:")
    factoresLongitud.keys.forEach { unidad ->
        println("- $unidad")
    }

    val unidadOrigen = leerUnidadLongitud(factoresLongitud, "Escribe la unidad de origen: ")
    val unidadDestino = leerUnidadLongitud(factoresLongitud, "Escribe la unidad de destino: ")
    val valorOriginal = leerCantidad()

    val factorOrigen = factoresLongitud[unidadOrigen] ?: 1.0
    val factorDestino = factoresLongitud[unidadDestino] ?: 1.0
    val valorEnMetros = valorOriginal * factorOrigen
    val resultado = valorEnMetros / factorDestino

    println("Resultado: $valorOriginal $unidadOrigen = $resultado $unidadDestino")

    historial.add(
        RegistroConversion(
            categoria = "Longitud",
            unidadOrigen = unidadOrigen,
            unidadDestino = unidadDestino,
            valorOriginal = valorOriginal,
            resultado = resultado
        )
    )
}

fun leerUnidadLongitud(factoresLongitud: Map<String, Double>, mensaje: String): String {
    while (true) {
        print(mensaje)
        val entrada = readlnOrNull()?.trim()
        val unidad = factoresLongitud.keys.firstOrNull { it.equals(entrada, ignoreCase = true) }

        if (unidad != null) {
            return unidad
        }

        println("Unidad no valida. Escribe una unidad de la lista.")
    }
}
