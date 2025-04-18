package utils;

import java.util.Random;

public final class Randomizer {
    private static final Random random = new Random();

    private Randomizer() {}

    public static boolean getProbability(int percent) { // сьест ли одно животное другое
        validPercent(percent);
        return random.nextInt(101) < percent;
    }

    private static void validPercent(int percent){
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Probability must be between 0 and 100 percent!");
        }
    }

    public static int getRandomInt(int bound) { // на сколько шагов оно пойдёт
        return random.nextInt(bound + 1);
    }

    private static void validBound(int bound){
        if (bound < 0) {
            throw new IllegalArgumentException("Bounds should be positive!");
        }
    }
}
