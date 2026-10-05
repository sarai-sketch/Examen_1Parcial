#!/usr/bin/env bash
# Scripts usados en el examen: inicializa el repositorio y crea los commits por checkpoint.
# Uso (desde la raíz del proyecto):  bash scripts/git_commits.sh
set -e

git init
git branch -M main

# Checkpoint 1 – Diseño de clases (Primer commit)
git add README.md docs/01_diseno_clases.md .gitignore
git commit -m "Checkpoint 1: diseño de clases de la Farmacia (diagrama, atributos, métodos y relaciones)"

# Checkpoint 2 – Implementación (Segundo commit)
git add app/src/main/java/com/upb/farmacia/model app/src/main/java/com/upb/farmacia/data app/src/test
git commit -m "Checkpoint 2: implementación en Kotlin de las clases del modelo (POO) y pruebas unitarias"

# Checkpoint 3 – Scripts (Tercer commit)
git add scripts
git commit -m "Checkpoint 3: scripts usados en el examen"

# Checkpoints 4 y 5 – Diseño e implementación de la interfaz
git add docs/02_diseno_pantallas.md
git commit -m "Checkpoint 4: diseño de interfaces y componentes de Jetpack Compose"
git add .
git commit -m "Checkpoint 5 y 6: pantallas con Jetpack Compose, navegación y proyecto Gradle"

# Subir a GitHub (reemplaza TU_USUARIO; el repo debe ser público y compartido con el docente)
# git remote add origin https://github.com/TU_USUARIO/farmacia-kotlin.git
# git push -u origin main
