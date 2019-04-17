package beans;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Passeggero extends Utente{
    
    private String documento;
    /**
     * Costruttore del passeggero.
     * @param documento documento del passeggero (carta di identità)
     */
    public Passeggero(String documento){
        this.documento = documento;
    }
    /**
     * Metodo getter che ritorna il documento (carta di identità).
     * @return numero della carta di identità
     */
    public String getDocumento() {
        return documento;
    }
    /**
     * Metodo setter che setta il documento.
     * @param documento numero della carta di identità
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
    
}
