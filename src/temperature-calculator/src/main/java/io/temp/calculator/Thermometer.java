package io.temp.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class Thermometer {

    @Value("${thermometer.minTemp}")
    private int minTemp;

    @Value("${thermometer.maxTemp}")
    private int maxTemp;

    public int measureOnce() {
        cpuIntensiveTask();
        return ThreadLocalRandom.current().nextInt(this.minTemp, this.maxTemp + 1);
    }

    private void cpuIntensiveTask() {
        fibonacci(30);
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
