FROM openjdk:11
EXPOSE 8080
ADD /build/libs/egraphql-kotlin-1.0-SNAPSHOT.jar graphql-kotlin.jar
ENTRYPOINT ["java", "-jar", "graphql-kotlin.jar"]
