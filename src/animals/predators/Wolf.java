package animals.predators;

import animals.Animal;
import animals.herbivores.*;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Map;
import java.util.Random;

public class Wolf extends Animal {
    public static int x, y;
    public final static double weightKilograms = 50;
    private final static int maxAnimalsOfThisTypeInOneCell = 30;
    private final static int numberOfMaxCellsAnimalCanMove = 3;
    private final static double kilogramsTheyNeedToEatToBeFull = 8;
    public static double ateKilogramsForNow;

    public Wolf(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createWolf() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Wolf.x = x;
        Wolf.y = y;
        new Wolf(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }

    private static final Map<Class<? extends Animal>, Integer> WOLF_EATING_PROBABILITY = Map.of(Horse.class, 10, Deer.class, 15, Rabbit.class, 60,
            Mouse.class, 80, Goat.class, 60, Sheep.class, 70, Hog.class, 15, Buffalo.class, 10, Duck.class, 40);

    @Override
    protected synchronized void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (animal instanceof Horse) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Horse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Horse.weightKilograms;
                }
            } else if (animal instanceof Deer) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Deer.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Deer.weightKilograms;
                }
            } else if (animal instanceof Rabbit) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Rabbit.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Rabbit.weightKilograms;
                }
            } else if (animal instanceof Mouse) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Mouse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Mouse.weightKilograms;
                }
            } else if (animal instanceof Goat) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Goat.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Goat.weightKilograms;
                }
            } else if (animal instanceof Sheep) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Sheep.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Sheep.weightKilograms;
                }
            } else if (animal instanceof Hog) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Hog.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Hog.weightKilograms;
                }
            } else if (animal instanceof Buffalo) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Buffalo.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Buffalo.weightKilograms;
                }
            } else if (animal instanceof Duck) {
                boolean eaten = Randomizer.getProbability(WOLF_EATING_PROBABILITY.get(Duck.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Duck.weightKilograms;
                }
            }
        }
    }
}
