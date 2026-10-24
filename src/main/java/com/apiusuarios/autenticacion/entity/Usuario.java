
package com.apiusuarios.autenticacion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indica que esta clase representa una entidad de la base de datos.
@Entity

// Define el nombre de la tabla donde se almacenarán los usuarios.
@Table(name = "usuarios")
public class Usuario {

    // Identificador único de cada usuario.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del usuario.
    @Column(nullable = false, length = 100)
    private String nombre;

    // Apellido del usuario.
    @Column(nullable = false, length = 100)
    private String apellido;

    // Correo electrónico único de cada usuario.
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    // Contraseña almacenada mediante un hash seguro, no en texto plano.
    @Column(nullable = false)
    private String password;

    // Constructor vacío requerido por JPA.
    public Usuario() {
    }

    // Constructor para crear un usuario con sus datos.
    public Usuario(String nombre, String apellido, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }

    // Obtiene el identificador del usuario.
    public Long getId() {
        return id;
    }

    // Obtiene el nombre.
    public String getNombre() {
        return nombre;
    }

    // Modifica el nombre.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtiene el apellido.
    public String getApellido() {
        return apellido;
    }

    // Modifica el apellido.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Obtiene el correo electrónico.
    public String getCorreo() {
        return correo;
    }

    // Modifica el correo electrónico.
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Obtiene la contraseña.
    public String getPassword() {
        return password;
    }

    // Modifica la contraseña.
    public void setPassword(String password) {
        this.password = password;
    }
}