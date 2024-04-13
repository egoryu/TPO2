import logarithmic.Ln;
import logarithmic.Log;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;
import trigonometric.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class FunctionTest {

    static double functionEps = 0.01;
    double eps = 0.1;

    static Sec secMock;
    static Csc cscMock;
    static Tan tanMock;
    static Cot cotMock;
    static Cos cosMock;
    static Sin sinMock;
    static Ln lnMock;
    static Log logMock;

    static Reader secIn;
    static Reader cscIn;
    static Reader tanIn;
    static Reader cotIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader lnIn;
    static Reader log2In;
    static Reader log3In;
    static Reader log5In;
    static Reader log10In;


    @BeforeAll
    static void init() {
        secMock = Mockito.mock(Sec.class);
        cscMock = Mockito.mock(Csc.class);
        cotMock = Mockito.mock(Cot.class);
        tanMock = Mockito.mock(Tan.class);
        cosMock = Mockito.mock(Cos.class);
        sinMock = Mockito.mock(Sin.class);
        lnMock = Mockito.mock(Ln.class);
        logMock = Mockito.mock(Log.class);
        try {
            secIn = new FileReader("src/main/resources/csv/input/SecIn.csv");
            cscIn = new FileReader("src/main/resources/csv/input/CscIn.csv");
            tanIn = new FileReader("src/main/resources/csv/input/TanIn.csv");
            cotIn = new FileReader("src/main/resources/csv/input/CotIn.csv");
            cosIn = new FileReader("src/main/resources/csv/input/CosIn.csv");
            sinIn = new FileReader("src/main/resources/csv/input/SinIn.csv");
            lnIn = new FileReader("src/main/resources/csv/input/LnIn.csv");
            log2In = new FileReader("src/main/resources/csv/input/Log2In.csv");
            log3In = new FileReader("src/main/resources/csv/input/Log3In.csv");
            log5In = new FileReader("src/main/resources/csv/input/Log5In.csv");
            log10In = new FileReader("src/main/resources/csv/input/Log10In.csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(secIn);
            for (CSVRecord record : records) {
                Mockito.when(secMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cscIn);
            for (CSVRecord record : records) {
                Mockito.when(cscMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(tanIn);
            for (CSVRecord record : records) {
                Mockito.when(tanMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cotIn);
            for (CSVRecord record : records) {
                Mockito.when(cotMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(cosIn);
            for (CSVRecord record : records) {
                Mockito.when(cosMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(sinIn);
            for (CSVRecord record : records) {
                Mockito.when(sinMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(lnIn);
            for (CSVRecord record : records) {
                Mockito.when(lnMock.solve(Double.parseDouble(record.get(0)), functionEps)).thenReturn(Double.valueOf(record.get(1)));
            }
            records = CSVFormat.DEFAULT.parse(log2In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), functionEps)).thenReturn(Double.valueOf(record.get(2)));
            }
            records = CSVFormat.DEFAULT.parse(log3In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), functionEps)).thenReturn(Double.valueOf(record.get(2)));
            }
            records = CSVFormat.DEFAULT.parse(log5In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), functionEps)).thenReturn(Double.valueOf(record.get(2)));
            }
            records = CSVFormat.DEFAULT.parse(log10In);
            for (CSVRecord record : records) {
                Mockito.when(logMock.solve(Double.parseDouble(record.get(0)), Double.parseDouble(record.get(1)), functionEps)).thenReturn(Double.valueOf(record.get(2)));
            }
        } catch (IOException ex) {
            System.err.println("Error");
        }

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testFunctionWithMocks(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, cotMock, cscMock, secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithSec(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, cotMock, cscMock, new Sec(cosMock), logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithCsc(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, cotMock, new Csc(sinMock), secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithCot(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, new Cot(sinMock, cosMock), cscMock, secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithTan(double value, double expected) {
        Function function = new Function(cosMock, sinMock, new Tan(sinMock, cosMock), cotMock, cscMock, secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithCos(double value, double expected) {
        Function function = new Function(new Cos(sinMock), sinMock, tanMock, cotMock, cscMock, secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithAllCos(double value, double expected) {
        Function function = new Function(new Cos(sinMock), sinMock, new Tan(sinMock, new Cos(sinMock)), new Cot(sinMock, new Cos(sinMock)), new Csc(sinMock), new Sec(new Cos(sinMock)), logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithSin(double value, double expected) {
        Function function = new Function(cosMock, new Sin(), tanMock, cotMock, cscMock, secMock, logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithAllSin(double value, double expected) {
        Function function = new Function(new Cos(new Sin()), new Sin(), new Tan(new Sin(), new Cos(new Sin())), new Cot(new Sin(), new Cos(new Sin())), new Csc(new Sin()), new Sec(new Cos(new Sin())), logMock);
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithLog(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, cotMock, cscMock, secMock, new Log(lnMock));
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithLn(double value, double expected) {
        Function function = new Function(cosMock, sinMock, tanMock, cotMock, cscMock, secMock, new Log(new Ln()));
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/input/FunctionIn.csv")
    void testWithSinAndLn(double value, double expected) {
        Function function = new Function();
        Assertions.assertEquals(expected, function.solve(value, functionEps), eps);
    }
}