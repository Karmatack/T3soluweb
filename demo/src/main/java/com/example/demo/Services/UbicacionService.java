package com.example.demo.Services;

import com.example.demo.Models.Ubicacion;
import com.example.demo.Repositories.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    // Obtener todas las ubicaciones
    public List<Ubicacion> obtenerTodas() {
        return ubicacionRepository.findAll();
    }

    // Guardar una nueva ubicación
    public Ubicacion guardar(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    // Buscar una ubicación por ID
    public Ubicacion buscarPorId(Long id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    // Eliminar una ubicación por ID
    public void eliminarPorId(Long id) {
        ubicacionRepository.deleteById(id);
    }
}
