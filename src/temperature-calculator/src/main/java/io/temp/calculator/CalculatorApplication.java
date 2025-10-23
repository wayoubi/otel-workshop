package io.temp.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorApplication.class);

    public static void main(String[] args) {
        logger.debug("Starting Temperature Calculator Application");
        SpringApplication app = new SpringApplication(CalculatorApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
