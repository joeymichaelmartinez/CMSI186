class ClockSolver {
    public static void main (String[] args) {
		double slice = 0;
	    
		
		// comment
		
		try {
		    slice = Double.parseDouble(args[0]);
		
		} catch (ArrayIndexOutOfBoundsException e) {
		   slice = 60.0;
	    
		} catch (Exception e ) {
			
			System.out.println(e);
		}
		System.out.println(slice);
    }
}