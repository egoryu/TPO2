package trigonometric;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sin implements CsvSave {
    public double solve(double x, double eps) {
        if (Double.isNaN(x) || Double.isNaN(eps)) {
            return Double.NaN;
        }

        while (x > 2.0 * Math.PI) {
            x -= 2.0 * Math.PI;
        }

        while (x < 0) {
            x += 2.0 * Math.PI;
        }

        double ans = 0, term = x, previousTerm = 0;
        int n = 0;

        while (Math.abs(term - previousTerm) > eps) {
            ans += term;
            n++;
            previousTerm = term;
            term = -term * x * x / ((2 * n) * (2 * n + 1));
        }

        return ans;
    }
}
