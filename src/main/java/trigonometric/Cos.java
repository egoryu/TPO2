package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cos implements CsvSave {
    private final Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public double solve(double x, double eps) {
        while (x > Math.PI) {
            x -= 2.0 * Math.PI;
        }

        while (x < -Math.PI) {
            x += 2.0 * Math.PI;
        }
        if (x > Math.PI / 2 || x < -Math.PI / 2) {
            return -Math.sqrt(1 - Math.pow(sin.solve(x, eps), 2));
        } else {
            return Math.sqrt(1 - Math.pow(sin.solve(x, eps), 2));
        }
    }
}
