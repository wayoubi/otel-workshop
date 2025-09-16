FROM maven:3.9.11-amazoncorretto-21-alpine@sha256:737184ed36f68e6eee4c80c56cd736698dc069a67fd1941ef9e27366ed1c4cd4 AS builder
WORKDIR /app/
COPY . .
RUN mvn clean install

FROM gcr.io/distroless/java21-debian12 AS runtime
WORKDIR /app/
COPY --from=builder /app/target/tempcalculator-0.0.1.jar ./
ENTRYPOINT [ "java", "-jar", "tempcalculator-0.0.1.jar" ]
ARG version=2.20.0
ADD --chmod=644 https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v$version/opentelemetry-javaagent.jar /usr/src/app/opentelemetry-javaagent.jar
ENV JAVA_TOOL_OPTIONS=-javaagent:/usr/src/app/opentelemetry-javaagent.jar
