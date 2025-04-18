package animals.predators;

import animals.Animal;
import animals.herbivores.*;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Map;
import java.util.Random;

public class SnakeBoa extends Animal {
    public static int x, y;
    public final static double weightKilograms = 15;
    private final static int maxAnimalsOfThisTypeInOneCell = 30;
    private final static int numberOfMaxCellsAnimalCanMove = 1;
    private final static double kilogramsTheyNeedToEatToBeFull = 3;
    public static double ateKilogramsForNow;

    public SnakeBoa(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createSnakeBoa() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        SnakeBoa.x = x;
        SnakeBoa.y = y;
        new SnakeBoa(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }

    private static final Map<Class<? extends Animal>, Integer> SNAKE_BOA_EATING_PROBABILITY = Map.of(Fox.class, 15, Rabbit.class, 20,
            Mouse.class, 40, Duck.class, 10);

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (animal instanceof Fox) {
                boolean eaten = Randomizer.getProbability(SNAKE_BOA_EATING_PROBABILITY.get(Fox.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Fox.weightKilograms;
                }
            } else if (animal instanceof Rabbit) {
                boolean eaten = Randomizer.getProbability(SNAKE_BOA_EATING_PROBABILITY.get(Rabbit.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Rabbit.weightKilograms;
                }
            } else if (animal instanceof Mouse) {
                boolean eaten = Randomizer.getProbability(SNAKE_BOA_EATING_PROBABILITY.get(Mouse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Mouse.weightKilograms;
                }
            } else if (animal instanceof Duck) {
                boolean eaten = Randomizer.getProbability(SNAKE_BOA_EATING_PROBABILITY.get(Duck.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Duck.weightKilograms;
                }
            }
        }
    }
}
