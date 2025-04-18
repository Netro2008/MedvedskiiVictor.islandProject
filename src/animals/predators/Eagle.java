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

public class Eagle extends Animal {
    public static int x, y;
    public final static double weightKilograms = 6;
    private final static int maxAnimalsOfThisTypeInOneCell = 20;
    private final static int numberOfMaxCellsAnimalCanMove = 3;
    private final static double kilogramsTheyNeedToEatToBeFull = 1;
    public static double ateKilogramsForNow;

    public Eagle(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        super(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
    }

    public static synchronized void createEagle() {
        Random random = new Random();
        int x = random.nextInt(6), y = random.nextInt(6);
        Eagle.x = x;
        Eagle.y = y;
        new Eagle(weightKilograms, maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove, kilogramsTheyNeedToEatToBeFull, x, y);
        Statistics.animalCounter++;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void reproduce() {

    }

    private static final Map<Class<? extends Animal>, Integer> EAGLE_EATING_PROBABILITY = Map.of(Fox.class, 10, Rabbit.class, 90,
            Mouse.class, 90, Duck.class, 80, Caterpillar.class, 95);

    @Override
    protected void eat(Animal animal) {
        if (ateKilogramsForNow < kilogramsTheyNeedToEatToBeFull) {
            if (animal instanceof Fox) {
                boolean eaten = Randomizer.getProbability(EAGLE_EATING_PROBABILITY.get(Fox.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Fox.weightKilograms;
                }
            } else if (animal instanceof Rabbit) {
                boolean eaten = Randomizer.getProbability(EAGLE_EATING_PROBABILITY.get(Rabbit.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Rabbit.weightKilograms;
                }
            } else if (animal instanceof Mouse) {
                boolean eaten = Randomizer.getProbability(EAGLE_EATING_PROBABILITY.get(Mouse.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Mouse.weightKilograms;
                }
            } else if (animal instanceof Duck) {
                boolean eaten = Randomizer.getProbability(EAGLE_EATING_PROBABILITY.get(Duck.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Duck.weightKilograms;
                }
            } else if (animal instanceof Caterpillar) {
                boolean eaten = Randomizer.getProbability(EAGLE_EATING_PROBABILITY.get(Caterpillar.class));
                if (eaten) {
                    Statistics.removeAnimal();
                    ateKilogramsForNow = ateKilogramsForNow + Caterpillar.weightKilograms;
                }
            }
        }
    }
}
