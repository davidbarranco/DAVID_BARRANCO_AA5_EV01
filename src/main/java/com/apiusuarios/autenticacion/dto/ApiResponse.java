
package com.apiusuarios.autenticacion.dto;

public class ApiResponse {

    private String mensaje;
    private boolean exitoso;
    private Object datos;

    public ApiResponse() {
    }

    public ApiResponse(String mensaje, boolean exitoso, Object datos) {
        this.mensaje = mensaje;
        this.exitoso = exitoso;
        this.datos = datos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }
}