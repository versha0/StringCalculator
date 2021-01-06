package org.versha.calculator;

public class StringCalculator
{
    static int called =0;
    public int add(String string){
        getCalledCount();
        if(string.equals("")) return 0;
        String delimiter = ",|\\\n";
        if(string.matches("//(.*)\n(.*)")){
            delimiter = string.charAt(2)+delimiter.substring(1);
            string = string.substring(4);
        }
        String[] arrayString = string.split(delimiter);
        return addStringArray(arrayString);
    }

    private static int addStringArray(String[] arrayString) throws IllegalArgumentException{
        int ans =0;
        int negativeNum=0;
        String negativeString = "";
        for(int i=0;i<arrayString.length;i++){
            if(Integer.parseInt(arrayString[i])<0){
                negativeNum++;
                negativeString = negativeString+ " "+ arrayString[i];
            }
            if(Integer.parseInt(arrayString[i])<1001)
            ans = ans+Integer.parseInt(arrayString[i]);
        }
        if(negativeNum==1)
            throw new IllegalArgumentException("Negative Number Not Allowed");
        else if(negativeNum>1){
            throw new IllegalArgumentException("Negative Number Not Allowed :"+negativeString);
        }
        return ans;
    }

    private static void getCalledCount(){
        called++;
    }
}
