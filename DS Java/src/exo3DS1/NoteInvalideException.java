package exo3DS1;

/**
 * Exception lancée lorsqu'une note est hors intervalle 0-20
 */
public class NoteInvalideException extends Exception {

    // Constructeur qui prend un message explicite
    public NoteInvalideException(String message) {
        super(message);
    }

}