package beans;

/**
 *
 * @author Bartelloni-Bellezza
 */
public class Feedback {
    
    private int id;
    private String giudizio;
    private float voto;

    public Feedback(int id, String giudizio, float voto) {
        this.id = id;
        this.giudizio = giudizio;
        this.voto = voto;
    }
    
    public Feedback(){
        
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

    public float getVoto() {
        return voto;
    }

    public void setVoto(float voto) {
        this.voto = voto;
    }
    
    
    
}
