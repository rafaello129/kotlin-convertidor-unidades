data class RegistroConversion(
    val categoria: String,
    val unidadOrigen: String,
    val unidadDestino: String,
    val valorOriginal: Double,
    val resultado: Double
)

val historial = mutableListOf<RegistroConversion>()

fun main() {
    var continuar = true

    while (continuar) {
        mostrarMenuPrincipal()

        when (leerOpcion()) {
            1 -> convertirTemperatura()
            2 -> convertirLongitud()
            3 -> convertirPeso()
            4 -> convertirTiempo()
            5 -> mostrarHistorial()
            6 -> {
                println("Gracias por usar el convertidor de unidades.")
                continuar = false
            }
            else -> println("Opcion no valida. Intenta nuevamente.")
        }
    }
}

fun mostrarMenuPrincipal() {
    println()
    println("=== Convertidor de Unidades ===")
    println("1. Temperatura")
    println("2. Longitud")
    println("3. Peso")
    println("4. Tiempo")
    println("5. Ver historial")
    println("6. Salir")
    print("Selecciona una opcion: ")
}

fun leerOpcion(): Int {
    return readlnOrNull()?.toIntOrNull() ?: 0
}

fun leerCantidad(): Double {
    while (true) {
        print("Ingresa la cantidad a convertir: ")
        val cantidad = readlnOrNull()?.toDoubleOrNull()

        if (cantidad != null) {
            return cantidad
        }

        println("Cantidad no valida. Escribe un numero.")
    }
}

fun convertirTemperatura() {
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

fun convertirLongitud() {
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

fun convertirPeso() {
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

fun convertirTiempo() {
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

fun mostrarHistorial() {
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
