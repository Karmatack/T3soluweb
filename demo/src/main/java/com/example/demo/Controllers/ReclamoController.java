package com.example.demo.Controllers;

import com.example.demo.Models.Reclamo;
import com.example.demo.Services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controlador REST para gestionar reclamos.
 * Proporciona endpoints para crear, obtener, buscar por ID y eliminar reclamos.
 * 
 * Endpoints:
 * 
 * POST /api/reclamos
 * - Descripción: Crea un nuevo reclamo.
 * - Ejemplo de uso en Postman:
 *   - Método: POST
 *   - URL: http://localhost:8080/api/reclamos
 *   - Body (JSON):
 *     {
 *       "tipoDocumento": { "id": 1 },
 *       "numeroDocumento": "12345678",
 *       "apellidos": "Perez",
 *       "nombres": "Juan",
 *       "ubicacion": { "id": 1 },
 *       "domicilio": "Av. Siempre Viva 123",
 *       "correo": "juan.perez@example.com",
 *       "telefono": "123456789",
 *       "celular": "987654321",
 *       "fechaHecho": "2024-11-16",
 *       "funcionario": "Funcionario A",
 *       "descripcion": "Descripción del reclamo"
 *     }
 *   - Respuesta exitosa (201 Created):
 *     {
 *       "id": 1,
 *       "tipoDocumento": { "id": 1, "nombre": "DNI" },
 *       "numeroDocumento": "12345678",
 *       "apellidos": "Perez",
 *       "nombres": "Juan",
 *       "ubicacion": { "id": 1, "departamento": "Lima", "provincia": "Lima", "distrito": "Miraflores" },
 *       "domicilio": "Av. Siempre Viva 123",
 *       "correo": "juan.perez@example.com",
 *       "telefono": "123456789",
 *       "celular": "987654321",
 *       "fechaHecho": "2024-11-16",
 *       "funcionario": "Funcionario A",
 *       "descripcion": "Descripción del reclamo"
 *     }
 * 
 * GET /api/reclamos
 * - Descripción: Obtiene todos los reclamos disponibles.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/reclamos
 *   - Respuesta exitosa:
 *     [
 *       {
 *         "id": 1,
 *         "tipoDocumento": { "id": 1, "nombre": "DNI" },
 *         "numeroDocumento": "12345678",
 *         "apellidos": "Perez",
 *         "nombres": "Juan",
 *         "ubicacion": { "id": 1, "departamento": "Lima", "provincia": "Lima", "distrito": "Miraflores" },
 *         "domicilio": "Av. Siempre Viva 123",
 *         "correo": "juan.perez@example.com",
 *         "telefono": "123456789",
 *         "celular": "987654321",
 *         "fechaHecho": "2024-11-16",
 *         "funcionario": "Funcionario A",
 *         "descripcion": "Descripción del reclamo"
 *       }
 *     ]
 * 
 * GET /api/reclamos/{id}
 * - Descripción: Obtiene un reclamo por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: GET
 *   - URL: http://localhost:8080/api/reclamos/1
 *   - Respuesta exitosa:
 *     {
 *       "id": 1,
 *       "tipoDocumento": { "id": 1, "nombre": "DNI" },
 *       "numeroDocumento": "12345678",
 *       "apellidos": "Perez",
 *       "nombres": "Juan",
 *       "ubicacion": { "id": 1, "departamento": "Lima", "provincia": "Lima", "distrito": "Miraflores" },
 *       "domicilio": "Av. Siempre Viva 123",
 *       "correo": "juan.perez@example.com",
 *       "telefono": "123456789",
 *       "celular": "987654321",
 *       "fechaHecho": "2024-11-16",
 *       "funcionario": "Funcionario A",
 *       "descripcion": "Descripción del reclamo"
 *     }
 * 
 * DELETE /api/reclamos/{id}
 * - Descripción: Elimina un reclamo por su ID.
 * - Ejemplo de uso en Postman:
 *   - Método: DELETE
 *   - URL: http://localhost:8080/api/reclamos/1
 *   - Respuesta exitosa:
 *     Reclamo eliminado con éxito
 */





@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    // Obtener todos los reclamos
    @GetMapping
    public List<Reclamo> obtenerTodos() {
        return reclamoService.obtenerTodos();
    }

    // Guardar un nuevo reclamo
    @PostMapping
    public Reclamo guardar(@RequestBody Reclamo reclamo) {
        return reclamoService.guardar(reclamo);
    }

    // Buscar un reclamo por ID
    @GetMapping("/{id}")
    public Reclamo buscarPorId(@PathVariable Long id) {
        return reclamoService.buscarPorId(id);
    }

    // Eliminar un reclamo por ID
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        reclamoService.eliminarPorId(id);
        return "Reclamo eliminado con éxito";
    }
}
