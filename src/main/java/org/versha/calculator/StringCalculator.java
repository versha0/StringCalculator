package org.versha.calculator;

public class StringCalculator
{
    public int add(String string){
        if(string.equals("")) return 0;
        String[] arrayString = string.split(",|\\\n");
        return addStringArray(arrayString);
    }

    private static int addStringArray(String[] arrayString){
        int ans =0;
        for(int i=0;i<arrayString.length;i++){
            ans = ans+Integer.parseInt(arrayString[i]);
        }
        return ans;
    }
}
