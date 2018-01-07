public class RandomizedIntegrator {
 
    public static Function sin = (x,args) -> Math.sin(x);
    public static Function cos = (x,args) -> Math.cos(x);
    public static Function sqrt = (x,args) -> Math.sqrt(x); 
    public static Function log = (x,args) -> Math.log(x);
    public static Function exp = (x,args) -> Math.exp(x);
    public static Function poly = (x,args) -> {
        double arbitraryX = x;
        double[] coefficients = new double[args.length-2];       
        for(int i = 0; i < coefficients.length; i++) {
                coefficients[i] = args[i];
        
        }
        
        double result = 0;
        for(int i = 0; i < coefficients.length; i++) {
            result += coefficients[i]*Math.pow(arbitraryX, i);
        }
        
        return result;
    };
    
    
    public static Rectangle getBoundingBox(Function f, double[]args) {
        Rectangle boundingBox = new Rectangle(
        args[args.length-2],
        args[args.length-1],
        findYMin(f, args),
        findYMax(f, args)
        
        );
        
        return boundingBox;
    }
    
    public static double findYMin(Function f, double[] args) {
        double xMin = args[args.length-2];
        double xMax = args[args.length-1];
        double[] points;
        points = new double[1000000];
        double yMin = 0;
        for(int i = 1; i < 1000000; i++) {
            points[i] = f.eval(randomWithRange(xMin, xMax), args);
            if(points[i] < yMin){
                yMin = points[i];
            }
        }
        return yMin;
    }
    
    public static double findYMax(Function f, double[] args) {
        double xMin = args[args.length-2];
        double xMax = args[args.length-1];
        double[] points;
        points = new double[1000000];
        double yMax = f.eval(randomWithRange(xMin, xMax), args);
        
        for(int i = 1; i < 1000000; i++) {
            points[i] = f.eval(randomWithRange(xMin, xMax), args);
            if(points[i] > yMax){
                yMax = points[i];
            }
        }
        return yMax * 1.2;
    }
    
    public static double integrate(Function f, double[] args) {
        Rectangle boundingBox = getBoundingBox(f, args);
        double area = generatePoints(f, boundingBox, args);
        return area;
    }
    
    
    public static double generatePoints(Function f, Rectangle boundingBox, double[] args) {
        double pointsInRange = 0; 
        for (int i = 0; i <= 1000000; i++) {
            double randomX = randomWithRange(boundingBox.getX1(), boundingBox.getX2());
            double randomY = randomWithRange(boundingBox.getY1(), boundingBox.getY2());
            if (f.eval(randomX, args) > 0 && randomY > 0 ) {
                if (randomY <= f.eval(randomX, args)) {
                    pointsInRange++;
                }
            }
            if (f.eval(randomX, args) < 0 && randomY < 0 ) {
                if (randomY >= f.eval(randomX, args)) {
                    pointsInRange--;
                }
            }
        } 
        return (pointsInRange/1000000) * boundingBox.getArea();
    }
    
    public static double randomWithRange(double min, double max){
        double range = (max - min);     
        return (Math.random() * range) + min;
    }
    
    public static void main(String[] args){
        double xMin = Double.parseDouble(args[1]);
        double xMax = Double.parseDouble(args[2]);
        double[] newArgs = new double[args.length-1];
        for(int i = 1; i < args.length; i++){
            newArgs[i-1] = Double.parseDouble(args[i]);
        }
        switch(args[0]){
            case "sin":
            System.out.println(integrate(sin, newArgs));
            break;
            case "cos": 
            System.out.println(integrate(cos, newArgs));
            break;
            case "sqrt":
            System.out.println(integrate(sqrt, newArgs));
            break;
            case "log":
            System.out.println(integrate(log, newArgs));
            break;
            case "exp":
            System.out.println(integrate(exp, newArgs));
            break;
            case "poly":
            xMin = Double.parseDouble(args[args.length - 2]);
            xMin = Double.parseDouble(args[args.length -1]);
            System.out.println(integrate(poly, newArgs));
            break;
        }
    }
}

