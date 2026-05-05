package DesignPatterns;

interface PageComponent {
    int getRank();
}

public class Widget implements PageComponent {

    private String name;
    private int rank;

    public Widget(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }
}
