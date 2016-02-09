class ClockInClass {
    private double hours;
    private double minutes;
    private double seconds;

    public Clock () {
        
	    this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
		}

    public double hours() {
		
        return this.hours;
    }
	
	public double minutes() {
		return this.minutes;
    }

	public void tick() {
		this.second++;
		
		if(this.seconds >= 60) {
			this.minutes++;
			this.seconds = 0;
		}
		
		if (this.minutes >== 60) {
			this.hours++;
			this.minutes = 0;
		}
	}
	
	public double seconds(){
		return this.seconds;
	}
	//not quite right yet
	public void tick() {
		
		
	}
	public String toString() {
		
		return (int)this.hours + ":" + (int)this.minutes + ":" + (int)this.seconds;
 	}
		
	
}