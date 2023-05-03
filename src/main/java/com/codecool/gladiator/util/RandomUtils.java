package com.codecool.gladiator.util;

import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    /**
     * Returns a random integer between 0 (inclusive) and the specified max value (exclusive)
     */
    public static int getRandomInt(int max) {
        return RANDOM.nextInt(max);
    }

    /**
     * Returns a random integer between the specified min
     * value (inclusive) and the specified max value (exclusive)
     */
    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }

    /**
     * Returns a random double between 0 (inclusive) and 1 (exclusive)
     */
    public static double getRandomDouble() {
        return RANDOM.nextDouble();
    }
}
