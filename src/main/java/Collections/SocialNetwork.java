package Collections;

import java.util.*;

public class SocialNetwork {

    private HashMap<String, HashSet<String>> network = new HashMap<>();
    private void ensureUser(String user) {
        if (user == null) throw new NullPointerException();
        network.putIfAbsent(user, new HashSet<>());
    }

    public void addFriend(String user1, String user2) {
        if (user1 == null || user2 == null) throw new NullPointerException();

        ensureUser(user1);
        ensureUser(user2);

        network.get(user1).add(user2);
        network.get(user2).add(user1);
    }

    public void removeFriend(String user1, String user2) {
        if (user1 == null || user2 == null) throw new NullPointerException();

        if (network.containsKey(user1)) {
            network.get(user1).remove(user2);
        }
        if (network.containsKey(user2)) {
            network.get(user2).remove(user1);
        }
    }
    public void displayFriends(String user) {
        if (user == null) throw new NullPointerException();

        HashSet<String> friends = network.get(user);
        if (friends == null) {
            System.out.println(user + " has no friends.");
            return;
        }

        System.out.println(user + "'s friends: " + friends);
    }
    public HashSet<String> mutualFriends(String user1, String user2) {
        if (user1 == null || user2 == null) throw new NullPointerException();

        HashSet<String> result = new HashSet<>();

        HashSet<String> f1 = network.get(user1);
        HashSet<String> f2 = network.get(user2);

        if (f1 == null || f2 == null) return result;

        for (String friend : f1) {
            if (f2.contains(friend)) {
                result.add(friend);
            }
        }

        return result;
    }
    public void displayFriendCounts() {
        for (Map.Entry<String, HashSet<String>> entry : network.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().size() + " friends");
        }
    }
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork();

        sn.addFriend("Alice", "Bob");
        sn.addFriend("Bob", "Charlie");

        sn.displayFriends("Alice");
        sn.displayFriends("Bob");
        sn.displayFriends("Charlie");

        System.out.println("Mutual friends (Alice, Bob): " +
                sn.mutualFriends("Alice", "Bob"));

        sn.displayFriendCounts();

        sn.removeFriend("Alice", "Bob");

        System.out.println("After removal:");
        sn.displayFriends("Alice");
        sn.displayFriends("Bob");
    }
}