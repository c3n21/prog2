public class Monomial implements {
        private int c;
        private int n;

        public Monomial () {
                this.c = 0;
                this.n = 0;
        }

        /**
         * @param c coefficiente
         *
         * @param n grado del monomio 
         *
         * @throws NegativeExponentException se n minore di 0
         *
         * */
        public Monomial (int c, int n) {
                if (n < 0) {
                        throw new NegativeExponentException("n minore di 0");
                }

                this.c = c;
                this.n = n;
        }

        /**
         * [EFFECT]
         *      restituisce la somma di due monomi
         *
         *  @return {@code int} somma dei monomi
         */
        Monomial add (Monomial m) {

                if (m.n == this.n) {

                        this.c += m.c;
                }

                return this;
        }

        /**
         * [EFFECT]
         *      restituisce la somma di due monomi
         *
         *  @return {@code int} somma dei monomi
         */
        Monomial add (Monomial m) {

                if (m.n == this.n) {

                        this.c += m.c;
                }

                return this;
        }

        /**
         * [EFFECT]
         *      restituisce il grado del monomio
         *
         *  @return {@code int} grado del monomio
         */
        int degree () {
                return n;
        }

        /**
         * [EFFECT]
         *      restituisce il coefficiente del monomio
         *
         *  @return {@code int} coefficiente del monomio
         */
        int coeff () {
                return c;
        }
}
