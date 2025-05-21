import MVC_coches.src.Coche;
import MVC_coches.src.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new Model();
    }

    @Test
    public void testCrearCoche() {
        Coche coche = model.crearCoche("Toyota", "1234ABC");
        assertNotNull(coche);
        assertEquals("Toyota", coche.getModelo());
        assertEquals("1234ABC", coche.getMatricula());
    }

    @Test
    public void testGetCocheExistente() {
        model.crearCoche("Ford", "5678DEF");
        Coche coche = model.getCoche("5678DEF");
        assertNotNull(coche);
        assertEquals("Ford", coche.getModelo());
    }

    @Test
    public void testGetCocheInexistente() {
        Coche coche = model.getCoche("0000ZZZ");
        assertNull(coche);
    }

    @Test
    public void testCambiarVelocidad() {
        model.crearCoche("BMW", "1111AAA");
        int nuevaVelocidad = model.cambiarVelocidad("1111AAA", 80);
        assertEquals(80, nuevaVelocidad);
        assertEquals(80, model.getVelocidad("1111AAA"));
    }

    @Test
    public void testGetVelocidad() {
        model.crearCoche("Audi", "2222BBB");
        model.cambiarVelocidad("2222BBB", 60);
        int velocidad = model.getVelocidad("2222BBB");
        assertEquals(60, velocidad);
    }

    @Test
    public void testCambiarVelocidadCocheNoExistente() {
        assertThrows(NullPointerException.class, () -> {
            model.cambiarVelocidad("9999ZZZ", 100);
        });
    }
}
