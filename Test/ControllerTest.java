import MVC_coches.src.Model;
import MVC_coches.src.View;
import MVC_coches.src.Coche;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Model model;
    private View view;

    @BeforeEach
    void setUp() {
        model = new Model();
        view = new View();
    }

    @Test
    void testCrearYCambiarVelocidadCoche() {
        // Crear coche
        model.crearCoche("LaFerrari", "SBC 1234");

        // Verificar que se ha creado correctamente
        Coche ferrari = model.getCoche("SBC 1234");
        assertNotNull(ferrari);
        assertEquals("LaFerrari", ferrari.getModelo());

        // Cambiar la velocidad
        int nuevaVelocidad = model.cambiarVelocidad("SBC 1234", 30);
        assertEquals(30, nuevaVelocidad);

        // Mostrar velocidad (simulación con View)
        boolean mostrado = view.muestraVelocidad("SBC 1234", model.getVelocidad("SBC 1234"));
        assertTrue(mostrado);
    }
}

