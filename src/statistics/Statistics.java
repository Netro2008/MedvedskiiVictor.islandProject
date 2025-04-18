package statistics;

public class Statistics {
    public static int animalCounter = 0;
    public static int grassCounter = 0;

    public synchronized static void removePlant() {
        grassCounter--;
    }

    public synchronized static void removeAnimal() {
        animalCounter--;
    }
}
