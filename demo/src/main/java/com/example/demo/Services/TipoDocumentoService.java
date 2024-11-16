package com.example.demo.Services;

import com.example.demo.Models.TipoDocumento;
import com.example.demo.Repositories.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    // Obtener todos los tipos de documento
    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoRepository.findAll();
    }

    // Guardar un nuevo tipo de documento
    public TipoDocumento guardar(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    // Buscar un tipo de documento por ID
    public TipoDocumento buscarPorId(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(null);
    }

    // Eliminar un tipo de documento por ID
    public void eliminarPorId(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}
