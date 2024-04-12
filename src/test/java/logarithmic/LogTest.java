package logarithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LogTest {
    @ParameterizedTest
    @ValueSource(doubles = {-1.1, -5.0, 0, 0.2, 0.8, 1.0, 2.0, 10.0, 20.0, 100.0})
    public void LogCheck(double value) {
        Log function = new Log();
        Assertions.assertEquals(Math.log10(value), function.solve(10, value, 0.001), 0.01);
    }
}
