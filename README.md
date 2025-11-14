# Minestom Template

This repository is a minimal template for building a Minestom-based Minecraft server plugin/project using Gradle.

## Overview

- Project layout: Java sources are under `src/main/java` and resources under `src/main/resources`.
- Build: Gradle (Kotlin DSL) with an included `build-logic` composite.

## Templating / Renaming this project

> Note: Renaming the Gradle project only changes the Gradle project identifier. If you want to fully customize package names, artifact IDs, or other identifiers, you should:

- Update Java package names under `src/main/java`.
- Update any references to the old project name in configuration or documentation.
- Update build metadata in `build.gradle.kts` if you want a different artifact name or group.

## Build & Run

Build the project using the wrapper included in the repository:

On Windows PowerShell:

```powershell
./gradlew.bat shadowjar
```

On Unix/macOS:

```bash
./gradlew shadowJar
```

The shaded/all jar (if configured) will be available in `build/libs/` after a successful build.

## Quick checklist for creating a new project from this template

1. Clone this repository.
2. Rename the Gradle project (see "Templating / Renaming this project" above).
3. Replace package names and update sources as needed.
4. Update `build.gradle.kts` metadata (group, version, artifact name) for your project.
5. Build and test.

## Support & Notes

If you run into build errors, run `./gradlew --stacktrace` and inspect the output. This template uses Gradle Kotlin DSL and includes a local `build-logic` composite; ensure you do not remove or break that directory.


