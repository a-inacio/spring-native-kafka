FROM springci/graalvm-ce:java17-0.11.x as builder

WORKDIR /root/app

COPY pom.xml .
COPY mvnw .
COPY .mvn ./.mvn

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw -Pnative -DskipTests package

# TODO add a runtime layer!

ENTRYPOINT ["/root/app/target/kafka"]