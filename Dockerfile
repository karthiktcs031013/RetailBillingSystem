FROM openjdk:8
ADD target/billing-0.0.1-SNAPSHOT.jar billing-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "billing-0.0.1-SNAPSHOT.jar"]

