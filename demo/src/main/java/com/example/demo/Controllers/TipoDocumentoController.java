package com.example.demo.Controllers;

import com.example.demo.Models.TipoDocumento;
import com.example.demo.Services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar los tipos de documento.
 * Proporciona endpoints para crear, obtener, buscar por ID y eliminar tipos de documento.
 * 
 * Endpoints:
 * 
 * POST /api/tipo-documento
 * - Descripción: Crea un nuevo tipo de documento.
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/api/tipo-documento
 *   - Body (JSON):
 *     {
 *       "nombre": "DNI"
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "id": 1,
 *       "nombre": "DNI"
 *     }
 * 
 * GET /api/tipo-documento
 * - Descripción: Obtiene todos los tipos de documento disponibles.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/tipo-documento
 *   - Respuesta exitosa:
 *     [
 *       {
 *         "id": 1,
 *         "nombre": "DNI"
 *       },
 *       {
 *         "id": 2,
 *         "nombre": "Pasaporte"
 *       }
 *     ]
 * 
 * GET /api/tipo-documento/{id}
 * - Descripción: Obtiene un tipo de documento por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/tipo-documento/1
 *   - Respuesta exitosa:
 *     {
 *       "id": 1,
 *       "nombre": "DNI"
 *     }
 * 
 * DELETE /api/tipo-documento/{id}
 * - Descripción: Elimina un tipo de documento por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/api/tipo-documento/1
 *   - Respuesta exitosa:
 *     Tipo de documento eliminado con éxito
 */







@RestController
@RequestMapping("/api/tipo-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    // Obtener todos los tipos de documento
    @GetMapping
    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoService.obtenerTodos();
    }

    // Guardar un nuevo tipo de documento
    @PostMapping
    public TipoDocumento guardar(@RequestBody TipoDocumento tipoDocumento) {
        return tipoDocumentoService.guardar(tipoDocumento);
    }

    // Buscar un tipo de documento por ID
    @GetMapping("/{id}")
    public TipoDocumento buscarPorId(@PathVariable Long id) {
        return tipoDocumentoService.buscarPorId(id);
    }

    // Eliminar un tipo de documento por ID
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        tipoDocumentoService.eliminarPorId(id);
        return "Tipo de documento eliminado con éxito";
    }
}
