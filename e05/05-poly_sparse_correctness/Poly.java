import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Questa classe rappresenta un polinomio di grado n sparso (si assume che il grado sia >= 0).
 * Sono oggetti immutabili e le operazioni disponibili sono: 
 *
 */
public final class Poly {
	private final List<Monomial> trms;

    private static final class Monomial {
        /**
         * [ABS FUN]
         *      AF(coeff, degree) = polinomio:
         *      monimial1 ... monimialn dove monomial è un oggetto del tipo (coeff)x^(degree)
         *      AF(coeff) = 0 if coeff.length = 0.
         *
         * [REP INV]
         *      degree >= 0
         * */
        private final int degree;
        private final int coeff;

        private Monomial(int coeff, int degree) {
            if (degree < 0) {
                throw new IllegalArgumentException("[Monomial] Degree must be >= 0");
            }
            this.coeff = coeff;
            this.degree = degree;
        }

        private boolean sameDegree(Monomial other) {
            return degree == other.degree;
        }
    }

	/*
     * [ABS FUN]
	 *      AF(trms) = polinomio:
     *      monimial1 ... monimialn dove monomial è un oggetto del tipo (coeff)x^(degree)
	 *      AF(coeff) = 0 if coeff.length = 0.
     * 
     * [REP INV]
     *      trms non deve essere null
     *      non ci devono essere più monomi con lo stesso grado: questi vanno uniti in uno solo
	 */

    /**
     *[CONSTRUCTOR]
     */

	/**
     * [EFFECTS]
     *      creazione polinomio zero
     *
     * [OP CORRECTNESS]
     *      trms.size() == 0 => il valore del polinomio è 0
	 */
	public Poly() {
		this.trms = new ArrayList<>(); 
	}

	/**
     * [EFFECTS]
     *      costruisce un monomio
     *
     * [OP CORRECTNESS]
     *      trms.size() == 0
     *      se c == 0:
     *          trms.size() == 0
     *      se c != 0:
     *          trms.size() == 1
     *
     *      è impossibile che ci siano più monomi con lo stesso grado dal momento che la lista ha dimensione al massimo 1
     *
	 * @param c coefficiente
	 * @param n esponente
     *
	 * @throws IllegalArgumentException se n < 0
	 */
	public Poly(int c, int n) {
        Monomial monomial = null;
        this.trms = new ArrayList<>();

		if (c != 0) {
            monomial = new Monomial(c, n);
            trms.add(monomial);
        }                

		assert repOk();
	}

	public boolean repOk() {
        if (trms == null) {
            return false;
        }

        boolean res = true;

        for (Monomial trm : trms) {
            int count = 0;
            for (Monomial other : trms) {
                if (trm.sameDegree(other)) {
                    count++;
                }
                if(count >= 2) {
                    res = false;
                    break;
                }
            }

            if (!res) break;
        }

		return res;
	}

	/**
	 * [EFFECTS]
     *      restituisce un polinomio risultato della somma tra this e q
     *
     * [OP CORRECTNESS]
     *      creo un polinomio 0
     *      creo un Monomial che ha come coefficiente la somma del Monomial di this con quello di q se hanno lo stesso grado
     *      poi viene agguinto ai termini di res
     *
     * [REP PRESERVATION]
     *      res.trms.size() >= 0
     *      
     * [AI PRESERVATION]
     *      this non e' modificato
     *
	 * @param q
     *
	 * @return this+q
	 */
	public Poly add(Poly q) {
        Poly res = new Poly();
        
        for (Monomial trm : trms) {
            for (Monomial other_trm : q.trms) {
                if (trm.sameDegree(other_trm)) {
                    trms.add(new Monomial(trm.coeff + other_trm.coeff, trm.degree));
                    break;
                }
            }
        }

		assert res.repOk();
		return res;
	}

	/**
     * [EFFECTS]
     *      Restituisce la differenza fra this e q
	 *
	 * @param q
	 * @return this-q
	 */
	public Poly sub(Poly q) {
		return this.add(q.minus()); 
	}

	/**
     * [EFFECTS]
     *      Restituisce il prodotto tra this e q
	 *
	 * @param q
	 * @return this*q
	 */
	public Poly mul(Poly q) {
		Poly r = new Poly(this.coeff.length + q.coeff.length - 1);
		for (int i = 0; i < this.coeff.length; i++)
			for (int j = 0; j <= q.coeff.length - 1; j++)
				r.coeff[i + j] += this.coeff[i] * q.coeff[j];

		assert r.repOk();
		return r;
	}

	/**
     * [EFFECTS]
     *      Restituisce l'opposto di this
     *
     * [OP CORRECTNESS]
     *      creo un nuovo polinomio con this.coeff.length termini
     *      res.coeff[n] = -this.coeff[n] per n = 0 ... this.coeff.length -1
	 *
	 * @return -this
	 */
	public Poly minus() {
		Poly res = new Poly(this.coeff.length);

		for (int n = 0; n < this.coeff.length; n++) {
            res.coeff[n] = -this.coeff[n];
        }

		assert res.repOk();
		return res;
	}

	/**
     * [EFFECTS]
     *      restituisce il grado del polinomio
	 *
	 * @return grado di this
	 */
	public int degree() {
		return this.coeff.length - 1;
	}

	/**
     * [EFFECTS]
     *      restituisce il coefficiente di grado d
	 * 
	 * @param d degree
	 * @return coefficiente
	 */
	public int coeff(int d) {
		return this.coeff[d];
	}

	@Override
	public String toString() {
		if (this.coeff.length == 0)
			return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.coeff.length - 1; i > 0; i--) {
            if (coeff[i] != 0) {
                stringBuilder.append(
                        String.format("%dx^%d", coeff[i], i));
            }
        }

        if (coeff[0] != 0) {
            stringBuilder.append(coeff[0]);
        }

        return stringBuilder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Poly))
			return false;
		Poly other = (Poly) o;
		return equals(other);
	}

    public boolean equals(Poly p) {
		if (p.coeff.length != this.coeff.length)
			return false;
		for (int i = 0; i < coeff.length; i++) {
			if (p.coeff[i] != this.coeff[i])
				return false;
		}
		return true;
    }

	@Override
	public int hashCode() {
		int res = 0;
		for (int i = 0; i < coeff.length; i++) {
			res += i * coeff[i];
		}

        return res;
	}

}
