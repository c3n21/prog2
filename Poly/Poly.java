import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * [OVERVIEW]
 *      creazione e manipolazione di polinomi
 *
 * */

public class Poly {


        private final List<Monomial> monomials;
        
        public Poly (){
                monomials = new ArrayList<>();
        };

        /**
         * @param c coefficiente monomio
         *
         * @param n grado del monomio
         *
         * @throws NegativeExponentException @param n minore di 0
         *
         * */
        public Poly (int c, int n) {
                if (n < 0) {
                        throw new NegativeExponentException("n minore di 0");
                }

                monomials = new ArrayList<>();
                monomials.add(new Monomial(c, n));
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

                this.monomials.stream().forEach(it -> {
                        q.monomials.forEach(q_it -> {
                                it.add(q_it);
                        });
                });

                return this;
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
                this.monomials.stream().forEach(it -> {
                        q.monomials.forEach(q_it -> {
                                it.add(q_it);
                        });
                });

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

        /**
         * [EFFECT]
         *      restituisce il grado del polinomio
         *
         *  @return {@code int} grado del polinomio
         */
        int degree () {
                int res = 0;
                Monomial m = this.monomials.stream()
                        .max(Comparator.comparing(Monomial::degree)).orElse(null);

                if (m != null) {
                        res = m.degree();
                }


                return res;
        }
}
