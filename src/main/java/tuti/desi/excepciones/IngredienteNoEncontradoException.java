package tuti.desi.excepciones;

// RuntimeException es ideal para errores que la aplicación no espera
// recuperarse, permitiendo a Spring manejar la transacción y el error.
public class IngredienteNoEncontradoException extends RuntimeException {

    // Constructor que acepta un mensaje de error
    public IngredienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    // Opcional: Constructor que acepta un mensaje y la causa original
    public IngredienteNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}