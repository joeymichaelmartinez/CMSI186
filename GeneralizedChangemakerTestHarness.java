public class GeneralizedChangemakerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_USA();
        test_Impossible();
        test_Examples();
        
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayFailure() {
        displaySuccessIfTrue(false);
    }

    public static void test_USA() {
        System.out.println("Testing USA Denominations: ");
        int[] usaDenominations = new int[] { 25, 10, 5, 1 };

        Tuple result = GeneralizedChangemaker.makeChangeWithDynamicProgramming(99, usaDenominations);
        try {
            displaySuccessIfTrue(3 == result.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(2 == result.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(0 == result.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }

        try {
            displaySuccessIfTrue(4 == result.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        System.out.println();
    }

    
    public static void test_Impossible () {
        System.out.println("Testing For Impossible Change: " );
        int[] arbitraryInts = new int[] { 6, 7, 10 };
        int[] arbitraryInts2 = new int[] { 73995, 608, 17739, 24011, 95877623 };
        Tuple result = GeneralizedChangemaker.makeChangeWithDynamicProgramming(15, arbitraryInts);
        try {
            displaySuccessIfTrue(result.isImpossible());
        } catch (Exception e) {
            displayFailure();
        }
        
        Tuple result2 = GeneralizedChangemaker.makeChangeWithDynamicProgramming(35472, arbitraryInts2);
        try {
            displaySuccessIfTrue(result2.isImpossible());
        } catch (Exception e) {
            displayFailure();
        }
        System.out.println();
    }
    
    public static void test_Examples() {
        System.out.println("Testing Other Various Denominations" );
        int[] pounds = new int[] { 1, 2, 5, 10, 20, 50 };
        int[] euroBanknoteDenominations = new int[] { 5, 10, 20, 50, 100, 200, 500 };
        int[] arbitraryInts = new int[] { 3, 1, 9, 8 };
        int[] arbitraryInts2 = new int[] { 2, 5, 3 };
        int[] arbitraryInts3 = new int[] { 73995, 608, 17736, 24011, 95877623 };
        
        System.out.println("Testing pounds: " );
        Tuple result1 = GeneralizedChangemaker.makeChangeWithDynamicProgramming( 157, pounds);
        try {
            displaySuccessIfTrue(0 == result1.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(1 == result1.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(1 == result1.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result1.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result1.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(3 == result1.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        System.out.println();
        
        System.out.println("Testing Euro Banknote Denominations: " );
        Tuple result2 = GeneralizedChangemaker.makeChangeWithDynamicProgramming( 500, euroBanknoteDenominations);
        try {
            displaySuccessIfTrue(0 == result2.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result2.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result2.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result2.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result2.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result2.getElement(5));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(1 == result2.getElement(6));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        System.out.println();
        
        System.out.println("Testing the example given in homework: " );
        Tuple result3 = GeneralizedChangemaker.makeChangeWithDynamicProgramming( 14, arbitraryInts);
        try {
            displaySuccessIfTrue(2 == result3.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result3.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result3.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(1 == result3.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        System.out.println();

        System.out.println("Comparing to my own example I completed by hand: " );
        Tuple result4 = GeneralizedChangemaker.makeChangeWithDynamicProgramming( 11, arbitraryInts2);
        try {
            displaySuccessIfTrue(0 == result4.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(1 == result4.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(2 == result4.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        System.out.println();
        
        System.out.println("Testing the example given in class: " );
        Tuple result5 = GeneralizedChangemaker.makeChangeWithDynamicProgramming( 35472, arbitraryInts3);
        try {
            displaySuccessIfTrue(0 == result5.getElement(0));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result5.getElement(1));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(2 == result5.getElement(2));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result5.getElement(3));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
        
        try {
            displaySuccessIfTrue(0 == result5.getElement(4));
        } catch (Exception e) {
            e.printStackTrace();
            displayFailure();
        }
    }
}