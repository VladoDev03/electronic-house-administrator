plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    Hibernate
    implementation("org.hibernate:hibernate-core:5.6.15.Final")
    implementation("mysql:mysql-connector-java:8.0.28")

//    Logging
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")

//    Testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}