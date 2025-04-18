package animals.plants;

import animals.predators.Wolf;

public class Grass {
    public static double weightKilograms = 1;
    public static int maxAnimalsOfThisTypeInOneCell = 200;

    public Grass() {
    }

    public static Grass createGrass() {
        return new Grass();
    }
}
