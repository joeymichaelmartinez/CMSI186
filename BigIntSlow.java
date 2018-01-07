//This is not the answer
//This is just to help you understand another possible way of doing things
//This is a non-scalable solution
//This example assumes you have your storage already set 
//I.E. using an array (or whatever) to store your big integer

class BigIntSlow {
    
    private int number;
    
    //First constructor that takes in a string
    public BigIntSlow( String number ) {
        
        this.number = Integer.parseInt(number);
    
    }
    
    //second constructor which takes in an "int"
    public BigIntSlow( int value ) {
        
        this.number = value;
        
    }
   
    public int getValue() {
        return this.number;
        
    }
   
    public BigIntSlow add ( BigIntSlow value ) {
        int answer = this.number; 
        for (int i = 0; i < value.getValue(); i++) {
            
            answer++;
            
        }
        return new BigIntSlow(answer);
    }
    
    public String toString() {
        //return (string) this.number;
        return Integer.toString(this.number);
    }

    public static void main ( String[] args ) {
    
        BigIntSlow b1 = new BigIntSlow("123");
        
        BigIntSlow b2 = new BigIntSlow("456");
    
        BigIntSlow b3 = b1.add(b2);
    
        System.out.println(b3);
    }
}