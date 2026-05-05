package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class Page implements PageComponent {

    private String format; // mobile / desktop etc.
    private int baseRank;

    private List<PageComponent> components = new ArrayList<>();

    public Page(String format, int baseRank) {
        this.format = format;
        this.baseRank = baseRank;
    }

    public void addComponent(PageComponent component) {
        components.add(component);
    }

    public void removeComponent(PageComponent component) {
        components.remove(component);
    }

    @Override
    public int getRank() {
        int totalRank = baseRank;

        for (PageComponent component : components) {
            totalRank += component.getRank();
        }

        return totalRank;
    }

    public String getFormat() {
        return format;
    }
}

class Testing {
    public static void main(String[] args) {
        Widget header = new Widget("Header", 5);
        Widget footer = new Widget("Footer", 3);
        Widget banner = new Widget("Banner", 10);

        Page mobilePage = new Page("Mobile", 20);

        mobilePage.addComponent(header);
        mobilePage.addComponent(banner);

        Page desktopPage = new Page("Desktop", 40);

        desktopPage.addComponent(header);
        desktopPage.addComponent(footer);
        desktopPage.addComponent(banner);

        System.out.println("Mobile Page Rank: " + mobilePage.getRank());
        System.out.println("Desktop Page Rank: " + desktopPage.getRank());
    }
}
