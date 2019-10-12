import org.asciidoctor.gradle.AsciidoctorTask

group = "com.reply.comsysto"
version = "1.0-SNAPSHOT"

val docs: Configuration by configurations.creating

plugins {
    id("org.asciidoctor.convert") version "1.5.9.2"
}

repositories {
    maven {
        url = uri("https://repo.spring.io/libs-release-local")
    }
}

dependencies {
    docs("io.spring.docresources:spring-doc-resources:0.1.3.RELEASE@zip")
}

tasks {
    register<Sync>("prepareAsciidocBuild") {
        dependsOn(configurations["docs"])

        // Set working directory
        into("$buildDir")

        into("asciidoc/build") {
            // Copy spring-doc-resources...
            from(configurations["docs"].map(::zipTree)) {
                // Ignore supplied highlight.js since we have our own
                exclude("**/highlight/**")
            }
            // ...and our source files
            from("src/main/asciidoc/")
        }

        into("asciidoc/build") {
            // Overwrite spring-doc-resources with our custom files
            from("src/resources/")
        }
    }

    named<AsciidoctorTask>("asciidoctor") {
        dependsOn("prepareAsciidocBuild")

        sourceDir = file("$buildDir/asciidoc/build")
        sources(delegateClosureOf<PatternSet> {
            include("*.adoc")
            exclude("attributes.adoc")
        })
        resources(delegateClosureOf<CopySpec> {
            from(sourceDir) {
                include("images/**", "css/**", "js/**")
            }
        })
        logDocuments = true
        options = mapOf("doctype" to "book", "eruby" to "erubis")
        attributes = mapOf(
                "docinfo" to "shared",
                "stylesdir" to "css/",
                "stylesheet" to "spring.css",
                "linkcss" to true,
                "icons" to "font",
                "source-highlighter" to "highlight.js",
                "highlightjsdir" to "js/highlight",
                "highlightjs-theme" to "github"
        )
    }
}
