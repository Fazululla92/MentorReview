package API;

import StepDefination.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest extends Calculator {

    Calculator calc;

    @BeforeClass
    public void setup() {
        calc = new Calculator();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Test starting...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished...");
    }

    // -------- POSITIVE TESTS --------

    @Test
    public void testAdd() {
        Assert.assertEquals(calc.add(2, 3), 5);
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(calc.subtract(5, 3), 2);
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(calc.multiply(2, 3), 6);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(calc.divide(10, 2), 5);
    }

    @Test
    public void testSquare() {
        Assert.assertEquals(calc.square(4), 16);
    }

    // -------- NEGATIVE TESTS --------

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }

    @Test
    public void testWrongAdd() {
        Assert.assertNotEquals(calc.add(2, 2), 5);
    }

    @Test
    public void testNegativeMultiply() {
        Assert.assertEquals(calc.multiply(-2, 3), -6);
    }

    @Test
    public void testNegativeSubtract() {
        Assert.assertEquals(calc.subtract(2, 5), -3);
    }

    @Test
    public void testNullBehavior() {
        Assert.assertNotNull(calc);
    }
}
