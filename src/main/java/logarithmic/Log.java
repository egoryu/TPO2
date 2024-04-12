package logarithmic;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

@AllArgsConstructor
public class Log {
    private final Ln ln;

    public Log() {
        this.ln = new Ln();
    }

    public double solve(double a, double b, double eps) {
        return ln.solve(b, eps) / ln.solve(a, eps);
    }

    public void writeResultToCSV(double a, double b, double eps, Writer out) {
        double res = this.solve(a, b, eps);
        try {
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(a, b, /*Double.isNaN(res) ? 0 :*/ res);
            printer.close();
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
    }
}
