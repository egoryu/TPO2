package interfaces;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.io.Writer;

public interface CsvSave {
    public double solve(double x, double eps);
    public default void writeResultToCSV(double x, double eps, Writer out) {
        double res = this.solve(x, eps);
        try {
            CSVPrinter printer = CSVFormat.DEFAULT.print(out);
            printer.printRecord(x, /*Double.isNaN(res) ? 0 : */res);
            printer.close();
            out.close();
        } catch (IOException e) {
            System.out.println("Wrong filename");
        }
    }
}
