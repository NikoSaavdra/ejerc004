
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc002.repository.OrdenadorRepository;


@SpringBootTest
public class OrdenadorRepositoryTests {

    @Autowired
    private OrdenadorRepository ordenadorRepository;

    @BeforeEach
    public void setUp() {
        ordenadorRepository.deleteAll();
    }

    @Test
    public void testListarOrdenadores() {
        List<Ordenador> lista = ordenadorRepository.findAll();
        assertNotNull(lista, "La lista de ordenadores no debería ser nula");
        assertTrue(lista.isEmpty(), "Debería estar vacía al inicio");
    }

    @Test
    public void testBuscarOrdenadorNoExistente() {
        Optional<Ordenador> resultado = ordenadorRepository.findById(99L);
        assertTrue(resultado.isEmpty(), "El ordenador con ID 99 no debería existir");
    }

    @Test
    public void testGuardarYLeerOrdenador() {
        Ordenador nuevoOrdenador = new Ordenador(null, 2.5, "100,100,100", 104);
        ordenadorRepository.save(nuevoOrdenador);

        assertNotNull(nuevoOrdenador.getId(), "El ID del ordenador debería ser generado");

        Optional<Ordenador> resultado = ordenadorRepository.findById(nuevoOrdenador.getId());
        assertTrue(resultado.isPresent(), "El ordenador guardado debería existir en la base de datos");
        assertEquals("100,100,100", resultado.get().getColor(), "El color debería coincidir");
    }

    @Test
    public void testActualizarOrdenador() {
        Ordenador ordenador = new Ordenador(null, 2.5, "120,120,120", 104);
        ordenadorRepository.save(ordenador);

        ordenador.setPeso(3.2);
        ordenador.setColor("255,255,255");
        ordenador.setNumeroTeclas(110);
        ordenadorRepository.save(ordenador);

        Optional<Ordenador> resultado = ordenadorRepository.findById(ordenador.getId());
        assertTrue(resultado.isPresent(), "El ordenador actualizado debería existir");
        assertEquals(3.2, resultado.get().getPeso(), "El peso debería haberse actualizado");
        assertEquals("255,255,255", resultado.get().getColor(), "El color debería haberse actualizado");
        assertEquals(110, resultado.get().getNumeroTeclas(), "El número de teclas debería haberse actualizado");
    }

    @Test
    public void testEliminarOrdenador() {
        Ordenador nuevoOrdenador = new Ordenador(null, 3.0, "200,200,200", 105);
        ordenadorRepository.save(nuevoOrdenador);

        ordenadorRepository.deleteById(nuevoOrdenador.getId());

        Optional<Ordenador> resultadoEliminado = ordenadorRepository.findById(nuevoOrdenador.getId());
        assertFalse(resultadoEliminado.isPresent(), "El ordenador debería haber sido eliminado");
    }


    @Test
    public void testGuardarMultiplesOrdenadores() {
        Ordenador ordenador1 = new Ordenador(null, 2.5, "100,100,100", 104);
        Ordenador ordenador2 = new Ordenador(null, 3.0, "150,150,150", 105);
        Ordenador ordenador3 = new Ordenador(null, 1.8, "50,50,50", 103);

        ordenadorRepository.save(ordenador1);
        ordenadorRepository.save(ordenador2);
        ordenadorRepository.save(ordenador3);

        List<Ordenador> lista = ordenadorRepository.findAll();
        assertEquals(3, lista.size(), "Deberían haberse guardado 3 ordenadores");
    }

    @Test
    public void testEliminarTodosLosOrdenadores() {
        Ordenador ordenador1 = new Ordenador(null, 2.5, "100,100,100", 104);
        Ordenador ordenador2 = new Ordenador(null, 3.0, "150,150,150", 105);
        Ordenador ordenador3 = new Ordenador(null, 1.8, "50,50,50", 103);

        ordenadorRepository.save(ordenador1);
        ordenadorRepository.save(ordenador2);
        ordenadorRepository.save(ordenador3);

        ordenadorRepository.deleteAll();

        List<Ordenador> lista = ordenadorRepository.findAll();
        assertTrue(lista.isEmpty(), "La base de datos debería estar vacía después de eliminar todo");
    }
}
