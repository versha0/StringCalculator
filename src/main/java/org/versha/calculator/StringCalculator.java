package org.versha.calculator;

public class StringCalculator
{
    static int called =0;
    public int add(String string){
        getCalledCount();
        if(string.equals("")) return 0;
        String delimiter = ",|\\\n";
        if(string.matches("//(.*)\n(.*)")){
            int lastIndexDelimiter = string.indexOf('\n');
            if(string.charAt(2)=='['){
                delimiter= string.substring(2,lastIndexDelimiter)+ delimiter.substring(1);
                int numOfSquareBrace=0;
                for (int i=0;i<delimiter.length();i++){
                    if(delimiter.charAt(i)==']'){
                        numOfSquareBrace++;
                    }
                }
                if(numOfSquareBrace>1){
                    delimiter=delimiter.substring(0,delimiter.length()-3);
                    delimiter= delimiter.replaceAll("]","]|")+ "\\\n";
                }
                string = string.substring(lastIndexDelimiter);
            }
            else{
                delimiter = string.charAt(2) + delimiter.substring(1);
                string = string.substring(4);
            }
        }
        String[] arrayString = string.split(delimiter);
        return addStringArray(arrayString);
    }

    private static int addStringArray(String[] arrayString) throws IllegalArgumentException{
        int ans =0;
        int negativeNum=0;
        String negativeString = "";
        for(int i=0;i<arrayString.length;i++){
            if(!arrayString[i].equals("") && !arrayString[i].equals("") && Integer.parseInt(arrayString[i])<0){
                negativeNum++;
                negativeString = negativeString+ " "+ arrayString[i];
            }
            if(!arrayString[i].equals("") && Integer.parseInt(arrayString[i])<1001)
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
