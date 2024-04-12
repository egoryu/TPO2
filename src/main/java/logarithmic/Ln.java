package logarithmic;

import interfaces.CsvSave;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Ln implements CsvSave {
    public double solve(double x, double eps) {
        if (x < 0.0) {
            return Double.NaN;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        } else if (x == 1.0) {
            return 0;
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1)), sum = 0, currentValue = (x - 1) / (x + 1);
        int step = 1;

        while (Math.abs(currentValue) > eps / 2) {
            sum += currentValue;
            currentValue = (2 * step - 1) * currentValue * constant / (2 * step + 1);
            step++;
        }

        sum *= 2.0;

        return sum;
    }
}
