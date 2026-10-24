
package com.apiusuarios.autenticacion.controller;

import com.apiusuarios.autenticacion.dto.ApiResponse;
import com.apiusuarios.autenticacion.dto.LoginRequest;
import com.apiusuarios.autenticacion.dto.RegistroRequest;
import com.apiusuarios.autenticacion.entity.Usuario;
import com.apiusuarios.autenticacion.service.LoginService;
import com.apiusuarios.autenticacion.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        private final UsuarioService usuarioService;
        private final LoginService loginService;

        // Inyectar los servicios necesarios.
        public UsuarioController(
                        UsuarioService usuarioService,
                        LoginService loginService) {
                this.usuarioService = usuarioService;
                this.loginService = loginService;
        }

        // Endpoint para registrar un usuario.
        @PostMapping("/registro")
        public ResponseEntity<ApiResponse> registrarUsuario(
                        @Valid @RequestBody RegistroRequest solicitud) {

                Usuario usuario = usuarioService.registrarUsuario(solicitud);

                // No devolver la contraseña en la respuesta.
                usuario.setPassword(null);

                ApiResponse respuesta = new ApiResponse(
                                "Usuario registrado correctamente",
                                true,
                                usuario);

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(respuesta);
        }

        // Endpoint para iniciar sesión.
        @PostMapping("/login")
        public ResponseEntity<ApiResponse> iniciarSesion(
                        @Valid @RequestBody LoginRequest solicitud) {

                Usuario usuario = loginService.autenticarUsuario(solicitud);

                // No devolver la contraseña en la respuesta.
                usuario.setPassword(null);

                ApiResponse respuesta = new ApiResponse(
                                "Autenticación satisfactoria",
                                true,
                                usuario);

                return ResponseEntity.ok(respuesta);
        }
}
