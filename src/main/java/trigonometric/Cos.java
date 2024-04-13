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
        double xTmp = x;

        while (xTmp > Math.PI) {
            xTmp -= 2.0 * Math.PI;
        }

        while (xTmp < -Math.PI) {
            xTmp += 2.0 * Math.PI;
        }
        if (xTmp > Math.PI / 2 || xTmp < -Math.PI / 2) {
            return -Math.sqrt(1 - Math.pow(sin.solve(x, eps), 2));
        } else {
            return Math.sqrt(1 - Math.pow(sin.solve(x, eps), 2));
        }
    }
}
