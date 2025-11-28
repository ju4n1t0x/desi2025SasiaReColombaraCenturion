package tuti.desi.excepciones;

public class ProductoInvalidoException extends RuntimeException {

    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }

    public ProductoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}