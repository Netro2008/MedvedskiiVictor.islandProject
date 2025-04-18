package models;

import animals.Animal;
import utils.Settings;

public class Island {
    static Animal[][] myGameArea = new Animal[Settings.ISLAND_HIGH][Settings.ISLAND_WIDTH];

    public static void putAnimal(Animal animal, int x, int y) {
        myGameArea[x][y] = animal;
    }
}
