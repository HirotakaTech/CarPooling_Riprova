package beans;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Feedback {

    private int id;
    private String giudizio;
    private int voto;
    private String emailMandante;
    private String emailRicevente;

    /**
     * Costruttore che consente di settare alcuni parametri della classe
     * Feedback.
     *
     * @param id id del feedback
     * @param giudizio stringa che contiene il parere di un utente verso un
     * autista o viceversa
     * @param voto valutazione di un autista rivolta ad un utente o viceversa
     */
    public Feedback(int id, String giudizio, int voto) {
        this.id = id;
        this.giudizio = giudizio;
        this.voto = voto;
    }

    /**
     * Costruttore che consente di settare alcuni parametri della classe
     * Feedback.
     *
     * @param giudizio stringa che contiene il parere di un utente verso un
     * autista o viceversa
     * @param voto valutazione di un autista rivolta ad un utente o viceversa
     * @param emailMandante email di colui che effettua la votazione
     * @param emailRicevente email di colui che riceve la valutazione
     */
    public Feedback(String giudizio, int voto, String emailMandante, String emailRicevente) {
        this.giudizio = giudizio;
        this.voto = voto;
        this.emailMandante = emailMandante;
        this.emailRicevente = emailRicevente;
    }

    /**
     * Metodo getter che consente di ottenere l'email di colui che effettua la
     * votazione.
     *
     * @return email di colui che effettua la votazione
     */
    public String getEmailMandante() {
        return emailMandante;
    }

    /**
     * Metodo setter che consente di settare l'email del mandante.
     *
     * @param emailMandante email di colui che effettua la votazione
     */
    public void setEmailMandante(String emailMandante) {
        this.emailMandante = emailMandante;
    }

    /**
     * Metodo getter che ritorna l'email del ricevente.
     *
     * @return email di colui che riceve la valutazione
     */
    public String getEmailRicevente() {
        return emailRicevente;
    }

    /**
     * Metodo setter che consente il setting dell'email del ricevente.
     *
     * @param emailRicevente email di colui che riceve la valutazione
     */
    public void setEmailRicevente(String emailRicevente) {
        this.emailRicevente = emailRicevente;
    }

    /**
     * Costruttore di default.
     */
    public Feedback() {

    }

    /**
     * Metodo che consente di ricavare l'id del Feedback.
     *
     * @return id identificativo del feedback
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo che consente di settare l'id del Feedback.
     *
     * @param id identificativo del feedback
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo che consente di ottenere il giudizio di un utente.
     *
     * @return stringa contenente l'opinione di un utente su un autista o su un
     * passeggero
     */
    public String getGiudizio() {
        return giudizio;
    }

    /**
     * Metodo che consente di impostare il giudizio di un utente.
     *
     * @param giudizio stringa contenente l'opinione di un utente su un autista
     * o su un passeggero
     */
    public void setGiudizio(String giudizio) {
        this.giudizio = giudizio;
    }

    /**
     * Metodo che consente di ottenere il voto dato dall'utente.
     *
     * @return voto dell'utente
     */
    public int getVoto() {
        return voto;
    }

    /**
     * Metodo che consente di settare il voto dell'utente.
     *
     * @param voto valutazione dell'utente
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

}
