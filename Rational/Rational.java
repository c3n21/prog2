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
         *      denominator != 0
         * */

        /**
         * [BUILDER]
         * */
        /**
         * [MODIFIES]
         *      this.numerator
         *      this.denominator
         * [EFFECTS]
         *      inizializza this affinché rappresenti un razionale n/d valido.
         *      d == 0 solleva eccezione {@link ArithmeticException}
         *
         ************************************************************************************
         *
         *  [PRESERVAZIONE RI]
         *      se d == 0, è sollevata un'eccezione e quindi this non è istanziato
         *      altrimenti è utilizzato il suo valore assoluto
         *
         *  [CORRETTEZZA]
         *      AF(numerator, denominator) = numerator/denominator
         *      = (numerator/cd)/(denominator/cd) dove cd = gcd(|numerator|, denominator)
         *      = -|numerator|/|denominator| se numerator * denominator < 0
         *         |numerator|/|denominator| 
         *  [PRESERVAZIONE AI]
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
         ************************************************************************************
         *
         *  [PRESERVAZIONE RI]
         *      this.denominator > 0 => denominator >= gcd(|numerator|, denominator) > 0
         *
         *  [CORRETTEZZA]
         *      AF(numerator, denominator) = numerator/denominator
         *      = (numerator/cd)/(denominator/cd) dove cd = gcd(|numerator|, denominator)
         *
         *  [PRESERVAZIONE AI]
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
         * [PRESERVAZIONE RI]
         *      this.denominator > 0 => denominator >= gcd(|numerator|, denominator) > 0
         *      pertanto, denominator / gcd(|numerator|, denominator) > 0
         *
         * [CORRETTEZZA]
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
         * [PRESERVAZIONE RI]
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
         *  [PRESERVAZIONE RI]
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
         *  [PRESERVAZIONE RI]
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
         * [PRESERVAZIONE RI]
         *      se o = 0 allora è sollevata un'eccezione, e quindi non è restituito un nuovo oggetto.
         *      o.reciprocal().denominator() > 0 => this.mul(o.reciprocal().denominator()) > 0
         *
         * */
        public Rational div(Rational o) {
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
                //[EJ 3.11] 
                int result = Integer.hashCode(numerator);
                result = 31 * result + Integer.hashCode(denominator);
                //perché 31?
                return super.hashCode();
        }

        @Override
        public boolean equals(Object o) {
                if (!(o instanceof Rational)) return false;
                Rational other = (Rational) o;

//                /**
//                 * Metodo Liskov
//                 * */
//                reduce();
//                other.reduce();
                /**
                 * 
                 */

                return numerator == other.numerator && denominator == other.denominator;
        }
}
