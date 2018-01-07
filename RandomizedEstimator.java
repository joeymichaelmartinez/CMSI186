import java.util.Arrays;
public class RandomizedEstimator {

    Object[] shapes;
    
    public RandomizedEstimator(Object[] shapes) {
        this.shapes = shapes;
    }
    
    public static void estimate(Shape[] shapes) {
        Rectangle boundingBox = getBoundingBox(shapes);
        generatePoints(shapes, boundingBox);
    }

        double xMin = 0;

    
    public static Rectangle getBoundingBox(Shape[] shapes) {
    double xMin = shapes[0].getBoundingBox().getX1();
        for(int i = 0; i < shapes.length; i++) {
            if(xMin > shapes[i].getBoundingBox().getX1()) {
                xMin = shapes[i].getBoundingBox().getX1();
            }
        }
        
        double xMax = shapes[0].getBoundingBox().getX2();
        for(int i = 0; i < shapes.length; i++) {
            if(xMax < shapes[i].getBoundingBox().getX2()) {
                xMax = shapes[i].getBoundingBox().getX2();
            }
        }
        
        double yMin = shapes[0].getBoundingBox().getY1();
        for(int i = 0; i < shapes.length; i++) {
            if(yMin > shapes[i].getBoundingBox().getY1()) {
                yMin = shapes[i].getBoundingBox().getY1();
            }
        }
        
        double yMax = shapes[0].getBoundingBox().getY2();
        for(int i = 0; i < shapes.length; i++) {
            if(yMax < shapes[i].getBoundingBox().getY2()) {
                yMax = shapes[i].getBoundingBox().getY2();
            }
        }
        
        Rectangle boundingBox = new Rectangle(xMin, xMax, yMin, yMax);
        return boundingBox;
    }
    
    public static void generatePoints(Shape[] shapes, Rectangle boundingBox) {
        double inUnion = 0;
        double inAll = 0; 
        double inOnlyOne = 0;
        double inShape = 0;
        
        for (int i = 0; i <= 1000000; i++) {
            double randomX = randomWithRange(boundingBox.getX1(), boundingBox.getX2());
            double randomY = randomWithRange(boundingBox.getY1(), boundingBox.getY2());
            Point randomPoint = new Point(randomX, randomY);
            inShape = 0;
            for(int j = 0; j < shapes.length; j++) {
                if(shapes[j].insidePoint(randomPoint)) {
                    inShape++;
                    shapes[j].pointsIn();
                    
                }
                
                if(inShape == shapes.length) {
                        inAll++;
                }
                
            }
            
            for(int j = 0; j < shapes.length; j++) {
                if(shapes[j].insidePoint(randomPoint) && inShape == 1) {
                    inOnlyOne++;
                }
            }
            for(int j = 0; j < shapes.length; j++) {
                if(shapes[j].insidePoint(randomPoint)) {
                    inUnion++;
                    break;
                }
            }
        
        
        }
        double[] shapeAreas = new double[shapes.length];
        for (int i = 0; i < shapeAreas.length; i++) {
            shapeAreas[i] = shapes[i].getPointsIn()/1000000 * boundingBox.getArea();
        }
        System.out.println("Individual Shapes: " + Arrays.toString(shapeAreas));
        System.out.println("Union of Shapes: " + inUnion/1000000 * boundingBox.getArea());
        System.out.println("Intersection: " + inAll/1000000 * boundingBox.getArea());
        System.out.println("Non-Intersection: " + inOnlyOne/1000000 * boundingBox.getArea());
    }
    
    public static double randomWithRange(double min, double max){
        double range = (max - min);     
        return (Math.random() * range) + min;
    }
    
    public static void main (String[] args) {
        int numShapes = 0;
        for (int i = 0; i < args.length; i++) {
            try{
                Double.parseDouble(args[i]);
            }catch (Exception e){
                numShapes++;
            }    
        }
        
        Shape[] shapes = new Shape[numShapes];
        
        int j = 0;
        
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("circle")) {
                Point center = new Point(Double.parseDouble(args[i+1]), Double.parseDouble(args[i+2]));
                shapes[j] = new Circle(center, Double.parseDouble(args[i+3]));
                j++;
            }
            
            else if (args[i].equals("triangle")) {
                Point a = new Point(Double.parseDouble(args[i+1]), Double.parseDouble(args[i+2]));
                Point b = new Point(Double.parseDouble(args[i+3]), Double.parseDouble(args[i+4]));
                Point c = new Point(Double.parseDouble(args[i+5]), Double.parseDouble(args[i+6]));
                shapes[j] = new Triangle(a, b, c);
                j++;
            }
        }
        
                estimate(shapes);
        
        
    }
}