package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import es.santander.ascender.ejerc002.model.ColumnaArquitectonica;

@SpringBootTest
public class ColumnaArquitectonicaRepositoryTest {

    @Autowired
    private ColumnaArquitectonicaRepository repository;

    @Test
    public void testCreate() {
        ColumnaArquitectonica columnaArquitectonica = new ColumnaArquitectonica();
        columnaArquitectonica.setA2(5l);


        repository.save(columnaArquitectonica);

        assertTrue(
            repository
                .findById(columnaArquitectonica.getId())
                .isPresent());
    }

}
