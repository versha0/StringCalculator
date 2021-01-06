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

}
