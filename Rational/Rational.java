import java.util.Objects;

/**
 * [OVERVIEW]
 *      le istante di questa classe rappresentano numeri razionali.
 *      Gli oggetti di questa classe non sono mutabili.
 *      Un numero razionale tipico è n/d dove n e d sono numeri interi e d è diverso da 0;
 * */

public class Rational {
    /**
     * [FIELDS]
     * */

    /**
     * Campi per la rappresentazione del numeratore e denominatore del numero razionale
     * */
    private int numerator, denominator;

    /**
     * [ABS FUN]
     *      AF(numerator, denominator) = numerator/denominator
     *
     * [REP INV] 
     *      denominator > 0
     *
     * [ABS INV] 
     *      denominator != 0 (quindi rispettato se REP INV viene rispettato)
     * */

    /**
     * [CONSTRUCTOR]
     * */

    /**
     * [MODIFIES]
     *      this.numerator
     *      this.denominator
     * [EFFECTS]
     *      inizializza this affinché rappresenti un razionale n/d valido.
     *      d == 0 solleva eccezione {@link ArithmeticException}
     *
     * [OP CORRECTNESS]
     *      AF(numerator, denominator) = numerator/denominator
     *      = (numerator/cd)/(denominator/cd) dove cd = gcd(|numerator|, denominator)
     *      =  |numerator|/|denominator| se numerator * denominator < 0
     *         |numerator|/|denominator| 
     *
     * [RI PRESERVATION]
     *      se d == 0, è sollevata un'eccezione e quindi this non è istanziato
     *      altrimenti è utilizzato il suo valore assoluto
     *
     *
     *  @throws ArithmeticException se d == 0
     * */
    public Rational(int n, int d) {
        if (d == 0) throw new ArithmeticException("Numero razionale illegale. Denominatore non può essere 0");
        this.numerator = n*d > 0? Math.abs((numerator)) : -Math.abs(numerator);
        this.denominator = d;

        reduce();

        assert repOk();
    };

    /**
     * [METHODS]
     * */

    /**
     * [REQUIRES]
     *      this.denominator != 0
     *
     * [MODIFIES]
     *      potrebbe modificare this se non è ridotta
     *
     * [EFFECTS]
     *      modificare this affinche' rappresenti il numero razionale ai minimi termini
     *
     *  [RI PRESERVATION]
     *      this.denominator > 0 => denominator >= gcd(|numerator|, denominator) > 0
     *
     *  [OP CORRECTNESS]
     *      AF(numerator, denominator) = numerator/denominator
     *      = (numerator/cd)/(denominator/cd) dove cd = gcd(|numerator|, denominator)
     *
     * */
    private void reduce() {
        int cd = gcd(numerator, denominator);
        numerator /= cd;
        denominator /= cd;
    }

    /**
     * [REQUIRES]
     *      this.denominator != 0
     *
     * [MODIFIES]
     *      potrebbe modificare this se non è ridotta
     *
     * [EFFECTS]
     *      restituisce il massimo comun divisore tra a e b
     *      Solleva un'eccezione se a o b minore 0
     *
     *
     * */
    private static int gcd(int a, int b) {
        if (a < 0 || b < 0) throw new IllegalArgumentException("A e B devono essere più grandi di 0");

        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }

    /**
     * [EFFECTS]
     *      restituisce il numero razionale this + o
     *      Se o == null solleva {@link NullPointerException}
     *
     * [RI PRESERVATION]
     *      this.denominator > 0 => denominator >= gcd(|numerator|, denominator) > 0
     *      pertanto, denominator / gcd(|numerator|, denominator) > 0
     *
     * [OP CORRECTNESS]
     *      numerator/denominator * o.numerator/ ...
     *
     *  @throws NullPointerException
     * */
    public Rational add(Rational o) {
        Objects.requireNonNull(o);

        return new Rational(
                o.denominator*numerator + o.numerator * denominator,
                denominator * o.denominator
                );
    };

    /**
     * [EFFECTS]
     *      restituisce il numero razionale this * o
     *      Se o == null solleva {@link NullPointerException}
     *
     *  @throws NullPointerException
     * */
    public Rational mul(Rational o) {
        Objects.requireNonNull(o);
        return new Rational(numerator * o.numerator, denominator * o.denominator);
    };

    /**
     * [EFFECTS]
     *      restituisce il numero razionale this 1/this
     *      Se o == null solleva {@link NullPointerException}
     *
     * [RI PRESERVATION]
     *      se numerator == 0 viene sollevata un'eccezione
     *      altrimenti valido per ipotesi induttiva
     *
     *  @throws NullPointerException
     * */
    public Rational reciprocal() {
        return new Rational(denominator, numerator);
    };

    /**
     * [EFFECTS]
     *      restituisce il numero razionale this -this
     *      Se o == null solleva {@link NullPointerException}
     *
     *  [RI PRESERVATION]
     *      denominator > 0
     *
     *  @throws NullPointerException
     * */
    public Rational minus() {
        return new Rational(-numerator, denominator);
    };

    /**
     * [EFFECTS]
     *      restituisce il numero razionale this - o
     *
     *  [RI PRESERVATION]
     *      
     * */
    public Rational sub(Rational o) {
        return add(o.minus());
    };



    /**
     * [EFFECTS]
     *      restituisce il numero razionale this / o
     *      se o è null solleva {@link NullPointerException}
     *      solleva un'eccezione di tipo {@link ArithmeticException} se o = 0
     *
     * [RI PRESERVATION]
     *      se o = 0 allora è sollevata un'eccezione, e quindi non è restituito un nuovo oggetto.
     *      o.reciprocal().denominator() > 0 => this.mul(o.reciprocal().denominator()) > 0
     *
     * [OP CORRECTNESS]
     *      (numerator/denominator) / (o.numerator/o.denominator)
     *      (numerator/denominator) / (1/())
     *
     * */
    public Rational div(Rational o) {
        Objects.requireNonNull(o);
        return mul(o.reciprocal());
    };

    private boolean repOk() {
        return denominator > 0;
    };

    @Override
    public String toString() {
        if (denominator == 1) return "" + numerator;
        return numerator + "/" + denominator;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(numerator);
        result = 31 * result + Integer.hashCode(denominator);
        return result;
    }

    /*
     * []
     *
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) return false;
        Rational other = (Rational) o;

        return numerator == other.numerator && denominator == other.denominator;
    }
}
