package es.santander.ascender.ejerc002.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;
import es.santander.ascender.ejerc002.repository.ColumnaArquitectonicaRepository;

@Service
public class ColumnaArquitectonicaService {

    @Autowired
    private ColumnaArquitectonicaRepository repository;

    public ColumnaArquitectonica create(ColumnaArquitectonica columnaArquitectonica) {
        if (columnaArquitectonica.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro columna utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 columnaArquitectonica.getId());
        }
        return repository.save(columnaArquitectonica);
    }

    public ColumnaArquitectonica read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<ColumnaArquitectonica> read() {
        return repository.findAll();
    }

    public ColumnaArquitectonica update(ColumnaArquitectonica columnaArquitectonica) {
        if (columnaArquitectonica.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro columna utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
            
        }
        return repository.save(columnaArquitectonica);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}
