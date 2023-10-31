FROM maven:3.8.5-openjdk-17
WORKDIR /restservice
COPY . .

RUN mvn install -DskipTests

CMD ["java", "-jar", "target/restservice-0.0.1-SNAPSHOT.jar"]