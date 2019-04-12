package beans;

/**
 *
 * @author Bartelloni-Bellezza
 */
public class Feedback {

    private int id;
    private String giudizio;
    private int voto;
    private String emailMandante;
    private String emailRicevente;

    public Feedback(int id, String giudizio, int voto) {
        this.id = id;
        this.giudizio = giudizio;
        this.voto = voto;
    }

    public Feedback(String giudizio, int voto, String emailMandante, String emailRicevente) {
        this.giudizio = giudizio;
        this.voto = voto;
        this.emailMandante = emailMandante;
        this.emailRicevente = emailRicevente;
    }

    public String getEmailMandante() {
        return emailMandante;
    }

    public void setEmailMandante(String emailMandante) {
        this.emailMandante = emailMandante;
    }

   

    public String getEmailRicevente() {
        return emailRicevente;
    }

    public void setEmailRicevente(String emailRicevente) {
        this.emailRicevente = emailRicevente;
    }

    public Feedback() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiudizio() {
        return giudizio;
    }

    public void setGiudizio(String giudizio) {
        this.giudizio = giudizio;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

}
