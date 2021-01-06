package org.versha.calculator;

public class StringCalculator
{
    public int add(String string){
        if(string.equals("")) return 0;
        string = string.replaceAll("\n",",");
        System.out.println(string);
        String[] arrayString = string.split(",");
        int ans =0;
        for(int i=0;i<arrayString.length;i++){
            ans = ans+Integer.parseInt(arrayString[i]);
        }
        return ans;
    }
}
