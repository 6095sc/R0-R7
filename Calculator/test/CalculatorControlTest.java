import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * CalculatorControl Tester.
 *
 * @author <7264>
 * @version 1.0
 * @since <pre>10月 21, 2020</pre>
 */
public class CalculatorControlTest {
    /**
     * Method: getLastChar()
     */
    @Test
    public void testGetLastChar() throws Exception {
        CalculatorControl cc = new CalculatorControl();
        cc.expression.setText("1234560");
        cc.getLastChar();
        assertTrue(cc.lastChar==0);
        assertFalse(cc.isFirst);
        cc.expression.setText("123456");
        cc.getLastChar();
        assertTrue(cc.lastChar==1);
        cc.expression.setText("123456+");
        cc.getLastChar();
        assertTrue(cc.lastChar==2);
        cc.expression.setText("123456-");
        cc.getLastChar();
        assertTrue(cc.lastChar==2);
        cc.expression.setText("123456*");
        cc.getLastChar();
        assertTrue(cc.lastChar==2);
        cc.expression.setText("123456/");
        cc.getLastChar();
        assertTrue(cc.lastChar==2);
        assertFalse(cc.isFirst);
        cc.expression.setText("123456.");
        cc.getLastChar();
        assertTrue(cc.lastChar==0);
        assertTrue(cc.isFirst);
    }

    /**
     * Method: clear()
     */
    @Test
    public void testClear() throws Exception {
        CalculatorControl cc = new CalculatorControl();
        cc.expression.setText("123456");
        cc.clear();
        assertTrue(cc.expression.getText().equals("0"));
    }

    /**
     * Method: deleteLastChar()
     */
    @Test
    public void testDeleteLastChar() throws Exception {
        CalculatorControl cc = new CalculatorControl();
        cc.expression.setText("123456");
        cc.deleteLastChar();
        assertTrue(cc.expression.getText().equals("12345"));
        cc.expression.setText("1");
        cc.deleteLastChar();
        assertTrue(cc.expression.getText().equals("0"));
        cc.expression.setText("+");
        cc.deleteLastChar();
        assertTrue(cc.expression.getText().equals("0"));
        cc.expression.setText("0");
        cc.deleteLastChar();
        assertTrue(cc.expression.getText().equals("0"));
    }
} 
