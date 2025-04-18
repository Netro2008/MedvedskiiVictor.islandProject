package animals;

public abstract class Animal {
    int maxAnimalsOfThisTypeInOneCell, numberOfMaxCellsAnimalCanMove; // максимальное число животных на 1 клетке и скорость передвижения
    double weightKilograms, kilogramsTheyNeedToEatToBeFull; // вес в килограммах и максимум сколько они могут сьесть в килограммах
    boolean isAlive;
    int x, y;

    public Animal(double weightKilograms, int maxAnimalsOfThisTypeInOneCell, int numberOfMaxCellsAnimalCanMove, double kilogramsTheyNeedToEatToBeFull, int x, int y) {
        this.kilogramsTheyNeedToEatToBeFull = kilogramsTheyNeedToEatToBeFull;
        this.weightKilograms = weightKilograms;
        this.numberOfMaxCellsAnimalCanMove = numberOfMaxCellsAnimalCanMove;
        this.maxAnimalsOfThisTypeInOneCell = maxAnimalsOfThisTypeInOneCell;
        this.x = x;
        this.y = y;
        this.isAlive = true;
    }

    protected abstract void eat(Animal animal);
    protected abstract void move();
    protected abstract void reproduce();
}
