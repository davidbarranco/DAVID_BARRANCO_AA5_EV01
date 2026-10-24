
package com.apiusuarios.autenticacion.exception;

// Excepción para indicar que un correo ya está registrado.
public class CorreoDuplicadoException extends RuntimeException {

    public CorreoDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
