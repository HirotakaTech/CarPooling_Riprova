package exceptions;

/**
 * Classe che rappresenta un'eccezione che lancia il programma
 * @author Bartelloni-Bellezza-NiccolaiF
 */
public class EccezioneDati extends RuntimeException {

    /**
     * Costruttore della classe
     * @param string Messaggio di errore
     */
    public EccezioneDati(String string) {
        super(string);
    }

}
