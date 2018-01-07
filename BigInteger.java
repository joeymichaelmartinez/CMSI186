import java.util.Arrays;

public class BigInteger {
    
    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger TEN = new BigInteger("10");
    private String number;    
    private int [] digits;
   
    private int sign = 0;
   

    public BigInteger ( String number ) {
        if(number.charAt(0) == '-') {
            number = number.substring(1, number.length());
            this.sign = -1;
        } 
        
        else if (number.charAt(0) == '0' && number.length() == 1) {
            this.sign = 0;
        }
        
        else {
            this.sign = 1;
        }
        
        int length = number.length();        
        this.digits = new int[length];
        
        if (this.sign == -1) {
        System.out.println("string: " + "-" + number);
        }
        
        else {
         System.out.println("string: " + number);
        }
        
        int index = 0;
        for (int i = 0; i <= length - 1; i++ ) {
            char c = number.charAt(i);    
            //System.out.println("char: " + c);
            this.digits[index] = Character.getNumericValue(c);
            index++;
            }
        System.out.println(Arrays.toString(this.digits));
    }
    
    
    
    public BigInteger sameSize (BigInteger val) {
        String zeroString = "";
        String counter = "0";
        
        if(this.digits.length > val.digits.length) {
            for(int i = 0; i < this.digits.length - val.digits.length; i++) {
                zeroString += counter;
            }
        val = new BigInteger(zeroString + val.toString2());
        }
        
        return val;
    }

    
    public BigInteger add ( BigInteger val ) {
        int carryOut = 0;
        BigInteger this2 = this;
        
        
            if ((this.sign == -1 && val.sign == 1) || (this.sign == 1 && val.sign == -1)) {
                if (this.digits.length > val.digits.length) { 
                    val = this.sameSize(val);
                }
            
                else if (this.digits.length < val.digits.length) {
                    this2 = val.sameSize(this2);
                    this.digits = this2.digits;
                }
            
                if (this.toString() == "-" + val.toString() || val.toString() == "-" + this.toString()){
                    this.digits = ZERO.digits;
                }
                
                else if (this.compareToAbs(val) == 1)
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        
                        
                        if (this.digits[i] < val.digits[i]) {
                            this.digits[i-1] = this.digits[i-1] - 1;
                            this.digits[i] = (this.digits[i] + 10) - val.digits[i];
                        }
                    
                        else{
                            this.digits[i] = this.digits[i] - val.digits[i];
                        }
                    }
            
                else if (this.compareToAbs(val) == -1) {
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        if (val.digits[i] < this.digits[i]) {
                            val.digits[i-1] = val.digits[i-1] - 1;
                            val.digits[i] = (val.digits[i] + 10) - this.digits[i];
                        }
                        else {
                            val.digits[i] = val.digits[i] - this.digits[i];
                        }
                    }
                    this.digits = val.digits; 
                    this.sign = -1;
                    
                }
            }
            
            
            else {
                
                if (this.digits.length > val.digits.length ) { 
                    val = this.sameSize(val);
                    val = new BigInteger("0" + val.toString2());
                    this2 = new BigInteger("0" + this.toString2());
                    this.digits = this2.digits;
                }
            
                else if (this.digits.length < val.digits.length) {
                    this2 = val.sameSize(this2);
                    this2 = new BigInteger("0" + this2.toString2());
                    this.digits = this2.digits;
                    val = new BigInteger("0" + val.toString2());
                }
        
                else if (this.digits.length == val.digits.length) {
                    this2 = new BigInteger("0" + this.toString2());
                    this.digits = this2.digits;
                    val = new BigInteger("0" + val.toString2());
                }
        
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        this.digits[i] = this.digits[i] + val.digits[i] + carryOut;
            
                        if(this.digits[i] >= 10){
                        carryOut = this.digits[i]/ 10;
                            this.digits[i] = this.digits[i] % 10;
                        }
                        else {
                            carryOut = 0;
                        }
                    }
            }
        return this;
    }
    
    public BigInteger subtract ( BigInteger val ) {
        BigInteger this2 = this;
        int carryOut = 0;
            if ((this.sign == -1 && val.sign == 1) || (this.sign == 1 && val.sign == -1)) {
               if (this.digits.length > val.digits.length ) { 
                    val = this.sameSize(val);
                    val = new BigInteger("0" + val.toString2());
                    this2 = new BigInteger("0" + this.toString2());
                    this.digits = this2.digits;
                }
            
                else if (this.digits.length < val.digits.length) {
                    this2 = val.sameSize(this2);
                    this2 = new BigInteger("0" + this2.toString2());
                    this.digits = this2.digits;
                    val = new BigInteger("0" + val.toString2());
                }
        
                else if (this.digits.length == val.digits.length) {
                    this2 = new BigInteger("0" + this.toString2());
                    this.digits = this2.digits;
                    val = new BigInteger("0" + val.toString2());
                }
        
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        this.digits[i] = this.digits[i] + val.digits[i] + carryOut;
            
                        if(this.digits[i] >= 10){
                        carryOut = this.digits[i]/ 10;
                            this.digits[i] = this.digits[i] % 10;
                        }
                        else {
                            carryOut = 0;
                        }
                    }
            }
            
            
            else {
                if (this.digits.length > val.digits.length) { 
                    val = this.sameSize(val);
                }
            
                else if (this.digits.length < val.digits.length) {
                    this2 = val.sameSize(this2);
                    this.digits = this2.digits;
                }
            
                if (this.compareTo(val) == 0){
                    this.digits = ZERO.digits;
                }
                
                else if (this.compareToAbs(val) == 1)
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        
                        
                        if (this.digits[i] < val.digits[i]) {
                            this.digits[i-1] = this.digits[i-1] - 1;
                            this.digits[i] = (this.digits[i] + 10) - val.digits[i];
                        }
                    
                        else{
                            this.digits[i] = this.digits[i] - val.digits[i];
                        }
                    }
            
                else if (this.compareToAbs(val) == -1) {
                    for(int i = this.digits.length - 1; i >= 0; i--) {
                        if (val.digits[i] < this.digits[i]) {
                            val.digits[i-1] = val.digits[i-1] - 1;
                            val.digits[i] = (val.digits[i] + 10) - this.digits[i];
                        }
                        else {
                            val.digits[i] = val.digits[i] - this.digits[i];
                        }
                    }
                    this.digits = val.digits; 
                    this.sign = -1;
                    
                }
            }
        return this;
    }
    
    public BigInteger multiply ( BigInteger val ) {
        
        throw new UnsupportedOperationException();
    }
    
    public BigInteger divide ( BigInteger val ) {
        
        throw new UnsupportedOperationException();
    }
    
    public BigInteger remainder ( BigInteger val ) {
        
        throw new UnsupportedOperationException();
    }
    
    private int numberOfZeros( int[] digits ) {
        int numberOfZeros = 0;
        int i = 0;
        while (this.digits[i] == 0 && i != this.digits.length - 1) {
                    numberOfZeros++;
                    i++;
        }
        return numberOfZeros;
    }
    
    public String toString () {
        String index = "";
        String stringNumber = "";
        String result = "";
        if (this.sign == 0 || this.digits.length == numberOfZeros(this.digits)){
            stringNumber = "0";
            result = stringNumber;
        }
       
        else{
            for (int i = numberOfZeros(this.digits); i < this.digits.length; i++) {
                index = Integer.toString(this.digits[i]);
                stringNumber += index;
                }
        
            if (this.sign == 1) {
                result = stringNumber;
            }
            
            else if (this.sign == -1 && this.digits.length != numberOfZeros(this.digits)) {
                result = "-" + stringNumber;
            }
        }
        return result;
    }
    
    public String toString2() {
        String index = "";
        String stringNumber = "";
        String result = "";
        
        if (this.sign == 0 || this.digits.length == numberOfZeros(this.digits)){
            stringNumber = "0";
            result = stringNumber;
        }
        
        else{
            for (int i = 0; i < this.digits.length; i++) {
                index = Integer.toString(this.digits[i]);
                stringNumber += index;
            }
        
            if (this.sign == 1) {
                result = stringNumber;
            }
            
            else if (this.sign == -1 && this.digits.length != numberOfZeros(this.digits)) {
                result = "-" + stringNumber;
            }
        }
          
        return result;
    }
    
    public boolean equals ( Object x ) {
        if(this == x) {
            return true;
        }
        
        if( x == null) {
            return false;
        }
        
        if(this.getClass() != x.getClass()) {
            return false;
        }
        
        BigInteger other = (BigInteger)x;
        
        return this.toString().equals(other.toString());
    }
    
    public int compareToAbs ( BigInteger val ) {
        int returnValue = 0;

        
            if (this.toString().length() == val.toString().length()) {
                int i = 0;
                int j = 0;
                while (i != 1) {
                    if(this.digits[this.numberOfZeros(this.digits) + j] > val.digits[val.numberOfZeros(val.digits) + j]){
                        if (this.sign == -1) {
                            returnValue = -1;
                            i=1;
                        }
                        else {
                        returnValue = 1;
                        i = 1;
                        }
                    }
                    else if(this.digits[this.numberOfZeros(this.digits) + j] < val.digits[val.numberOfZeros(val.digits) + j]) {
                        if (this.sign == -1) {
                            returnValue = 1;
                        }
                        else {
                            returnValue = -1;
                        }
                        i = 1;
                    }
                    else if (this.digits[this.numberOfZeros(this.digits) + j] == val.digits[val.numberOfZeros(val.digits) + j]) {
                        j++;
                        if(j == this.digits.length - this.numberOfZeros(this.digits)) {
                            returnValue = 0;
                            i = 1;
                        }
                    }
                }
            }
        
            else if (this.toString().length() > val.toString().length()) {
                returnValue = 1;
            }
            else if (this.toString().length() < val.toString().length()) {
                returnValue = -1;
            }
            return returnValue;
    }
    
    public int compareTo ( BigInteger val ) {
        int returnValue = 0;

        if (this.sign > val.sign) {
            returnValue = 1;
        }
        
        else if (this.sign < val.sign) {
            returnValue = -1;
        }
        
        else {
            if (this.toString().length() == val.toString().length()) {
                int i = 0;
                int j = 0;
                while (i != 1) {
                    if(this.digits[this.numberOfZeros(this.digits) + j] > val.digits[val.numberOfZeros(val.digits) + j]){
                        if (this.sign == -1) {
                            returnValue = -1;
                            i=1;
                        }
                        else {
                        returnValue = 1;
                        i = 1;
                        }
                    }
                    else if(this.digits[this.numberOfZeros(this.digits) + j] < val.digits[val.numberOfZeros(val.digits) + j]) {
                        if (this.sign == -1) {
                            returnValue = 1;
                        }
                        else {
                            returnValue = -1;
                        }
                        i = 1;
                    }
                    else if (this.digits[this.numberOfZeros(this.digits) + j] == val.digits[val.numberOfZeros(val.digits) + j]) {
                        j++;
                        if(j == this.digits.length - this.numberOfZeros(this.digits)) {
                            returnValue = 0;
                            i = 1;
                        }
                    }
                }
            }
        
            else if (this.toString().length() > val.toString().length()) {
                returnValue = 1;
            }
            else if (this.toString().length() < val.toString().length()) {
                returnValue = -1;
            }
        }
            return returnValue;
    }
    
    public static BigInteger valueOf ( long val ) {
        
        String str = Long.toString(val);
        BigInteger b = new BigInteger(str);
        return b;
    }
     
    public static void main (String[] args) {
        BigInteger Big1 = new BigInteger("1");
        BigInteger Big2 = new BigInteger("-1");
        long Big3 = 0;
        
        System.out.println(Big1.compareToAbs(Big2));
        //System.out.println(Big2);
    }
}