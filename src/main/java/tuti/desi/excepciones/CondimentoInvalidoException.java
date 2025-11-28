package tuti.desi.excepciones;

// La CLAVE para resolver el error "Unhandled exception"
// es cambiar 'extends Exception' a 'extends RuntimeException'.
// Esto la convierte en una excepción no verificada (Unchecked Exception).
public class CondimentoInvalidoException extends RuntimeException {

    public CondimentoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public CondimentoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}