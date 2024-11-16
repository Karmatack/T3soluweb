package com.example.demo.Controllers;

import com.example.demo.Models.Ubicacion;
import com.example.demo.Services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las ubicaciones.
 * Proporciona endpoints para crear, obtener, buscar por ID y eliminar ubicaciones.
 * 
 * Endpoints:
 * 
 * POST /api/ubicaciones
 * - Descripción: Crea una nueva ubicación (departamento, provincia, distrito).
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/api/ubicaciones
 *   - Body (JSON):
 *     {
 *       "departamento": "Lima",
 *       "provincia": "Lima",
 *       "distrito": "Miraflores"
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "id": 1,
 *       "departamento": "Lima",
 *       "provincia": "Lima",
 *       "distrito": "Miraflores"
 *     }
 * 
 * GET /api/ubicaciones
 * - Descripción: Obtiene todas las ubicaciones disponibles.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/ubicaciones
 *   - Respuesta exitosa:
 *     [
 *       {
 *         "id": 1,
 *         "departamento": "Lima",
 *         "provincia": "Lima",
 *         "distrito": "Miraflores"
 *       },
 *       {
 *         "id": 2,
 *         "departamento": "Cusco",
 *         "provincia": "Cusco",
 *         "distrito": "Wanchaq"
 *       }
 *     ]
 * 
 * GET /api/ubicaciones/{id}
 * - Descripción: Obtiene una ubicación por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/ubicaciones/1
 *   - Respuesta exitosa:
 *     {
 *       "id": 1,
 *       "departamento": "Lima",
 *       "provincia": "Lima",
 *       "distrito": "Miraflores"
 *     }
 * 
 * DELETE /api/ubicaciones/{id}
 * - Descripción: Elimina una ubicación por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/api/ubicaciones/1
 *   - Respuesta exitosa:
 *     Ubicación eliminada con éxito
 */



@RestController
@RequestMapping("/api/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    // Obtener todas las ubicaciones
    @GetMapping
    public List<Ubicacion> obtenerTodas() {
        return ubicacionService.obtenerTodas();
    }

    // Guardar una nueva ubicación
    @PostMapping
    public Ubicacion guardar(@RequestBody Ubicacion ubicacion) {
        return ubicacionService.guardar(ubicacion);
    }

    // Buscar una ubicación por ID
    @GetMapping("/{id}")
    public Ubicacion buscarPorId(@PathVariable Long id) {
        return ubicacionService.buscarPorId(id);
    }

    // Eliminar una ubicación por ID
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        ubicacionService.eliminarPorId(id);
        return "Ubicación eliminada con éxito";
    }
}
