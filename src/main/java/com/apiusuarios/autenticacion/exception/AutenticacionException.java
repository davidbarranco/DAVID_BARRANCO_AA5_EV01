
package com.apiusuarios.autenticacion.exception;

// Excepción específica para errores de autenticación.
public class AutenticacionException extends RuntimeException {

    public AutenticacionException(String mensaje) {
        super(mensaje);
    }
}
