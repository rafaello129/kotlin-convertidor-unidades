fun convertirPeso(historial: MutableList<RegistroConversion>) {
    println()
    println("Conversion de peso")

    val factoresPeso = mapOf(
        "Kilogramos" to 1.0,
        "Gramos" to 0.001,
        "Libras" to 0.453592
    )

    println("Unidades disponibles:")
    factoresPeso.keys.forEach { unidad ->
        println("- $unidad")
    }

    val unidadOrigen = leerUnidadPeso(factoresPeso, "Escribe la unidad de origen: ")
    val unidadDestino = leerUnidadPeso(factoresPeso, "Escribe la unidad de destino: ")
    val valorOriginal = leerCantidad()

    val factorOrigen = factoresPeso[unidadOrigen] ?: 1.0
    val factorDestino = factoresPeso[unidadDestino] ?: 1.0
    val valorEnKilogramos = valorOriginal * factorOrigen
    val resultado = valorEnKilogramos / factorDestino

    println("Resultado: $valorOriginal $unidadOrigen = $resultado $unidadDestino")

    historial.add(
        RegistroConversion(
            categoria = "Peso",
            unidadOrigen = unidadOrigen,
            unidadDestino = unidadDestino,
            valorOriginal = valorOriginal,
            resultado = resultado
        )
    )
}

fun leerUnidadPeso(factoresPeso: Map<String, Double>, mensaje: String): String {
    while (true) {
        print(mensaje)

        readlnOrNull()?.trim()?.let { entrada ->
            val unidad = factoresPeso.keys.firstOrNull { it.equals(entrada, ignoreCase = true) }

            if (unidad != null) {
                return unidad
            }
        } ?: println("Entrada vacia. Escribe una unidad de la lista.")

        println("Unidad no valida. Escribe una unidad de la lista.")
    }
}
