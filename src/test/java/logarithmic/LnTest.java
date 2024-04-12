package logarithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LnTest {
    @ParameterizedTest
    @ValueSource(doubles = {-1.1, -5.0, 0, 0.2, 0.8, 1.0, 2.0, 10.0, 20.0, 100.0})
    public void LnCheck(double value) {
        Ln ln = new Ln();
        Assertions.assertEquals(Math.log(value), ln.solve(value, 0.001), 0.1);
    }
}
