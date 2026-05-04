package CoreJava;

import java.util.*;

abstract class Flower {
    abstract int getCost();
}

class Rose extends Flower {
    public int getCost() {
        return 1;
    }
}

class Jasmine extends Flower {
    public int getCost() {
        return 2;
    }
}

class Lily extends Flower {
    public int getCost() {
        return 3;
    }
}

public class Bouquet {
    private List<Flower> flowers = new ArrayList<>();

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public int calculateCost() {
        int total = 0;
        for (Flower f : flowers) {
            total += f.getCost();
        }
        return total;
    }
}

class Main {
    static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        bouquet.addFlower(new Rose());
        bouquet.addFlower(new Jasmine());
        bouquet.addFlower(new Lily());
        bouquet.addFlower(new Rose());

        System.out.println("Total Cost: $" + bouquet.calculateCost());
    }
}
