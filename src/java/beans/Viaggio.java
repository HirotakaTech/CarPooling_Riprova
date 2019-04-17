package beans;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Viaggio {
    
    private int id;
    private String citta_partenza;
    private String citta_destinazione;
    private String data_partenza;
    private String ora_partenza;
    private float prezzo;
    private String tempi_stimati;//(In ore)
    private String info_aggiuntive;
    private String email_autista;
    /**
     * Costruttore per i viaggi.
     * @param id id del viaggio
     * @param citta_partenza città di partenza
     * @param citta_destinazione città di arrivo
     * @param data_partenza data di partenza
     * @param ora_partenza ora di partenza
     * @param prezzo prezzo di partenza
     * @param tempi_stimati tempi stimati per raggiungere la destinazione
     * @param info_aggiuntive informazioni aggiuntive
     * @param email_autista email dell'autista
     */
    public Viaggio(int id, String citta_partenza, String citta_destinazione, String data_partenza, String ora_partenza, float prezzo, String tempi_stimati, String info_aggiuntive, String email_autista) {
        this.id = id;
        this.citta_partenza = citta_partenza;
        this.citta_destinazione = citta_destinazione;
        this.data_partenza = data_partenza;
        this.ora_partenza = ora_partenza;
        this.prezzo = prezzo;
        this.tempi_stimati = tempi_stimati;
        this.info_aggiuntive = info_aggiuntive;
        this.email_autista = email_autista;
    }
/**
     * Costruttore per i viaggi.
     * @param citta_partenza città di partenza
     * @param citta_destinazione città di arrivo
     * @param data_partenza data di partenza
     * @param ora_partenza ora di partenza
     * @param prezzo prezzo di partenza
     * @param tempi_stimati tempi stimati per raggiungere la destinazione
     * @param info_aggiuntive informazioni aggiuntive
     * @param email_autista email dell'autista
     */
    public Viaggio(String citta_partenza, String citta_destinazione, String data_partenza, String ora_partenza, float prezzo, String tempi_stimati, String info_aggiuntive, String email_autista) {
        this.citta_partenza = citta_partenza;
        this.citta_destinazione = citta_destinazione;
        this.data_partenza = data_partenza;
        this.ora_partenza = ora_partenza;
        this.prezzo = prezzo;
        this.tempi_stimati = tempi_stimati;
        this.info_aggiuntive = info_aggiuntive;
        this.email_autista = email_autista;
    }
    /**
     * Costruttore di default.
     */
    public Viaggio() {
    }
    /**
     * Metodo getter per ottenere l'id del viaggio.
     * @return id identificativo del viaggio
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo setter per l'impostazione dell'id.
     * @param id identificatore del viaggio
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Metodo getter per ottenere la città di partenza.
     * @return città di partenza
     */
    public String getCitta_partenza() {
        return citta_partenza;
    }
    /**
     * Metodo setter per l'impostazione della città di partenza.
     * @param citta_partenza città di partenza per il viaggio
     */
    public void setCitta_partenza(String citta_partenza) {
        this.citta_partenza = citta_partenza;
    }
    /**
     * Metodo getter per ottenere la città di destinazione.
     * @return città di destinazione del viaggio
     */
    public String getCitta_destinazione() {
        return citta_destinazione;
    }
    /**
     * Metodo setter per impostare la città di arrivo del viaggio.
     * @param citta_destinazione città di destinazione del viaggio
     */
    public void setCitta_destinazione(String citta_destinazione) {
        this.citta_destinazione = citta_destinazione;
    }
    /**
     * Metodo getter per ottenere la data di partenza del viaggio.
     * @return data della partenza del viaggio
     */
    public String getData_partenza() {
        return data_partenza;
    }
    /**
     * Metodo setter che imposta la data di partenza del viaggio.
     * @param data_partenza data di partenza del viaggio
     */
    public void setData_partenza(String data_partenza) {
        this.data_partenza = data_partenza;
    }
    /**
     * Metodo getter che consente di ottenere l'orario di partenza.
     * @return orario di partenza del viaggio
     */
    public String getOra_partenza() {
        return ora_partenza;
    }
    /**
     * Metodo setter che consente di settare l'ora di partenza del viaggio.
     * @param ora_partenza ora di partenza del viaggio
     */
    public void setOra_partenza(String ora_partenza) {
        this.ora_partenza = ora_partenza;
    }
    /**
     * Metodo getter che consente di ottenere il prezzo per quel viaggio.
     * @return prezzo del viaggio
     */
    public float getPrezzo() {
        return prezzo;
    }
    /**
     * Metodo setter che consente di impostare il prezzo del tragitto.
     * @param prezzo prezzo del viaggio
     */
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    /**
     * Metodo getter che permette di ottenere le tempistiche del viaggio previste.
     * @return tempo in ore e minuti per il raggiungimento della meta prefissata
     */
    public String getTempi_stimati() {
        return tempi_stimati;
    }
    /**
     * Metodo setter che consente di settare le tempistiche del viaggio previste.
     * @param tempi_stimati tempo in ore e minuti per il raggiungimento della meta prefissata 
     */
    public void setTempi_stimati(String tempi_stimati) {
        this.tempi_stimati = tempi_stimati;
    }
    /**
     * Metodo getter che ci consente di ottenere le informazioni aggiuntive sul viaggio.
     * @return informazioni del viaggio aggiuntive inserite da un autista
     */
    public String getInfo_aggiuntive() {
        return info_aggiuntive;
    }
    /**
     * Metodo setter che consente di settare le informazioni inerenti ad un viaggio.
     * @param info_aggiuntive informazioni aggiuntive inserite da un autista
     */
    public void setInfo_aggiuntive(String info_aggiuntive) {
        this.info_aggiuntive = info_aggiuntive;
    }
    /**
     * Metodo getter che consente di ottenere l'email dell'autista di un determinato viaggio.
     * @return email dell'autista associato ad un viaggio
     */
    public String getEmail_autista() {
        return email_autista;
    }
    /**
     * Metodo setter che permette di impostare l'email dell'autista di un determinato viaggio.
     * @param email_autista email dell'autista associato ad un viaggio
     */
    public void setEmail_autista(String email_autista) {
        this.email_autista = email_autista;
    }

    
    
}
