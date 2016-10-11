package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.hamcrest.Matcher;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
   
    @Test
    public void testEmptyString(){
    	assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber(){
    	assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers(){
    	assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testThreeNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testMultipleNumbers(){
    	assertEquals(20, Calculator.add("1,5,4,2,2,3,2,1"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testNegative(){
    	exception.expect(IllegalArgumentException.class);
    	exception.expectMessage("Negatives not allowed: -1,-2");
    	Calculator.add("-1,-2,3");
    }

}