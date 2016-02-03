public class CommonYearCheck {
    public static void main (String[] args) {
	    long n = Long.parseLong(args [0]);
	    System.out.println (isCommonYear(n));
    }
	
        public static boolean isCommonYear ( long year ) {
            boolean result = false;
			if((year % 400 != 0 & year % 100 == 0) | year % 4 != 0) {
			   result = true;
            }
			
		    return result;
		}












    
}
	