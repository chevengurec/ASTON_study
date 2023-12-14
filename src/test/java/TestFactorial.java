import org.example.Factorial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestFactorial {
    Factorial factorial;

    @BeforeEach
    public void init() {
        factorial = new Factorial();
    }

    @AfterEach
    public void tearDown() {
        factorial = null;
    }

    @Test
    public void factorial() {
        assertEquals(1, factorial.getFactorial(0));
        assertEquals(1, factorial.getFactorial(1));
        assertEquals(720, factorial.getFactorial(6));
        assertEquals(24,factorial.getFactorial(4));
        assertEquals(3628800, factorial.getFactorial(10));
    }

    @Test
    public void testExpectedNegativeNumber() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            factorial.getFactorial(-1);
        });
    }
}
