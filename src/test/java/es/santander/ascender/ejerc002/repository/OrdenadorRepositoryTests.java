package es.santander.ascender.ejerc002.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import jakarta.validation.ConstraintViolation;

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

        Ordenador datoAGuardar = new Ordenador(null, "Boli", "Rojo", true);

        ordenadorRepository.save(datoAGuardar);

        assertNotNull(datoAGuardar.getId(), "El ID del ordenador debería ser generado");

        Optional<Ordenador> resultado = ordenadorRepository.findById(datoAGuardar.getId());
        assertTrue(resultado.isPresent(), "El boligrafo guardado debería existir en la base de datos");
    }

    @Test
    public void testEliminar() {

        Ordenador datoAGuardar = new Ordenador(null, "Boli", "Verde", true);
        ordenadorRepository.save(datoAGuardar);

        ordenadorRepository.deleteById(datoAGuardar.getId());

        Optional<Ordenador> resultadoEliminado = ordenadorRepository.findById(datoAGuardar.getId());
        assertFalse(resultadoEliminado.isPresent(), "El ordenador debería haber sido eliminado");
    }
    
     @Test
    void testColorIncorrectoTexto() {
        Ordenador ordenador = new Ordenador(1L, 2.5, "rojo,verde,azul", 104);
        Set<ConstraintViolation<Ordenador>> violations = validator.validate(ordenador);
        assertFalse(violations.isEmpty(), "El color no debe permitir texto");
    }

      void testNumeroTeclasNegativo() {
        Ordenador ordenador = new Ordenador(1L, 2.5, "100,100,100", -10);
        Set<ConstraintViolation<Ordenador>> violations = validator.validate(ordenador);
        assertFalse(violations.isEmpty(), "El número de teclas no puede ser negativo");
        assertEquals("El número de teclas no puede ser negativo", violations.iterator().next().getMessage());
    }
}
