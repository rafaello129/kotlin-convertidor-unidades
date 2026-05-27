# kotlin-convertidor-unidades

Aplicación de consola hecha en Kotlin para convertir unidades de temperatura, longitud, peso y tiempo. También guarda un historial simple de las conversiones realizadas durante la ejecución del programa.

## Instrucciones de instalación y ejecución

Para descargar y ejecutar el proyecto:

```bash
git clone URL_DEL_REPOSITORIO
cd kotlin-convertidor-unidades
./gradlew run
```

En Windows también se puede ejecutar con:

```bash
gradlew.bat run
```

Si ya tienes el proyecto descargado, solo entra a la carpeta del proyecto y ejecuta el comando correspondiente.

## Funcionalidades principales

- Conversión de temperatura entre Celsius, Fahrenheit y Kelvin.
- Conversión de longitud entre metros, kilómetros, centímetros y millas.
- Conversión de peso entre kilogramos, gramos y libras.
- Conversión de tiempo entre segundos, minutos y horas.
- Historial de conversiones realizadas durante la ejecución.
- Validación de entradas para evitar que el programa se cierre por datos incorrectos.

## Conceptos de Kotlin aplicados

| Concepto | Dónde se usa | Explicación breve |
|---|---|---|
| Funciones | `mostrarMenuPrincipal`, `convertirTemperatura`, `convertirLongitud`, `convertirPeso`, `convertirTiempo`, entre otras | Permiten separar la lógica para que el `main` no tenga todo el código junto. |
| `when` | En el menú principal y en las conversiones de temperatura | Sirve para elegir qué acción ejecutar según la opción ingresada. |
| `while` | En el menú principal y en la lectura de datos válidos | Mantiene activo el programa y permite repetir preguntas cuando hay entradas incorrectas. |
| `List` o `MutableList` | `historial = mutableListOf<RegistroConversion>()` | Guarda las conversiones realizadas mientras el programa está abierto. |
| `Map` | Factores de longitud, peso y tiempo | Relaciona cada unidad con su factor de conversión base. |
| `forEach` o `forEachIndexed` | Al mostrar unidades disponibles y al imprimir el historial | Recorren colecciones de forma clara y ordenada. |
| Null safety | `readlnOrNull()?.toIntOrNull()`, `readlnOrNull()?.trim()` y operador `?:` | Evita errores cuando el usuario no escribe un valor válido. |
| `data class` | `RegistroConversion` | Representa cada conversión con sus datos principales de forma sencilla. |

## Reflexión de proceso

Lo más difícil del proyecto fue lograr que las entradas incorrectas no cerraran el programa. Al principio era fácil pensar solo en el caso ideal, por ejemplo que el usuario siempre iba a escribir una opción correcta, pero al probarlo aparecieron errores. Se resolvió usando ciclos `while`, `readlnOrNull()` y validaciones antes de hacer las conversiones.

El concepto que se entendió mejor durante el proyecto fue el uso de funciones y colecciones. Separar el código en funciones hizo que cada parte fuera más fácil de revisar, y usar `Map` ayudó a evitar muchas fórmulas repetidas en longitud, peso y tiempo.

En el futuro se podría mejorar el programa agregando más unidades, redondeo de resultados, opción para borrar el historial o guardar las conversiones en un archivo. También se podría mejorar la forma en que el usuario selecciona unidades para que no tenga que escribir el nombre completo.

Haciendo el proyecto se aprendió que programar no es solo escribir la fórmula correcta. También hay que pensar en cómo va a usarlo otra persona, qué pasa si se equivoca al escribir y cómo organizar el código para que otros compañeros puedan entenderlo y modificarlo después.

## Pruebas manuales

Se realizaron pruebas desde la consola para revisar conversiones, validaciones e historial:

- `100 Celsius` a `Fahrenheit`: resultado esperado `212.0 Fahrenheit`.
- `5 Kilometros` a `Metros`: resultado esperado `5000.0 Metros`.
- `10 Libras` a `Kilogramos`: resultado aproximado `4.53592 Kilogramos`.
- `2 Horas` a `Minutos`: resultado esperado `120.0 Minutos`.
- Se probó escribir unidades inválidas para confirmar que el programa vuelve a pedir el dato.
- Se revisó el historial después de hacer conversiones para confirmar que se muestran numeradas.
