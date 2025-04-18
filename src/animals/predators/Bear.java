package animals.predators;

import animals.Animal;
import animals.herbivores.*;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Map;
import java.util.Random;

public class Bear extends Animal {
    public static int x, y;
    public final static double weightKilograms = 500;
    private final static int maxAnimalsOfThisTypeInOneCell = 5;
    private final static int numberOfMaxCellsAnimalCanMove = 2;
    private final static double kilogramsTheyNeedToEatToBeFull = 80;
    public static double ateKilogramsForNow;

    public Bear(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createBear() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Bear.x = x;
        Bear.y = y;
        new Bear(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }

    private static final Map<Class<? extends Animal>, Integer> BEAR_EATING_PROBABILITY = Map.of(SnakeBoa.class, 80, Horse.class, 40,
            Deer.class, 80, Rabbit.class, 80, Mouse.class, 90, Goat.class, 70, Sheep.class, 70, Hog.class, 50, Buffalo.class, 20,
            Duck.class, 10);

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (animal instanceof SnakeBoa) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(SnakeBoa.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + SnakeBoa.weightKilograms;
                }
            }
            else if (animal instanceof Horse) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Horse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Horse.weightKilograms;
                }
            }
            else if (animal instanceof Deer) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Deer.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Deer.weightKilograms;
                }
            }
            else if (animal instanceof Rabbit) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Rabbit.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Rabbit.weightKilograms;
                }
            }
            else if (animal instanceof Mouse) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Mouse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Mouse.weightKilograms;
                }
            }
            else if (animal instanceof Goat) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Goat.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Goat.weightKilograms;
                }
            }
            else if (animal instanceof Sheep) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Sheep.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Sheep.weightKilograms;
                }
            }
            else if (animal instanceof Hog) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Hog.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Hog.weightKilograms;
                }
            }
            else if (animal instanceof Buffalo) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Buffalo.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Buffalo.weightKilograms;
                }
            } else if (animal instanceof Duck) {
                boolean eaten = Randomizer.getProbability(BEAR_EATING_PROBABILITY.get(Duck.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Duck.weightKilograms;
                }
            }
        }
    }
}
