package Prueba.Tecnica.Supermercado.Java.Spring.Boot.Exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
