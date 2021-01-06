package org.versha.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCalculatorTest
{
    static StringCalculator testObject;

    @BeforeClass public static void createObject() {
        testObject = new StringCalculator();
    }

    @AfterClass public static void addMethodCalledTimes(){
        System.out.println(StringCalculator.called);
    }

    @Test public void addEmptyString(){
        assertEquals(0, testObject.add(""));
    }

    @Test public void addOneNumberString(){
        assertEquals(100,testObject.add("100"));
    }

    @Test public void addTwoNumberString(){
        assertEquals(300,testObject.add("100,200"));
    }

    @Test public void addThreeOrMoreNumberString(){
        assertEquals(600,testObject.add("100,200,300"));
    }

    @Test public void addNumberStringWithNewLineInsteadOfComma(){
        assertEquals(6,testObject.add("1\n2,3"));
    }

    @Test public void addNumberStringWithAnySpecifiedDelimiter(){
        assertEquals(36,testObject.add("//;\n33;3"));
    }

    @Test public void addNumberStringWithNegativeNumber(){
        try {
            testObject.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negative Number Not Allowed");
        }
    }

    @Test public void addNumberStringWithManyNegativeNumbers(){
        try {
            testObject.add("-1,-2,-3,4,5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negative Number Not Allowed : -1 -2 -3");
        }
    }

}
