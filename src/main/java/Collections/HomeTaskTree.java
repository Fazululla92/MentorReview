package Collections;

import java.util.*;

public class HomeTaskTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int Q = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            StringBuilder output = new StringBuilder();

            for (int i = 0; i < Q; i++) {
                char type = sc.next().charAt(0);

                switch (type) {
                    case 'a':
                        int key = sc.nextInt();
                        int value = sc.nextInt();
                        map.put(key, value);
                        break;

                    case 'b':
                        int x = sc.nextInt();
                        output.append(map.getOrDefault(x, -1)).append(" ");
                        break;

                    case 'c':
                        output.append(map.size()).append(" ");
                        break;

                    case 'd':
                        int remKey = sc.nextInt();
                        map.remove(remKey);
                        break;

                    case 'e':
                        for (int k : map.keySet()) {
                            output.append(k).append(" ");
                        }
                        break;
                }
            }

            System.out.println(output.toString().trim());
        }

        sc.close();
    }
}
