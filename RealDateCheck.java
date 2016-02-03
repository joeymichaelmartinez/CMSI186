public class RealDateCheck {
    public static void main (String[] args) {
	    long l = Long.parseLong(args[0]);
		long m = Long.parseLong(args[1]);
		long n = Long.parseLong(args[2]);
		System.out.println(isRealDate(l, m, n));
    }
    public static boolean isRealDate ( long month, long day, long year ) {
        boolean booleanValue = false;
		if(year >= 0) {
            if (year % 4 !=0 | (year % 400 != 0 & year % 100 == 0)) {
	            if (month > 0 | month <= 12 ) {
		            if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
				        if (day <= 31 & day >= 0) {
					        booleanValue = true;
					    }
				    }
			        else if (month == 4 | month == 6 | month == 9 | month == 11) {
				        if (day <= 30 & day >=0) {
					        booleanValue = true;
					    }
				    }
				    else if (month == 2) {
                        if (day <= 28 & day >=0) {
					        booleanValue = true;
					    }
					
				    }
                }
            }
		    else {
	            if (month > 0 | month <= 12 ) {
		            if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
				        if (day <= 31 & day >= 0) {
					        booleanValue = true;
					    }
				    }
			        else if (month == 4 | month == 6 | month == 9 | month == 11) {
				        if (day <= 30 & day >=0) {
					        booleanValue = true;
					    }
				    }
				    else if (month == 2) {
                        if (day <= 29 & day >=0) {
					        booleanValue = true;
					    }
					
				    }
                }
            }
		}
		

    

        else {
	        booleanValue = false;
	    }
     return booleanValue;
	}	
}