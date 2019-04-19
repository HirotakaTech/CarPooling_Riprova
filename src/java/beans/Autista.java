package beans;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Autista extends Utente {

    private int numero_posti;
    private String data_scadenza_patente;
    private String foto; //URL
    private String numero_patente;
    private String targa_auto;
    private String modello_auto;

    /**
     * Costruttore che serve ad inizializzare tutti i parametri dell'autista.
     *
     * @param numero_posti numero dei posti della sua vettura
     * @param data_scadenza_patente data della scadenza della patente
     * dell'autista
     * @param foto url della foto dell'autista
     * @param numero_patente numero della patente dell'autista
     * @param targa_auto targa dell'auto
     * @param modello_auto modello dell'auto
     */
    public Autista(int numero_posti, String data_scadenza_patente, String foto, String numero_patente, String targa_auto, String modello_auto) {
        this.numero_posti = numero_posti;
        this.data_scadenza_patente = data_scadenza_patente;
        this.foto = foto;
        this.numero_patente = numero_patente;
        this.targa_auto = targa_auto;
        this.modello_auto = modello_auto;
    }

    /**
     * Costruttore di default.
     */
    public Autista() {

    }

    /**
     * Metodo getter per il numero dei posti.
     *
     * @return numero dei posti massimi che l'autista può trasportare
     */
    public int getNumero_posti() {
        return numero_posti;
    }

    /**
     * Metodo setter che consente di impostare il numero dei posti massimi
     * dell'auto.
     *
     * @param numero_posti numero dei posti massimi che l'autista può
     * trasportare
     */
    public void setNumero_posti(int numero_posti) {
        this.numero_posti = numero_posti;
    }

    /**
     * Metodo getter che ritorna la data della scadenza della patente
     * dell'autista.
     *
     * @return data della scadenza della patente
     */
    public String getData_scadenza_patente() {
        return data_scadenza_patente;
    }

    /**
     * Metodo setter che imposta la data della scadenza della patente
     * dell'autista.
     *
     * @param data_scadenza_patente data della scadenza della patente di guida
     */
    public void setData_scadenza_patente(String data_scadenza_patente) {
        this.data_scadenza_patente = data_scadenza_patente;
    }

    /**
     * Metodo getter che consente di ottenere l'url della foto dell'autista.
     *
     * @return path della foto dell'autista
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Metodo setter che consente di impostare l'url della foto dell'autista.
     *
     * @param foto path della foto dell'autista
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Metodo getter che ritorna il numero della patente dell'autista.
     *
     * @return numero della patente dell'autista
     */
    public String getNumero_patente() {
        return numero_patente;
    }

    /**
     * Metodo setter che consente di settare il numero della patente.
     *
     * @param numero_patente numero della patente dell'autista
     */
    public void setNumero_patente(String numero_patente) {
        this.numero_patente = numero_patente;
    }

    /**
     * Metodo getter per la targa dell'auto.
     *
     * @return targa dell'auto dell'autista
     */
    public String getTarga_auto() {
        return targa_auto;
    }

    /**
     * Metodo setter che consente di settare la targa dell'auto.
     *
     * @param targa_auto targa dell'autista
     */
    public void setTarga_auto(String targa_auto) {
        this.targa_auto = targa_auto;
    }

    /**
     * Metodo getter per il modello dell'auto
     *
     * @return modello dell'auto guidata dall'autista
     */
    public String getModello_auto() {
        return modello_auto;
    }

    /**
     * Metodo setter che consente di settare il modello dell'auto.
     *
     * @param modello_auto modello dell'auto utilizzata dall'autista
     */
    public void setModello_auto(String modello_auto) {
        this.modello_auto = modello_auto;
    }

}
