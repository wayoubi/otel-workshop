This is a sample applications repository with a rust and java spring boot applications. It is primarily responsible for demonstrating best practices for using otelp in these applications.

## Code Standards

### Required Before Each Commit
- Run `./mvnw clean install test` before committing any spring boot changes to ensure successful builds

### Development Flow
For each spring-boot application, follow this flow:
- Build: `./mvnw clean install`
- Test: `./mvnw test`
- Run: `./mvnw spring-boot:run`
- Package: Use docker to build image `docker init .` and `docker build -t otel-course-<spring-boot-application-name> .`
-data-processing
For rust data processing application, follow this flow:
- Build: `cargo build --release`
- Test: `cargo test`
- Run: `cargo run --release`
- Package: Use docker to build image `docker init .` and `docker build -t otel-course-data-processing .`

## Repository Structure
- `src/data-processing`: Data processing logic and utilities written in Rust
- `src/otelcollector`: Otelcollector configuration and setup files
- `src/temperature-calculator`: spring-boot application for temperature calculations
- `src/temperature-simulator`: spring-boot application for simulating temperature data

## Key Guidelines
1. Follow Java best practices and idiomatic patterns
2. Maintain existing code structure and organization
3. Use dependency injection patterns where appropriate
4. Write unit tests for new functionality. Use table-driven unit tests when possible.
5. Document public APIs and complex logic. Suggest changes to the `docs/` folder when appropriate
