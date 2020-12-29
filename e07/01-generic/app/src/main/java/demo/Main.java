package demo;

import java.util.Scanner;

import collections.map.*;
import collections.queue.*;

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

                while (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                }
            }

            if (arg.equals("S")) {
                
            }
        }

    }
}
