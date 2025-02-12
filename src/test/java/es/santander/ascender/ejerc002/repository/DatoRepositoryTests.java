package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.Dato;
import es.santander.ascender.ejerc002.repository.DatoRepository;

@SpringBootTest
public class DatoRepositoryTests {

    @Autowired
    DatoRepository datoRepository;

    @Value(value = "${cadena}")
    private String cadena;


    @Test
    public void testList() {
        Iterable<Dato> valores = datoRepository.findAll();
        assertNotNull(valores);
    }

    @Test
    public void testFindNoExistente() {
        Optional<Dato> resultado =  datoRepository.findById(456l);
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void testLeerUno() {
        Dato datoAGuardar = new Dato(null, "Juan Antonio");

        datoRepository.save(datoAGuardar);

        Optional<Dato> resultado =  datoRepository.findById(datoAGuardar.getId());
        assertFalse(resultado.isEmpty());
    }


    @Test
    public void testCadenaNotNulo() {
        assertNotNull(cadena);
    }
}
