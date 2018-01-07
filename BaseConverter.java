public class BaseConverter {
    
    public static void main (String[] args) {
       
       System.out.println(numberCreator(args[0]);
       System.out.println(baseConverter(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]))); 
    }


    public static String numberCreator (String numbers) {
        //long[] numbersArray = new long[numbers.length()-2*numbers.length()/3];
        //int j = 0;
        for(int i=0;i<numbers.length()-1;i++){
            
            if(numbers.charAt(i+1)!=']' && isInteger(numbers.charAt(i+1))){
                for(int k = i+1; numbers.charAt(k)!=']'; k++) {
                    if(isInteger(numbers.charAt(k))){
                        numbersArray[j] = Character.getNumericValue(numbers.charAt(k));
                        System.out.println(j + ":" + numbersArray[j]);
                    }
                }
            }
            j++;
        }
        return numbersArray;
    }
    
    public static boolean isInteger(char text) {
        try {
            Integer.parseInt(Character.toString(text));
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }   
    public static String baseConverter(String number, int base1, int base2) {
        return Integer.toString(Integer.parseInt(number, base1), base2);
    }
    
    
}

