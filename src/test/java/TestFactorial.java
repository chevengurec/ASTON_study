import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFactorial {

    Factorial factorial = new Factorial();

    @Test
    public void factorial() {
        Assert.assertEquals(factorial.getFactorial(4),24);
        Assert.assertEquals(factorial.getFactorial(10),3628800);
        Assert.assertEquals(factorial.getFactorial(6), 720);
        Assert.assertEquals(factorial.getFactorial(1), 1);
        Assert.assertEquals(factorial.getFactorial(0), 1);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testExpectedNegativeNumber() {
        factorial.getFactorial(-9);
    }
}