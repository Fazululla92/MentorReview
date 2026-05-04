package MentorNotes.Streams;

import java.util.Arrays;
import java.util.List;

public class FindGreaterIntergers {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player("Alice", 38),
                new Player("Bob", 32),
                new Player("Charlie", 22));
        //whose age is greater than 30;
        players.stream().filter(p -> p.getAge() > 30)
                .forEach(p -> System.out.println(p.getName()+" - "+p.getAge()));

    }
}
class Player {
    private String name;
    private int age;

    // Constructor
    public Player(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}