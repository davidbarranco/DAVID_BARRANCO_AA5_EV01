
package com.apiusuarios.autenticacion.service;

import com.apiusuarios.autenticacion.dto.RegistroRequest;
import com.apiusuarios.autenticacion.entity.Usuario;
import com.apiusuarios.autenticacion.exception.CorreoDuplicadoException;
import com.apiusuarios.autenticacion.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor para inyectar las dependencias necesarias.
    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registrar un usuario nuevo.
    @Transactional
    public Usuario registrarUsuario(RegistroRequest solicitud) {

        // Comprobar si el correo ya está registrado.
        if (usuarioRepository.existsByCorreo(solicitud.getCorreo())) {
            throw new CorreoDuplicadoException("El usuario ya existe");
        }

        // Crear el usuario con la contraseña cifrada.
        Usuario usuario = new Usuario(
                solicitud.getNombre(),
                solicitud.getApellido(),
                solicitud.getCorreo(),
                passwordEncoder.encode(solicitud.getPassword()));

        // Guardar el usuario en la base de datos.
        return usuarioRepository.save(usuario);
    }
}
