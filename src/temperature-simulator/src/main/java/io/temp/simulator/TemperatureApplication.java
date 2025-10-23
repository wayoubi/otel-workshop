package io.temp.simulator;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk;
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TemperatureApplication {
  private static final Logger logger = LoggerFactory.getLogger(TemperatureApplication.class);

  @Bean
  public OpenTelemetry openTelemetry() {
    logger.debug("Initializing OpenTelemetry");
    OpenTelemetry openTelemetry = AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();

    OpenTelemetryAppender.install(openTelemetry);

    return openTelemetry;
  }

  public static void main(String[] args) {
    logger.debug("Starting Temperature Simulator Application");
    SpringApplication app = new SpringApplication(TemperatureApplication.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
  }

  @Bean
  public RestTemplate restTemplate() {
    logger.debug("Creating RestTemplate bean");
    return new RestTemplateBuilder().build();
  }
}
