package io.temp.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Thermometer {
    private static final Logger logger = LoggerFactory.getLogger(Thermometer.class);

    @Value("${thermometer.minTemp}")
    private int minTemp;

    @Value("${thermometer.maxTemp}")
    private int maxTemp;

    public int measureOnce() {
        logger.debug("Starting measureOnce method");
        cpuIntensiveTask();
        return ThreadLocalRandom.current().nextInt(this.minTemp, this.maxTemp + 1);
    }

    private void cpuIntensiveTask() {
        logger.debug("Starting cpuIntensiveTask method");
        fibonacci(30);
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
