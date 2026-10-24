
package com.apiusuarios.autenticacion.exception;

import com.apiusuarios.autenticacion.dto.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

        // Manejar los errores de validación de los datos enviados.
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ApiResponse> manejarDatosInvalidos(
                        MethodArgumentNotValidException excepcion) {

                Map<String, String> errores = new HashMap<>();

                excepcion.getBindingResult().getFieldErrors()
                                .forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(new ApiResponse(
                                                "Los datos enviados no son válidos",
                                                false,
                                                errores));
        }

        // Manejar el error cuando el correo ya está registrado.
        @ExceptionHandler(CorreoDuplicadoException.class)
        public ResponseEntity<ApiResponse> manejarCorreoDuplicado(
                        CorreoDuplicadoException excepcion) {

                return ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .body(new ApiResponse(
                                                "El usuario ya existe",
                                                false,
                                                null));
        }

        // Manejar los errores de autenticación.
        @ExceptionHandler(AutenticacionException.class)
        public ResponseEntity<ApiResponse> manejarErrorAutenticacion(
                        AutenticacionException excepcion) {

                return ResponseEntity
                                .status(HttpStatus.UNAUTHORIZED)
                                .body(new ApiResponse(
                                                "Error de autenticación",
                                                false,
                                                null));
        }

        // Manejar otros errores de datos o solicitudes incorrectas.
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ApiResponse> manejarArgumentoInvalido(
                        IllegalArgumentException excepcion) {

                return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(new ApiResponse(
                                                excepcion.getMessage(),
                                                false,
                                                null));
        }

        // Manejar errores inesperados del servidor.
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse> manejarErrorInterno(
                        Exception excepcion) {

                return ResponseEntity
                                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new ApiResponse(
                                                "Ocurrió un error interno en el servidor",
                                                false,
                                                null));
        }
}
