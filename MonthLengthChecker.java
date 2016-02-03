public class MonthLengthChecker {
    public static void main (String[] args) {
	    int n = Integer.parseInt(args[0]);
		long m = Long.parseLong(args[1]);
	    System.out.println(monthLength(n, m));
	}

    public static long monthLength ( int month, long year ) {
	    int monthNumber = 0;
		if (year % 4 !=0 | (year % 400 != 0 & year % 100 == 0)) {
            
		    switch (month) {
		        case 1: monthNumber = 31;
		        break;
		        case 2: monthNumber = 28;
		        break;
		        case 3: monthNumber = 31;
		        break;
		        case 4: monthNumber = 30;
		        break;
		        case 5: monthNumber = 31;
		        break;
		        case 6: monthNumber = 30;
		        break;
		        case 7: monthNumber = 31;
		        break;
		        case 8: monthNumber = 31;
		        break;
		        case 9: monthNumber = 30;
		        break;
		        case 10: monthNumber = 31;
		        break;
		        case 11: monthNumber = 30;
		        break;
		        case 12: monthNumber = 31;
		        break;
			}
		}
		else {
		    switch (month) {
		        case 1: monthNumber = 31;
		        break;
		        case 2: monthNumber = 29;
		        break;
		        case 3: monthNumber = 31;
		        break;
		        case 4: monthNumber = 30;
		        break;
		        case 5: monthNumber = 31;
		        break;
		        case 6: monthNumber = 30;
		        break;
		        case 7: monthNumber = 31;
		        break;
		        case 8: monthNumber = 31;
		        break;
		        case 9: monthNumber = 30;
		        break;
		        case 10: monthNumber = 31;
		        break;
		        case 11: monthNumber = 30;
		        break;
		        case 12: monthNumber = 31;
		        break;
		    }
		
		}
	    return monthNumber;
	}












}