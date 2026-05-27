fun convertirTemperatura(historial: MutableList<RegistroConversion>) {
    println()
    println("Conversion de temperatura")

    mostrarMenuUnidadesTemperatura()
    val unidadOrigen = leerUnidadTemperatura("Selecciona la unidad de origen: ")
    val unidadDestino = leerUnidadTemperatura("Selecciona la unidad de destino: ")
    val valorOriginal = leerCantidad()

    val resultado = when (unidadOrigen to unidadDestino) {
        "Celsius" to "Fahrenheit" -> (valorOriginal * 9 / 5) + 32
        "Fahrenheit" to "Celsius" -> (valorOriginal - 32) * 5 / 9
        "Celsius" to "Kelvin" -> valorOriginal + 273.15
        "Kelvin" to "Celsius" -> valorOriginal - 273.15
        "Fahrenheit" to "Kelvin" -> (valorOriginal - 32) * 5 / 9 + 273.15
        "Kelvin" to "Fahrenheit" -> (valorOriginal - 273.15) * 9 / 5 + 32
        else -> valorOriginal
    }

    println("Resultado: $valorOriginal $unidadOrigen = $resultado $unidadDestino")

    historial.add(
        RegistroConversion(
            categoria = "Temperatura",
            unidadOrigen = unidadOrigen,
            unidadDestino = unidadDestino,
            valorOriginal = valorOriginal,
            resultado = resultado
        )
    )
}

fun mostrarMenuUnidadesTemperatura() {
    println("Unidades disponibles:")
    println("1. Celsius")
    println("2. Fahrenheit")
    println("3. Kelvin")
}

fun leerUnidadTemperatura(mensaje: String): String {
    while (true) {
        print(mensaje)

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> return "Celsius"
            2 -> return "Fahrenheit"
            3 -> return "Kelvin"
            else -> println("Unidad no valida. Elige 1, 2 o 3.")
        }
    }
}
