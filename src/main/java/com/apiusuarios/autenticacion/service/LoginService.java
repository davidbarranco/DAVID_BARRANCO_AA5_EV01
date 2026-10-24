
package com.apiusuarios.autenticacion.service;

import com.apiusuarios.autenticacion.dto.LoginRequest;
import com.apiusuarios.autenticacion.entity.Usuario;
import com.apiusuarios.autenticacion.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.apiusuarios.autenticacion.exception.AutenticacionException;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Inyectar las dependencias necesarias.
    public LoginService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Validar las credenciales del usuario.
    public Usuario autenticarUsuario(LoginRequest solicitud) {

        // Buscar al usuario por su correo electrónico.
        Usuario usuario = usuarioRepository
                .findByCorreo(solicitud.getCorreo())
                .orElseThrow(() -> new AutenticacionException(
                        "Correo electrónico o contraseña incorrectos"));

        // Comparar la contraseña recibida con la contraseña cifrada.
        if (!passwordEncoder.matches(
                solicitud.getPassword(),
                usuario.getPassword())) {

            throw new AutenticacionException(
                    "Correo electrónico o contraseña incorrectos");
        }

        // Devolver el usuario autenticado.
        return usuario;
    }
}
