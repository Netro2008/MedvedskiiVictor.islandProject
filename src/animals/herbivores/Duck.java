package animals.herbivores;

import animals.Animal;
import animals.plants.Grass;
import animals.predators.*;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Random;

public class Duck extends Animal {
    public static int x, y;
    public final static double weightKilograms = 1;
    private final static int maxAnimalsOfThisTypeInOneCell = 200;
    private final static int numberOfMaxCellsAnimalCanMove = 4;
    private final static double kilogramsTheyNeedToEatToBeFull = 0.15;
    public static double ateKilogramsForNow;

    public Duck(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createDuck() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Duck.x = x;
        Duck.y = y;
        new Duck(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    private static final int DUCK_EATING_GRASS_PROBABILITY = 100;
    private static final int DUCK_EATING_CATERPILLAR_PROBABILITY = 90;

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (!(animal instanceof Wolf) && !(animal instanceof SnakeBoa) && !(animal instanceof Fox) && !(animal instanceof Eagle) && !(animal instanceof Bear)
                    && !(animal instanceof Sheep) && !(animal instanceof Rabbit) && !(animal instanceof Mouse) && !(animal instanceof Horse) && !(animal instanceof Hog)
                    && !(animal instanceof Goat) && !(animal instanceof Duck) && !(animal instanceof Deer) && !(animal instanceof Caterpillar)
                    && !(animal instanceof Buffalo)) {
                boolean eaten = Randomizer.getProbability(DUCK_EATING_GRASS_PROBABILITY);
                if (eaten) {
                    Statistics.removePlant();
                    ateKilogramsForNow = ateKilogramsForNow + Grass.weightKilograms;
                }
            } else if (animal instanceof Caterpillar) {
                boolean eaten = Randomizer.getProbability(DUCK_EATING_CATERPILLAR_PROBABILITY);
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Caterpillar.weightKilograms;
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
