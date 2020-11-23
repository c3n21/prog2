/**
 * [OVERVIEW]
 *      creazione e manipolazione
 *
 * */

public class Poly {

        final int c;

        final int n;
        
        public Poly (){
                c = 0;
                n = 0;
        };

        /**
         * @param c coefficiente monomio
         *
         * @param n grado del monomio
         *
         * @throws NegativeExponentException {@code int} n < 0
         *
         * */
        public Poly (int c, int n) {
                if (n < 0) {
                        throw new NegativeExponentException("n minore di 0");
                }
                this.c = c;
                this.n = n;
        }

        /**
         * [EFFECT]
         *      crea un polinomio a partire dalla somma degli altri due
         *
         * @param q un polinomio
         *
         * @return polinomio risultato dalla somma tra {@code Poly} this e {@code Poly} q 
         *
         * */
        Poly add (Poly q) {
                if (q.n == this.n) {
                        return new Poly(this.c, this.n);
                }
                return new Poly();
        }

        /**
         * [EFFECT]
         *      sottrazione del polinomio {@code Poly} this, {@code Poly} q
         *
         * @param q un polinomio
         *
         * @return polinomio risultato dalla differenza tra {@code Poly} this e {@code Poly} q
         *
         * */
        Poly sub (Poly q) {
                if (q.n == this.n) {
                        return new Poly(this.c - q.c, this.n);
                }
                return new Poly();
        }

        /**
         * [EFFECT]
         *      prodotto del polinomio {@code Poly} this, {@code Poly} q
         *
         * @param q un polinomio
         *
         * @return polinomio risultato prodotto tra {@code Poly} this e {@code Poly} q
         *
         * */
        Poly mul (Poly q) {
                return new Poly(this.c * q.c, q.n + this.n);
        }

        /**
         * [EFFECT]
         *      opposto del polinomio {@code Poly} this
         *
         * @return polinomio opposto
         *
         * */
        Poly minus () {
                return new Poly(-this.c, this.n);
        }
}