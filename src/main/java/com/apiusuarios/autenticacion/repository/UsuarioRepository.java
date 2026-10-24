
package com.apiusuarios.autenticacion.repository;

import com.apiusuarios.autenticacion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar un usuario por su correo electrónico.
    Optional<Usuario> findByCorreo(String correo);

    // Verificar si un correo electrónico ya está registrado.
    boolean existsByCorreo(String correo);
}