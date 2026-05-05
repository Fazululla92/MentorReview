import StepDefination.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@DataProvider(name = "addData")
public Object[][] getData() {
    return new Object[][] {
            {2, 3, 5},
            {5, 5, 10}
    };
}

@Test(dataProvider = "addData")
public void testAdd(int a, int b, int expected) {
    Calculator calc = new Calculator();
    Assert.assertEquals(calc.add(a, b), expected);
}

void main() {
    testAdd(5,6,11);
}
