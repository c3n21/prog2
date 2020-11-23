/**
[OVERVIEW]
    Le istante di questa classe rappresentano code di interi
    Gli oggetti di questo tipo sono mutabili.
    Una coda tipica è [x1, x2, ..., xk], con k <= dimensione
    Dato che è una struttura FIFO,
    a seguito di una enqueue dell'elemento y si otterrà [x1, x2 ..., xk]
    a seguito di una dequeue si otterrà [x2, ..., xk]
 */

public class IntQueue {
/*
    [CAMPI]
 */
 //Struttura dati che contiene gli elementi della IntQueue
    final private int[] elements;
/*
    Gli indici della testa e della coda della IntQueue this.
    Head indica il primo elemento di this (-1 se la coda è vuota)
    Tail indica l'indice della prima posizione disponibile (tail == head)
 */
    private int head = 0, tail = 1;
/*
    [SPECIFICAZIONI]
    Funzione di astrazione:
        AF(elements, head, tail) =
        = [ elements[i] | head <= i < tail] =
        = [] se head == -1 e tail == 0
        = [...] se la coda è piena 
        = [elements[head], elements[head+1], ..., elements[size-1]] se tail < head
    Invariante di rappresentazione: 
        la coda non contiene più elementi della sua capienza massima

        -1 <= head < elements.size-1
        0 <= tail < elements.size-1
        head == -1 => tail == 0
 */
 
/*
    [COSTRUTTORI]
    
        [Pre-condizioni]
            n >= 0
        [Post-condizioni]
            inizializza this affinché rappresenti una coda vuota di dimensione massima n
 */
    public IntQueue(int n) {
        head = 1;
    }

/*
    [METODI]

 */

/*
    [Effetti collaterali]
        potrebbe modificare this
    [Post-condizioni]
        se la coda è piena solleva un'eccezione di tipo FullException,
        mentre aggiunge n alla coda (meglio essere meno specifici)
        this = [x1, x2 ... xk]
 */
    void enqueue(int n) {
        elements[tail++] = n;
        tail = tail % elements.length;
    }

/*
    [Effetti collaterali]
        potrebbe modificare this
    [Post-condizioni]
        se la coda non è vuota restituisce l'elemento in testa e lo elimina da this;
        sollva un'eccezione di tipo EmptyException se la coda è vuota
        this = [x1, x2 ... xk]
 */
    public int dequeue() {
        if (this.isEmpty()) {
            throw new EmptyQueueException("Impossibile estrarre elemento. Coda vuota");
        }

        int r = elements[head];
        head = (head + 1) % elements.length;
        if (head == tail) {
            head = -1;
            tail = 0;
        }
        return r;
    }

/*
    Post-condizioni:
        restituisce true se la coda è piena, false altrimenti
 */

    public boolean isFull() {
        return head == tail;
    }

/*
    Post-condizioni:
        restituisce true se la coda è vuota, false altrimenti
 */

    public boolean isEmpty() {
        return head == -1;
    }

    

    /*
        Post-condizioni: implementa la funzione di astrazione
     */

    public int size() {
        if (isEmpty()) return 0;
        if (isFull()) return elements.length;
        return (tail - head + elements.length) % elements.length;
    }

    private boolean repOK() {

    }

    @Override
    public String toString() {
        String r = "IntQueue : [";

        if (!this.isEmpty()) {

        }

        return r + "]";
    }
}
