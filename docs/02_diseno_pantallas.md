# Checkpoint 4 – Diseño de interfaz (Jetpack Compose)

Navegación: `Scaffold` con `TopAppBar` + `NavigationBar` inferior y `NavHost` con 2 destinos.

## Pantalla 1 – Medicamentos (lista del objeto `Medicamento`)

```
┌──────────────────────────────────────┐
│ Farmacia Vida · Medicamentos         │  ← TopAppBar
├──────────────────────────────────────┤
│ [🔍 Buscar medicamento           ]   │  ← OutlinedTextField
│ (Todos) ( Con receta )               │  ← FilterChip x2
│ 8 resultado(s)                       │  ← Text
│ ┌──────────────────────────────────┐ │
│ │ (♥)  Paracetamol          Bs 6.50│ │  ← Card en LazyColumn
│ │      Paracetamol 500 mg          │ │
│ │      Droguería Illimani S.R.L.   │ │
│ │      [Analgésico]                │ │  ← AssistChip
│ │      Stock: 120                  │ │
│ │      Vence: 08/2027              │ │
│ └──────────────────────────────────┘ │
│ ┌──────────────────────────────────┐ │
│ │ (♥)  Amoxicilina         Bs 28.00│ │
│ │      [Antibiótico] [Receta]      │ │
│ └──────────────────────────────────┘ │
├──────────────────────────────────────┤
│   ♥ Medicamentos  │   👤 Clientes    │  ← NavigationBar
└──────────────────────────────────────┘
```

| Componente Compose | Uso |
|---|---|
| `Scaffold` | Estructura general (barra superior, inferior, contenido) |
| `TopAppBar` | Título dinámico según la pantalla |
| `NavigationBar` / `NavigationBarItem` | Cambiar entre pantallas |
| `NavHost` + `composable()` + `rememberNavController()` | Navegación |
| `Column`, `Row`, `Box`, `Spacer` | Disposición |
| `OutlinedTextField` | Búsqueda por nombre / principio activo |
| `FilterChip` | Filtro Todos / Con receta |
| `LazyColumn` + `items(key=)` | Lista eficiente |
| `Card` + `CardDefaults.cardElevation` | Tarjeta de cada medicamento |
| `AssistChip` | Categoría y etiqueta "Receta" |
| `Icon`, `Text` | Iconografía y textos (rojo si stock bajo o vence pronto) |
| `remember` + `mutableStateOf` | Estado de búsqueda y filtro |
| `@Preview` | Vista previa en Android Studio |

## Pantalla 2 – Clientes (lista del objeto `Cliente`)

```
┌──────────────────────────────────────┐
│ Farmacia Vida · Clientes             │
├──────────────────────────────────────┤
│ Clientes registrados: 5              │
│ ┌──────────────────────────────────┐ │
│ │ (MQ) María Quispe Mamani    ★    │ │
│ │      CI: 6543210          120 pts│ │
│ │      NIT: 6543210018             │ │
│ │      Tel: 71234567               │ │
│ └──────────────────────────────────┘ │
├──────────────────────────────────────┤
│   ♥ Medicamentos  │   👤 Clientes    │
└──────────────────────────────────────┘
```

| Componente Compose | Uso |
|---|---|
| `LazyColumn` + `Card` | Lista de clientes |
| `Box` + `CircleShape` + `Text` | Avatar con iniciales |
| `Row` / `Column` | Datos a la izquierda, puntos a la derecha |
| `Icon(Icons.Default.Star)` | Indicador de puntos de fidelidad |
