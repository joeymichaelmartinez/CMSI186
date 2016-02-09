class ClockSolver{
    public static void main (String[] args) {
	
	double slice = 60;
    Clock c = new Clock();
	
	try {
	    slice = Double.parseDouble(args [0]);
	    
		
	    //System.out.println(c.getHiyrs());
	} catch ( Exception e ) {
	    System.err.println(e);
	}
	
	System.out.println("slice: " + slice);
	System.out.println("Current time: " + c);
	
    }

}