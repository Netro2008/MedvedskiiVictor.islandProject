package animals.predators;

import animals.Animal;
import animals.herbivores.Caterpillar;
import animals.herbivores.Duck;
import animals.herbivores.Mouse;
import animals.herbivores.Rabbit;
import statistics.Statistics;
import utils.Randomizer;

import java.util.Map;
import java.util.Random;

public class Fox extends Animal {
    public static int x, y;
    public final static double weightKilograms = 8;
    private final static int maxAnimalsOfThisTypeInOneCell = 30;
    private final static int numberOfMaxCellsAnimalCanMove = 2;
    private final static double kilogramsTheyNeedToEatToBeFull = 2;
    public static double ateKilogramsForNow;

    public Fox(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createFox() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Fox.x = x;
        Fox.y = y;
        new Fox(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }

    private static final Map<Class<? extends Animal>, Integer> FOX_EATING_PROBABILITY = Map.of(Rabbit.class, 70, Mouse.class, 90,
            Duck.class, 60, Caterpillar.class, 40);

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (animal instanceof Rabbit) {
                boolean eaten = Randomizer.getProbability(FOX_EATING_PROBABILITY.get(Rabbit.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Rabbit.weightKilograms;
                }
            } else if (animal instanceof Mouse) {
                boolean eaten = Randomizer.getProbability(FOX_EATING_PROBABILITY.get(Mouse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Mouse.weightKilograms;
                }
            } else if (animal instanceof Duck) {
                boolean eaten = Randomizer.getProbability(FOX_EATING_PROBABILITY.get(Duck.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Duck.weightKilograms;
                }
            } else if (animal instanceof Caterpillar) {
                boolean eaten = Randomizer.getProbability(FOX_EATING_PROBABILITY.get(Caterpillar.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Caterpillar.weightKilograms;
                }
            }
        }
    }
}
