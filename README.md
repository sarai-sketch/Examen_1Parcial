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
