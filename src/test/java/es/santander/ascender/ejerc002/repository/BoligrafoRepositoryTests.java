package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.model.Boligrafo;


@SpringBootTest
public class BoligrafoRepositoryTests {

    @Autowired
    private BoligrafoRepository boligrafoRepository;

    @Value(value = "${cadena}")
    private String cadena;

    // Método que se ejecuta antes de cada test para limpiar la base de datos
    @BeforeEach
    public void setUp() {
        // Limpiar todos los datos de la base de datos (asegurarse de que la base esté limpia antes de cada prueba)
        boligrafoRepository.deleteAll();
    }

    @Test
    public void testList() {
        Iterable<Boligrafo> valores = boligrafoRepository.findAll();
        assertNotNull(valores, "La lista de boligrafos no debería ser nula");
    }

    @Test
    public void testFindNoExistente() {
        Optional<Boligrafo> resultado = boligrafoRepository.findById(456L);
        assertTrue(resultado.isEmpty(), "El boligrafo con ID 456 debería no existir");
    }

    @Test
    public void testLeerUno() {
        // Crear un objeto Boligrafo
        Boligrafo datoAGuardar = new Boligrafo(null, "Juan Ant", "Rojo", true);

        // Guardarlo en la base de datos
        boligrafoRepository.save(datoAGuardar);

        // Verificar que el ID fue asignado
        assertNotNull(datoAGuardar.getId(), "El ID del boligrafo debería ser generado");

        // Recuperarlo por ID
        Optional<Boligrafo> resultado = boligrafoRepository.findById(datoAGuardar.getId());
        assertTrue(resultado.isPresent(), "El boligrafo guardado debería existir en la base de datos");
    }

    @Test
    public void testEliminar() {
        // Crear y guardar un boligrafo
        Boligrafo datoAGuardar = new Boligrafo(null, "Juan Ant", "Verde", true);
        boligrafoRepository.save(datoAGuardar);

        // Eliminar el boligrafo por ID
        boligrafoRepository.deleteById(datoAGuardar.getId());

        // Verificar que el boligrafo ya no existe
        Optional<Boligrafo> resultadoEliminado = boligrafoRepository.findById(datoAGuardar.getId());
        assertFalse(resultadoEliminado.isPresent(), "El boligrafo debería haber sido eliminado");
    }

    @Test
    public void testCadenaNotNulo() {
        // Verificar que el valor de la propiedad 'cadena' no sea nulo
        assertNotNull(cadena, "La propiedad 'cadena' no debería ser nula");
    }
}
