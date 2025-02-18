package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.Ordenador;

@SpringBootTest
public class OrdenadorRepositoryTests {

    @Autowired
    private OrdenadorRepository ordenadorRepository;

    @BeforeEach
    public void setUp() {

        ordenadorRepository.deleteAll();
    }

    @Test
    public void testList() {
        List<Ordenador> valores = ordenadorRepository.findAll();
        assertNotNull(valores, "La lista de ordenadores no debería ser nula");
    }

    @Test
    public void testFindNoExistente() {
        Optional<Ordenador> resultado = ordenadorRepository.findById(45L);
        assertTrue(resultado.isEmpty(), "El ordenador con ID 45 debería no existir");
    }

    @Test
    public void testLeerUno() {

        Ordenador datoAGuardar =  new Ordenador(null, 2.5, "120,120,120", 104);

        ordenadorRepository.save(datoAGuardar);

        assertNotNull(datoAGuardar.getId(), "El ID del ordenador debería ser generado");

        Optional<Ordenador> resultado = ordenadorRepository.findById(datoAGuardar.getId());
        assertTrue(resultado.isPresent(), "El ordenador guardado debería existir en la base de datos");
    }

    @Test
    public void testEliminar() {

        Ordenador datoAGuardar =  new Ordenador(null, 3.0, "200,200,200", 105);
        ordenadorRepository.save(datoAGuardar);

        ordenadorRepository.deleteById(datoAGuardar.getId());

        Optional<Ordenador> resultadoEliminado = ordenadorRepository.findById(datoAGuardar.getId());
        assertFalse(resultadoEliminado.isPresent(), "El ordenador debería haber sido eliminado");
    }

}