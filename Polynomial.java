public class Polynomial {

public static Function poly = (x,args) -> {
        double arbitraryX = x;
        double[] coefficients = new double[args.length];       
        for(int i = 0; i < coefficients.length; i++) {
                coefficients[i] = args[i];
                //System.out.println(coefficients.length); 
        
        //System.out.println(coefficients[i]); 
        //System.out.println(i); 
        
        }
        
        double result = 0;
        for(int i = 0; i < coefficients.length; i++) {
            result += coefficients[i]*Math.pow(arbitraryX, i);
            System.out.println(result + " " + i);
        }
        
        return result;
    };
    public static void main (String[] args) {
        System.out.println(poly.eval(1,new double[]{3,2,1, 0}));
    }


public static double randomWithRange(double min, double max){
        double range = (max - min);     
        //System.out.println((Math.random() * range) + min);
        return (Math.random() * range) + min;
    }
    
}