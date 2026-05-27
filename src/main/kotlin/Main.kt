val historial = mutableListOf<RegistroConversion>()

fun main() {
    var continuar = true

    while (continuar) {
        mostrarMenuPrincipal()

        when (leerOpcion()) {
            1 -> convertirTemperatura(historial)
            2 -> convertirLongitud(historial)
            3 -> convertirPeso(historial)
            4 -> convertirTiempo(historial)
            5 -> mostrarHistorial(historial)
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
