package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sec implements CsvSave {
    public final Cos cos;

    public Sec() {
        this.cos = new Cos();
    }

    public double solve(double x, double eps) {
        double cosRes = this.cos.solve(x, eps);

        if (Math.abs(cosRes) < eps) {
            return Double.NaN;
        }

        return 1.0 / cos.solve(x, eps);
    }
}
