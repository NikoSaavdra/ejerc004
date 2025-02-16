package es.santander.ascender.ejerc002.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejerc002.model.Boligrafo;
import es.santander.ascender.ejerc002.repository.BoligrafoRepository;

@Service
public class BoligrafoService {

    @Autowired
    private BoligrafoRepository repository;

    public Boligrafo create(Boligrafo columnaBoligrafo) {
        if (columnaBoligrafo.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro columna utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 columnaBoligrafo.getId());
        }
        return repository.save(columnaBoligrafo);
    }

    public Boligrafo read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Boligrafo> read() {
        return repository.findAll();
    }

    public Boligrafo update(Boligrafo columnaBoligrafo) {
        if (columnaBoligrafo.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro columna utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
            
        }
        return repository.save(columnaBoligrafo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}
