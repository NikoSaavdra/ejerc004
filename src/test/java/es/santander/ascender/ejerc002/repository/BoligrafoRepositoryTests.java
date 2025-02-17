package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.Boligrafo;

@SpringBootTest
public class BoligrafoRepositoryTests {

    @Autowired
    private BoligrafoRepository boligrafoRepository;

    @BeforeEach
    public void setUp() {

        boligrafoRepository.deleteAll();
    }

    @Test
    public void testList() {
        Iterable<Boligrafo> valores = boligrafoRepository.findAll();
        assertNotNull(valores, "La lista de boligrafos no debería ser nula");
    }

    @Test
    public void testFindNoExistente() {
        Optional<Boligrafo> resultado = boligrafoRepository.findById(45L);
        assertTrue(resultado.isEmpty(), "El boligrafo con ID 45 debería no existir");
    }

    @Test
    public void testLeerUno() {

        Boligrafo datoAGuardar = new Boligrafo(null, "Boli", "Rojo", true);

        boligrafoRepository.save(datoAGuardar);

        assertNotNull(datoAGuardar.getId(), "El ID del boligrafo debería ser generado");

        Optional<Boligrafo> resultado = boligrafoRepository.findById(datoAGuardar.getId());
        assertTrue(resultado.isPresent(), "El boligrafo guardado debería existir en la base de datos");
    }

    @Test
    public void testEliminar() {

        Boligrafo datoAGuardar = new Boligrafo(null, "Boli", "Verde", true);
        boligrafoRepository.save(datoAGuardar);

        boligrafoRepository.deleteById(datoAGuardar.getId());

        Optional<Boligrafo> resultadoEliminado = boligrafoRepository.findById(datoAGuardar.getId());
        assertFalse(resultadoEliminado.isPresent(), "El boligrafo debería haber sido eliminado");
    }

}
