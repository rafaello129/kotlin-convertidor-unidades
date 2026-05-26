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
    println("Base temporal: Celsius a Fahrenheit")

    val celsius = leerCantidad()
    val fahrenheit = (celsius * 9 / 5) + 32

    println("Resultado: $celsius grados Celsius = $fahrenheit grados Fahrenheit")

    historial.add(
        RegistroConversion(
            categoria = "Temperatura",
            unidadOrigen = "Celsius",
            unidadDestino = "Fahrenheit",
            valorOriginal = celsius,
            resultado = fahrenheit
        )
    )
}

fun convertirLongitud() {
    println()
    println("Conversion de longitud")
    println("Base temporal: metros a kilometros")

    val metros = leerCantidad()
    val kilometros = metros / 1000

    println("Resultado: $metros metros = $kilometros kilometros")

    historial.add(
        RegistroConversion(
            categoria = "Longitud",
            unidadOrigen = "Metros",
            unidadDestino = "Kilometros",
            valorOriginal = metros,
            resultado = kilometros
        )
    )
}

fun convertirPeso() {
    println()
    println("Conversion de peso")
    println("Base temporal: kilogramos a gramos")

    val kilogramos = leerCantidad()
    val gramos = kilogramos * 1000

    println("Resultado: $kilogramos kilogramos = $gramos gramos")

    historial.add(
        RegistroConversion(
            categoria = "Peso",
            unidadOrigen = "Kilogramos",
            unidadDestino = "Gramos",
            valorOriginal = kilogramos,
            resultado = gramos
        )
    )
}

fun convertirTiempo() {
    println()
    println("Conversion de tiempo")
    println("Base temporal: horas a minutos")

    val horas = leerCantidad()
    val minutos = horas * 60

    println("Resultado: $horas horas = $minutos minutos")

    historial.add(
        RegistroConversion(
            categoria = "Tiempo",
            unidadOrigen = "Horas",
            unidadDestino = "Minutos",
            valorOriginal = horas,
            resultado = minutos
        )
    )
}

fun mostrarHistorial() {
    println()
    println("=== Historial de conversiones ===")

    if (historial.isEmpty()) {
        println("Todavia no hay conversiones registradas.")
        return
    }

    historial.forEachIndexed { indice, registro ->
        println(
            "${indice + 1}. ${registro.categoria}: " +
                "${registro.valorOriginal} ${registro.unidadOrigen} = " +
                "${registro.resultado} ${registro.unidadDestino}"
        )
    }
}
