plugins {
    id("java")
    alias(libs.plugins.shadow)
    application
}

group = "club.tesseract.minestom"
version = "1.0.0"

repositories {
    mavenCentral()

    // luckperms
    maven("https://repo.hypera.dev/snapshots/")
    maven("https://repo.tesseract.club/releases/")
}

dependencies {
    implementation(libs.minestom)
    implementation(libs.minestom.utils)

    implementation(libs.logback.classic)
    implementation(libs.jansi)

    implementation(libs.lombok)
    annotationProcessor(libs.lombok)

    /* Luckperms */
    implementation(libs.luckperms)
    implementation(libs.sponge.configurate.core)
    implementation(libs.sponge.configurate.hocon)
    implementation(libs.hikari)
    implementation(libs.h2database) // Replace with database provider of your choice
    /* End of Luckperms */
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks{

    shadowJar{
        archiveClassifier.set("")
        mergeServiceFiles()
    }

    compileJava{
        options.encoding = "UTF-8"
    }
}