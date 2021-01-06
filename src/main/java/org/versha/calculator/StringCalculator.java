package org.versha.calculator;

public class StringCalculator
{
    public int add(String string){
        if(string.equals("")) return 0;

        return Integer.parseInt(string);
    }
}
