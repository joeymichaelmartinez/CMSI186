class Clock {
    private double seconds;
    
    public Clock(){
        this.seconds = 0;
    }
      
    public tick() {
        this.seconds++;
    }

    public double getMinutes(){
        double minutes = seconds/60;
        return minutes;
        
    }
    
    public toString(){
        
        
    }
}