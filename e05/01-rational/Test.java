import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String args[]) {
        List <Rational> rationals = new ArrayList<>();
        long count = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNext()) {
                int a = scanner.nextInt(), b = scanner.nextInt();
                Rational rational = new Rational(a, b);
                count += rationals.stream().filter((element)-> element.equals(rational))
                    .findAny().isPresent()? 1: 0;
                rationals.add(rational);
            }
        }

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

        System.out.println(count);
    }
}
