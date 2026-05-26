# kotlin-convertidor-unidades

Proyecto de consola en Kotlin para convertir unidades de forma sencilla.

## Objetivo

Crear la base de una aplicacion de consola que permita trabajar con distintas categorias de conversion:

1. Temperatura
2. Longitud
3. Peso
4. Tiempo
5. Ver historial
6. Salir

## Estado actual

Esta version inicial deja preparada la estructura principal del proyecto:

- Menu principal activo con `while`.
- Manejo de opciones con `when`.
- Funciones separadas para cada categoria.
- Lectura segura de datos usando null safety.
- Historial de conversiones usando una lista mutable.
- `data class` para representar cada conversion realizada.

Las conversiones incluidas son basicas y temporales para que despues el equipo pueda ampliar cada categoria.

## Como ejecutar

Desde la carpeta del proyecto:

```bash
./gradlew run
```

En Windows tambien se puede ejecutar:

```bash
gradlew.bat run
```

## Estructura

```text
kotlin-convertidor-unidades/
├── settings.gradle.kts
├── build.gradle.kts
├── src/main/kotlin/Main.kt
├── README.md
└── .gitignore
```

## Pendientes sugeridos

- Completar conversiones de temperatura.
- Completar conversiones de longitud.
- Completar conversiones de peso.
- Completar conversiones de tiempo.
- Mejorar la presentacion del historial.
