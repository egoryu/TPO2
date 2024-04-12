package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tan implements CsvSave {
    private final Sin sin;
    private final Cos cos;

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public double solve(double x, double eps) {
        double cosRes = this.cos.solve(x, eps);

        if (Math.abs(cosRes) < eps) {
            return Double.NaN;
        }

        return sin.solve(x, eps) / cos.solve(x, eps);
    }
}
