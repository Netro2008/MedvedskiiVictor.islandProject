package animals.herbivores;

import animals.Animal;
import animals.plants.Grass;
import animals.predators.*;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Random;

public class Horse extends Animal {
    public static int x, y;
    public final static double weightKilograms = 400;
    private final static int maxAnimalsOfThisTypeInOneCell = 20;
    private final static int numberOfMaxCellsAnimalCanMove = 4;
    private final static double kilogramsTheyNeedToEatToBeFull = 60;
    public static double ateKilogramsForNow;

    public Horse(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createHorse() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Horse.x = x;
        Horse.y = y;
        new Horse(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    private static final int HORSE_EATING_PROBABILITY = 100;

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (!(animal instanceof Wolf) && !(animal instanceof SnakeBoa) && !(animal instanceof Fox) && !(animal instanceof Eagle) && !(animal instanceof Bear)
                    && !(animal instanceof Sheep) && !(animal instanceof Rabbit) && !(animal instanceof Mouse) && !(animal instanceof Horse) && !(animal instanceof Hog)
                    && !(animal instanceof Goat) && !(animal instanceof Duck) && !(animal instanceof Deer) && !(animal instanceof Caterpillar)
                    && !(animal instanceof Buffalo)) {
                boolean eaten = Randomizer.getProbability(HORSE_EATING_PROBABILITY);
                if (eaten) {
                    Statistics.removePlant();
                    ateKilogramsForNow = ateKilogramsForNow + Grass.weightKilograms;
                }
            }
        }
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }
}
