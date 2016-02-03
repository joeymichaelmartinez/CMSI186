public class DateDistanceCombined {
    public static boolean isCommonYear ( long year ) {
        boolean result = false;
        if((year % 400 != 0 & year % 100 == 0) | year % 4 != 0) {
            result = true;
        }
			
            return result;
    }
		
        public static long monthLength ( int month, long year ) {
            long monthNumber = 0;
            
            switch (month) {
                case 1: 
                case 3: 
                case 5: 
                case 7:
                case 8:
                case 10:
                case 12: monthNumber = 31;
                break;
                case 4: 
                case 6:
                case 9:
                case 11: monthNumber = 30;
                break;
                case 2: if (isCommonYear(year)) {
                            monthNumber = 28;
                        } 
                        else {
                            monthNumber = 29;
                        }
            }
        return monthNumber;
        }

    public static boolean isRealDate ( int month, long day, long year ) {
        boolean booleanValue = false;
        if(year >= 0) { 
            if (month > 0 | month <= 12 ) {
                if (monthLength(month, year) == 31) {
                    if (day <= 31 & day > 0) {
                        booleanValue = true;
                    }
                }
                else if (monthLength(month, year) == 30) {
                    if (day <= 30 & day >0) {
					        booleanValue = true;
                    }
                }
                else if (monthLength(month, year) == 28) {
                    if (day <= 28 & day >0) {
                        booleanValue = true;
                    }
                }
                else if (monthLength(month, year) == 29) {
                    if (day <= 29 & day >0) {
                        booleanValue = true;
                    }	
                }
				    
            }
            
        }
        else {
	        booleanValue = false;
	    }
    return booleanValue;
    }		
	
    public static long distance ( long month0, long day0, long year0, 
                                 long month1, long day1, long year1 ) {
        long yearInDays0 = 0;
        long monthInDays0 = 0;
        for (int i=0; i < year0; i++){
            if(isCommonYear(i)) {
                yearInDays0 = yearInDays0 + 365;
            }
            else {
                yearInDays0 = yearInDays0 + 366;
            }
        }
        for (int i = 1; i <= month0; i++) {	
            if(monthLength(i, year0) == 31) {
                monthInDays0 = monthInDays0 + 31;			
            }
            else if (monthLength(i, year0) == 30) {
                monthInDays0 = monthInDays0 + 30;
            }
            else if (monthLength(i, year0) == 28) {
                monthInDays0 = monthInDays0 + 28;
            }
            else if (monthLength(i, year0) == 29) {
                monthInDays0 = monthInDays0 + 29;
            }	
        }
        long yearInDays1 = 0;
        long monthInDays1 = 0;
        for (int i = 0; i < year1; i++){
            if(isCommonYear(i)) {
                yearInDays1 = yearInDays1 + 365;
            }
            else {
                yearInDays1 = yearInDays1 + 366;
            }
        }
        for (int i = 1; i <= month1; i++) {	
            if(monthLength(i, year1) == 31) {
                monthInDays1 = monthInDays1 + 31;			
            }
            else if (monthLength(i, year1) == 30) {
                monthInDays1 = monthInDays1 + 30;
            }
            else if(monthLength(i, year1) == 28) {
                monthInDays1 = monthInDays1 + 28;
            }
            else if (monthLength(i, year1) == 29) {
                monthInDays1 = monthInDays1 + 29;
            }	
        }	
    long distanceBetweenDates = Math.abs(day0 + monthInDays0 + yearInDays0 - day1 - monthInDays1 - yearInDays1);
    return distanceBetweenDates;
    }
	
	public static void main(String[] args) {
        int l = Integer.parseInt(args[0]);
        long m = Long.parseLong(args[1]);
        long n = Long.parseLong(args[2]);
        long o = Long.parseLong(args[3]);
        long p = Long.parseLong(args[4]);
        long q = Long.parseLong(args[5]);
        System.out.println(distance(l, m, n, o, p, q));
		
    }
}