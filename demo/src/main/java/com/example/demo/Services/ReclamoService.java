package com.example.demo.Services;

import com.example.demo.Models.Reclamo;
import com.example.demo.Repositories.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    // Obtener todos los reclamos
    public List<Reclamo> obtenerTodos() {
        return reclamoRepository.findAll();
    }

    // Guardar un nuevo reclamo
    public Reclamo guardar(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    // Buscar un reclamo por ID
    public Reclamo buscarPorId(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    // Eliminar un reclamo por ID
    public void eliminarPorId(Long id) {
        reclamoRepository.deleteById(id);
    }
}
