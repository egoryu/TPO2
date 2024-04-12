package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Csc implements CsvSave {
    public final Sin sin;

    public Csc() {
        this.sin = new Sin();
    }

    public double solve(double x, double eps) {
        double sinRes = this.sin.solve(x, eps);

        if (Math.abs(sinRes) < eps) {
            return Double.NaN;
        }

        return 1 / sin.solve(x, eps);
    }
}
