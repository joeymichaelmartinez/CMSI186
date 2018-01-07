class ClockSolver2{
    public static void main (String[] args) {
        
        double slice = 0;
        double angleInput = 0;
    
        try {
            slice = Double.parseDouble(args[0]);
	    } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
            slice = 60;
            System.err.println("Defaulted to " + slice);
        } catch(NumberFormatException e) {
            System.err.println(e);
            slice = 60;
            System.err.println("Defaulted to " + slice);
        } catch ( Exception e ) {
	        System.err.println(e);
            slice = 60;
            System.err.println("Defaulted to " + slice);
	    } 
        try {
	        angleInput = Double.parseDouble(args[1]);
	    } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
            angleInput = 180;
            System.err.println("Defaulted to " + angleInput);
        } catch(NumberFormatException e) {
            System.err.println(e);
            angleInput = 180;
            System.err.println("Defaulted to " + angleInput);
        } catch ( Exception e ) {
	        System.err.println(e);
            angleInput = 180;
            System.err.println("Defaulted to " + angleInput);
	    } 
        
        Clock c = new Clock(slice);
        
	    System.out.println("slice: " + slice);
        System.out.println("Current time: " + c);
    
        while (c.hours() < 12) {
            c.tick();
            
            if(c.angle() <= angleInput+(5.5/60 * slice)/2.0 & 
            c.angle() >= angleInput-(5.5/60 * slice)/2.0 |
            360 - c.angle() <= angleInput+(5.5/60 * slice)/2.0 & 
            360 - c.angle() >= angleInput-(5.5/60 * slice)/2.0) {
                System.out.println("Current time: " + c);
            }
        }
    }
}