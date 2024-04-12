package trigonometric;

import logarithmic.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SinTest {
    @ParameterizedTest
    @ValueSource(doubles = {-1.1, -5.0, 0, 0.2, 0.8, 1.0, 2.0, 6.0, 7.0, 10.0, 20.0, 100.0})
    public void sinCheck(double value) {
        Sin function = new Sin();
        Assertions.assertEquals(Math.sin(value), function.solve(value, 0.001), 0.01);
    }
}
