plugins {
    id("groovy")
}

group = "ru.pr1nkos"
version = "1.0-SNAPSHOT"

//versions
val groovyVersion = "4.0.14"
val lombokVersion = "1.18.32"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.groovy:groovy:${groovyVersion}")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
// https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.13")
// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.5.6")
// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-yaml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.1")

}

tasks.test {
    useJUnitPlatform()
}