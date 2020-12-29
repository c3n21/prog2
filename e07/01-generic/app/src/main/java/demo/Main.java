package demo;

import java.util.Scanner;

import collections.map.*;
import collections.queue.*;

public class Main {
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

                System.out.println(map.get(word));
            }

            if (arg.equals("Q")) {
                Queue<Integer> queue;
            }

            if (arg.equals("S")) {

            }
        }

    }
}
