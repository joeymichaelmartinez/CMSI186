public class DateDistance {
    public static void main (String[] args){

	}
	public static long distance ( long month0, long day0, long year0, 
	                            long month1, long day1, long year01 ) {
		if(year0 >= 0 | year1 >= 0) {
            if (year0 % 4 !=0 | (year0 % 400 != 0 & year0 % 100 == 0) | year1 % 4 !=0 | (year1 % 400 != 0 & year1 % 100 == 0)) {
				yearToDays = 365;
	            if (month > 0 | month <= 12 ) {
		            if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
				        monthToDays = 31;
					
				    }
			        else if (month == 4 | month == 6 | month == 9 | month == 11) {
				        monthToDays = 30;
					
				    }
				    else if (month == 2) {
                        monthToDays = 28;
					
				    }
                }
            }
		    else {
				year0ToDays = 366;
	            if (month > 0 | month <= 12 ) {
		            if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12) {
				        monthToDays = 31;
					
				    }
			        else if (month == 4 | month == 6 | month == 9 | month == 11) {
				        monthToDays = 30;
					
				    }
				    else if (month == 2) {
                        monthToDays = 29;
					
				    }
                }
            }
		}
     return booleanValue;
	}	
}

