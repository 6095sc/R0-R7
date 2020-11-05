import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * CalculatorModel Tester.
 *
 * @author <7264>
 * @version 1.0
 * @since <pre>10月 21, 2020</pre>
 */
public class CalculatorModelTest {
    /**
     * Method: calculatorExpression()
     */
    @Test
    public void testCalculatorExpression() throws Exception {
        CalculatorModel cm1 = new CalculatorModel("123");
        assertEquals("123",cm1.calculatorExpression());

        CalculatorModel cm2 = new CalculatorModel("0");
        assertEquals("0",cm2.calculatorExpression());

        CalculatorModel cm3 = new CalculatorModel("123/0");
        assertEquals("除数不能为0!",cm3.calculatorExpression());

        CalculatorModel cm4 = new CalculatorModel("123+123");
        assertEquals("246",cm4.calculatorExpression());

        CalculatorModel cm5 = new CalculatorModel("123*3");
        assertEquals("369",cm5.calculatorExpression());

        CalculatorModel cm6 = new CalculatorModel("123-3");
        assertEquals("120",cm6.calculatorExpression());

        CalculatorModel cm7 = new CalculatorModel("123/3");
        assertEquals("41",cm7.calculatorExpression());

        CalculatorModel cm8 = new CalculatorModel("123-125");
        assertEquals("-2",cm8.calculatorExpression());
    }


    /**
     * Method: getPriority(char ch)
     */
    @Test
    public void testGetPriority() throws Exception {
        CalculatorModel cm = new CalculatorModel("test");
        assertEquals(1,cm.getPriority('('));
        assertEquals(2,cm.getPriority('+'));
        assertEquals(2,cm.getPriority('-'));
        assertEquals(3,cm.getPriority('*'));
        assertEquals(3,cm.getPriority('/'));
        assertEquals(0,cm.getPriority('1'));
        assertEquals(0,cm.getPriority('.'));
        assertEquals(0,cm.getPriority('a'));

    }

    /**
     * Method: result(Long a, Long b, char sign)
     */
    @Test
    public void testResult() throws Exception {
        CalculatorModel cm = new CalculatorModel("test");
        assertTrue(cm.result(123L,123L,'+')==246);
        assertTrue(cm.result(123L,3L,'-')==120);
        assertTrue(cm.result(123L,3L,'*')==369);
        assertTrue(cm.result(123L,3L,'/')==41);
        assertTrue(cm.result(0L,123L,'-')==-123);
        assertTrue(cm.result(123L,123L,'.')==null);
        assertTrue(cm.result(123L,123L,'a')==null);
        assertTrue(cm.result(123L,123L,'1')==null);
    }

}
