package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Cot implements CsvSave {
    private final Sin sin;
    private final Cos cos;

    public Cot() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public double solve(double x, double eps) {
        double sinRes = this.sin.solve(x, eps);

        if (Math.abs(sinRes) < eps) {
            return Double.NaN;
        }

        return cos.solve(x, eps) / sin.solve(x, eps);
    }
}
