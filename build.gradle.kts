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
    maven("https://repo.lucko.me/")
    maven("https://repo.hypera.dev/snapshots/")
}

dependencies {
    implementation(libs.minestom)

    implementation(libs.logback.classic)
    implementation(libs.jansi)

    implementation(libs.lombok)
    annotationProcessor(libs.lombok)

    implementation(libs.luckperms)
    implementation(libs.sponge.configurate.core)
    implementation(libs.sponge.configurate.hocon)
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