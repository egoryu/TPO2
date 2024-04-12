import interfaces.CsvSave;
import logarithmic.Log;
import lombok.AllArgsConstructor;
import trigonometric.*;

@AllArgsConstructor
public class Function implements CsvSave {
    private final Cos cos;
    private final Sin sin;
    private final Tan tan;
    private final Cot cot;
    private final Csc csc;
    private final Sec sec;
    private final Log log;

    public Function() {
        this.cos = new Cos();
        this.sin = new Sin();
        this.tan = new Tan();
        this.cot = new Cot();
        this.csc = new Csc();
        this.sec = new Sec();
        this.log = new Log();
    }

    public double solve(double x, double eps) {
        if (x <= 0.0) {
            return (((((tan.solve(x, eps) / cot.solve(x, eps)) * sec.solve(x, eps)) + (Math.pow(sin.solve(x, eps), 2))) * ((cos.solve(x, eps) - csc.solve(x, eps)) * sin.solve(x, eps))) * ((Math.pow(cot.solve(x, eps), 2)) / ((cot.solve(x, eps) / sin.solve(x, eps)) / ((Math.pow(sec.solve(x, eps), 3)) * sec.solve(x, eps)))));
        } else {
            return (((((log.solve(3, x, eps) + log.solve(5, x, eps)) - log.solve(10, x, eps)) * (log.solve(2, x, eps) + log.solve(5, x, eps))) * ((log.solve(2, x, eps) * log.solve(3, x, eps)) - log.solve(3, x, eps))) * log.solve(3, x, eps));
        }
    }
}
