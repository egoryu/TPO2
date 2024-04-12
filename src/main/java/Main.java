import logarithmic.Ln;
import logarithmic.Log;
import trigonometric.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws IOException {
        Function function = new Function();

        for (double x = -10.0; x <= 0.0; x += 0.01) {
            function.writeResultToCSV(x, 0.01, new FileWriter("src/main/resources/csv/output/out2.csv", true));
        }
    }
}
