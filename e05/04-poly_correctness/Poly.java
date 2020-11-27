import java.util.Arrays;

/**
 * Questa classe rappresenta un polinomio di grado n (si assume che il grado sia >= 0).
 * Sono oggetti immutabili e le operazioni disponibili sono: 
 */
public class Poly {
	private final int[] coeff;

	/*
     * [ABS FUN]
	 *      AF(coeff) = polinomio:
     *      coeff[coeff.length-1]x^(coeff.length-1) + ... + coeff[1]x + coeff[0] or
	 *      AF(coeff) = 0 if coeff.length = 0.
     * 
     * [REP INV]
     *      coeff non deve essere null, e l'ultimo elemento non può essere 0.
	 */

    /**
     *[CONSTRUCTOR]
     */

	private Poly(int n) {
		this.coeff = new int[n];
	}

	/**
     * [EFFECTS]
     *      creazione polinomio zero
	 */
	public Poly() {
		this.coeff = new int[0]; 
	}

	/**
     * [EFFECTS]
     *      costruisce un monomio
     *
     * [OP CORRECTNESS]
     *      se c == 0: coeff.length := 0
     *      se c > 0: coeff.length := n+1 && coeff[coeff.length-1] = c;
     *
	 * @param c coefficiente
	 * @param n esponente
     *
	 * @throws NegativeExponentException se n < 0
	 */
	public Poly(int c, int n) {
		if (n < 0)
			throw new NegativeExponentException("[Poly] Grado negativo");

		if (c == 0) {
			this.coeff = new int[0]; 
		} else {
            this.coeff = new int[n + 1];
            this.coeff[n] = c; 
        }

		assert repOk();
	}

	public boolean repOk() {
		return coeff != null && coeff[coeff.length - 1] != 0;
	}

	/**
	 * [EFFECTS]
     *      restituisce un polinomio risultato della somma tra this e q
     *
     * [OP CORRECTNESS]
	 *      se this e q hanno lo stesso grado, allora verifico se il polinomio risultate dalla somma dei due termini sia != 0, se non lo è
     *      posso creare un polinomio di grado minore (new_deg).
     *
     *      creo un nuovo polinomio res di grado new_deg + 1 (ho i termini da x^1 fino a x^new_deg e +1 per il termine noto)
     *      res.coeff[i] = this.coeff[i] + q.coeff[i] con i:= 0 ... small.length -1 (perché altrimenti va out of bounds)
     *      e dopo per i := small.coeff.length - 1  < large.length copio i rimanenti termini di large dato che i coeff di small sono 
     *      già terminati
     *
     * [REP PRESERVATION]
     *      res.coeff.length è almeno 0
     *      
     * [AI PRESERVATION]
     *      this non è modificato
     *
	 * @param q
     *
	 * @return this+q
	 */
	public Poly add(Poly q) {
		Poly large, small;
		if (this.coeff.length > q.coeff.length) {
			large = this;
			small = q;
		} else {
			large = q;
			small = this;
		}

		int new_deg = large.coeff.length - 1;

		if (this.coeff.length == q.coeff.length) { //determino il grado del nuovo polinomio
            for (; new_deg >= 0; new_deg--) {
                if (small.coeff[new_deg] + large.coeff[new_deg] != 0) {
                    break;
                }
            }
        }

		Poly res = new Poly(new_deg + 1); //sommo il coefficiente di ogni termine dei due polinomi

		for (int i = 0; i < small.coeff.length && i <= new_deg; i++) 
			res.coeff[i] = small.coeff[i] + large.coeff[i];

		for (int i = small.coeff.length - 1; j <= new_deg; j++) 
			res.coeff[j] = large.coeff[j];

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
