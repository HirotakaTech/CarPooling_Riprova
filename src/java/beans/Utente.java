package beans;

/**
 *
 * @author Bartelloni-Bellezza-Niccolai F.
 */
public class Utente {

    protected String email;
    protected String password;
    protected String nome;
    protected String cognome;
    protected String data_nascita;
    protected String luogo;
    protected String telefono;

    /**
     * Metodo costruttore per inizializzare tutti i parametri di utente.
     *
     * @param email email dell'utente
     * @param password password dell'utente utilizzata per accedere al sito
     * @param nome nome dell'utente
     * @param cognome cognome dell'utente
     * @param data_nascita data della nascita dell'utente
     * @param luogo luogo dove è nato
     * @param telefono numero di telefono (MAX 10 cifre)
     */
    public Utente(String email, String password, String nome, String cognome,
            String data_nascita, String luogo, String telefono) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
        this.luogo = luogo;
        this.telefono = telefono;
    }

    /**
     * Metodo costruttore di utente.
     */
    public Utente() {
        email = "";
        password = "";
        nome = "";
        cognome = "";
        luogo = "";
        telefono = "";
        data_nascita = "";
    }

    /**
     * Metodo getter per l'email.
     *
     * @return email dell'utente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo setter per l'email.
     *
     * @param email email dell'utente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo per ottenere la password dell'utente.
     *
     * @return password dell'utente
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo per settare la password dell'utente.
     *
     * @param password password per l'accesso utilizzata dall'utente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo per ottenere il nome dell'utente.
     *
     * @return nome dell'utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo setter per l'impostazione del nome.
     *
     * @param nome stringa relativa al nome dell'utente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo getter per il cognome dell'utente.
     *
     * @return stringa contenente il cognome dell'utente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo setter che consente di impostare il cognome dell'utente.
     *
     * @param cognome cognome dell'utente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Metodo getter per la data di nascita.
     *
     * @return data di nascita dell'utente
     */
    public String getData_nascita() {
        return data_nascita;
    }

    /**
     * Metodo setter per la data di nascita.
     *
     * @param data_nascita data di nascita dell'utente
     */
    public void setData_nascita(String data_nascita) {
        this.data_nascita = data_nascita;
    }

    /**
     * Metodo getter per il luogo di nascita.
     *
     * @return luogo di nascita dell'utente
     */
    public String getLuogo() {
        return luogo;
    }

    /**
     * Metodo setter per l'impostazione del luogo di nascita dell'utente.
     *
     * @param luogo città di nascita dell'utente
     */
    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    /**
     * Metodo getter per ottenere il numero di telefono dell'utente.
     *
     * @return numero di telefono dell'utente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo setter per l'impostazione del numero di telefono dell'utente.
     *
     * @param telefono numero di telefono dell'utente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
