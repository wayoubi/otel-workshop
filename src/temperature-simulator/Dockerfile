FROM maven:3.9.11-amazoncorretto-21-alpine@sha256:737184ed36f68e6eee4c80c56cd736698dc069a67fd1941ef9e27366ed1c4cd4 AS builder
WORKDIR /app/
COPY . .
RUN mvn clean install

FROM gcr.io/distroless/java21-debian12
WORKDIR /usr/src/app/
COPY --from=builder /app/target/tempsimulator-0.0.1.jar ./
ENTRYPOINT [ "java", "-jar", "tempsimulator-0.0.1.jar" ]
