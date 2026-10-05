# Farmacia Vida – Examen Kotlin / Jetpack Compose

Caso de estudio: **Farmacia**. Proyecto Android (Kotlin + Jetpack Compose + Material 3).

| Checkpoint | Entregable | Ubicación |
|---|---|---|
| 1 Diseño de clases | Diagrama, atributos, métodos, relaciones | [`docs/01_diseno_clases.md`](docs/01_diseno_clases.md) |
| 2 Implementación | Clases POO en Kotlin | `app/src/main/java/com/upb/farmacia/model` |
| 3 Scripts | Comandos Git usados | [`scripts/git_commits.sh`](scripts/git_commits.sh) |
| 4 Diseño de interfaz | Wireframes y componentes Compose | [`docs/02_diseno_pantallas.md`](docs/02_diseno_pantallas.md) |
| 5 Interfaz | 2 pantallas: Medicamentos y Clientes | `app/src/main/java/com/upb/farmacia/ui` |
| 6 Compilación | Build + emulador | Ver abajo |

## Cómo compilar y ejecutar
1. Abrir la carpeta en **Android Studio** (Ladybug 2024.2 o superior) y esperar el *Gradle Sync*.
2. Elegir un emulador (API 26+) o un teléfono con depuración USB.
3. Pulsar **Run ▶** (o `./gradlew assembleDebug`).
4. Pruebas unitarias: `./gradlew test` o clic derecho en `VentaTest` → Run.

## Estructura
```
app/src/main/java/com/upb/farmacia/
├── model/   Persona, Cliente, Empleado, Producto, Medicamento, ProductoCuidadoPersonal,
│            Proveedor, Venta, DetalleVenta, Inventariable, Cargo, CategoriaMedicamento
├── data/    FarmaciaRepository (datos de ejemplo en memoria)
├── ui/      FarmaciaApp (navegación), screens/ (MedicamentosScreen, ClientesScreen), theme/
└── MainActivity.kt
```
# Prompts utilizados
Prompt inicial para estructurar el proyecto:

"Ayúdame a diseñar una aplicación Android en Jetpack Compose para una farmacia (Checkpoint 1: Diseño de clases), identificando los atributos, métodos, relaciones y la estructura de carpetas necesaria para cumplir con los requerimientos del examen."

Prompt para el diseño de la interfaz y componentes visuales:

"Genera el código base para la pantalla de búsqueda y catálogo de la farmacia en Jetpack Compose, utilizando Material 3, tarjetas de medicamentos (LazyColumn), y un diseño limpio para el inventario."

2. Prompts de Configuración Técnica y Código
Prompt para corregir o configurar el archivo de temas (Type.kt):

"Proporcione el código para el archivo Type.kt configurando la tipografía de Material 3 con FontFamily.Default y estilos limpios para títulos y cuerpos de texto en la aplicación de farmacia."

Prompt para resolver la estructura de la aplicación:

"¿Cómo configuro el punto de entrada principal (MainActivity.kt y el AndroidManifest.xml) para que Android Studio reconozca la aplicación y active el botón de ejecución (Play)?"

3. Prompts para Control de Versiones y GitHub
Prompt para subir el proyecto al repositorio:

"¿Cuáles son los comandos de Git que debo usar en la terminal de Android Studio para inicializar el repositorio, hacer el primer commit y subir todo el proyecto de la farmacia a mi repositorio público en GitHub (sarai-sketch/Examen_1Parcial)?"

Prompt para solucionar errores de ramas en Git:

"Me sale un error en la terminal que dice error: src refspec main does not match any. ¿Cómo lo soluciono para poder hacer el push correctamente?"
