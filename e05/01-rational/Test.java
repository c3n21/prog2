import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        List <Rational> rationals = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                int a = scanner.nextInt(), b = scanner.nextInt();
                Rational rational = new Rational(a, b);
                rationals.add(rational);
            }
        }

        rationals.forEach(System.out::println);

        Rational tmp = null;

        //somma
        for (Rational rational : rationals) {
            if (tmp == null) {
                tmp = rational;
            } else {
                tmp = tmp.add(rational);
            }
        }
        System.out.println(tmp);
        
        //moltiplicazione
        tmp = null;
        for (Rational rational : rationals) {
            if (tmp == null) {
                tmp = rational;
            } else {
                tmp = tmp.mul(rational);
            }
        }
        System.out.println(tmp);

        //divisione
        tmp = null;
        for (Rational rational : rationals) {
            if (tmp == null) {
                tmp = rational;
            } else {
                tmp = tmp.div(rational);
            }
        }
        System.out.println(tmp);

        long count = rationals.stream().filter(rational -> {
            System.out.println(String.format("rational = %s", rational));
            return Collections.frequency(rationals, rational) > 1;
        }).count();
        System.out.println(count >= 1? count-1 : 0);
    }
}
