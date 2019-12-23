import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTemperatureConverter {

    private static TemperatureConverter temperatureConverter;

    @Parameterized.Parameter
    public double temperatureC;
    @Parameterized.Parameter(1)
    public double temperatureF;
    @Parameterized.Parameter(2)
    public double temperatureK;

    @Parameterized.Parameters(name = "C={0}, F={1}, K={2}")
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {0, 32, 273.2},
                {-273.2, -459.7, 0},
                {-17.78, 0, 255.39}
        });
    }

    @BeforeClass
    public static void initialize() {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    public void testConvertFtoC() {
        Assert.assertEquals(temperatureC, temperatureConverter.convertFtoC(temperatureF), 0.1);
    }

    @Test
    public void testConvertFtoK() {
        Assert.assertEquals(temperatureK, temperatureConverter.convertFtoK(temperatureF), 0.1);
    }

    @Test
    public void testConvertCtoK() {
        Assert.assertEquals(temperatureK, temperatureConverter.convertCtoK(temperatureC), 0.1);
    }

    @Test
    public void testConvertCtoF() {
        Assert.assertEquals(temperatureF, temperatureConverter.convertCtoF(temperatureC), 0.1);
    }

    @Test
    public void testConvertKtoF() {
        Assert.assertEquals(temperatureF, temperatureConverter.convertKtoF(temperatureK), 0.1);
    }

    @Test
    public void testConvertKtoC() {
        Assert.assertEquals(temperatureC, temperatureConverter.convertKtoC(temperatureK), 0.1);
    }

}
