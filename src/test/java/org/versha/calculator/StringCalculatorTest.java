package org.versha.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringCalculatorTest
{
    static StringCalculator testObject;

    @BeforeClass public static void createObject() {
        testObject = new StringCalculator();
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
        assertEquals(1000,testObject.add("100,200,300,400"));
    }

    @Test public void addNumberStringWithNewLineInsteadOfComma(){
        assertEquals(6,testObject.add("1\n2,3"));
    }

}
