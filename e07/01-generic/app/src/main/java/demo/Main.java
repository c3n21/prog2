package demo;

import java.util.Scanner;

import collections.map.*;
import collections.queue.*;
import collections.set.DumbSet;
import collections.set.Set;

public class Main {
    public static String res;

    public static void main(String args[]) {
        System.out.println("args[0] = " + args[0]);
        String arg = args[0];

        try(Scanner scanner = new Scanner(System.in)) {
            if (arg.equals("M")) {
                Map<String, Integer> map = new DumbMap<>();
                String word = null;

                while (scanner.hasNext()) {
                    String key = scanner.next();

                    if (word == null) {
                        word = key;
                    }
                    map.put(key, scanner.nextInt());
                }

                Main.res = map.get(word).toString();
                System.out.println(Main.res);
            }

            if (arg.equals("Q")) {
                Queue<Integer> queue = new DumbQueue<>();
                while (scanner.hasNext()) {
                    queue.enqueue(scanner.nextInt());
                }

                System.out.println(queue);
            }

            if (arg.equals("S")) {
                Set<String> set = new DumbSet<>();

                while (scanner.hasNext()) {
                    set.add(scanner.next());
                }

                Main.res = String.format("%d", set.size());

                System.out.println(Main.res);
            }
        }

    }
}
