public class RandomizedIntegrator {
    
    
    
    
    private Rectangle getBoundingBox(Function f, xMin, xMax) {
        Rectangle boundingBox = new Rectangle(
        boundingBox.x1 = xMin;
        boundingBox.x2 = xMax;
        boundingBox.y1 = findYMin(f, xMin, xMax);
        boundingBox.y2 = findYMax(f, xMin, xMax);
        
        )
        
        return boundingBox;
    }
    
    public double findYMin(Function f, xMin, xMax) {
        double[] points;
        points = new points[1000];
        double yMin = 0;
        for(int i = 0; i <= 1000; i++) {
            points[i] = Math.sin((int) Math.floor(Math.random() * xMin + xMax));
            if(points[i] < points[i-1]){
                yMin = points[i];
            }
        }
        
    }
    
    public double findYMax(Function f, xMin, xMax) {
        double[] points;
        points = new points[1000];
        double yMax = 0;
        for(int i = 0; i <= 1000; i++) {
            points[i] = Math.sin((int) Math.floor(Math.random() * xMin + xMax));
            if(points[i] > points[i-1]){
                yMax = points[i];
            }
        }
        
    }
    
    public static double integrate(Function f, double a, double b) {
        Rectangle boundingBox = getBoundingBox(f, a, b);
        double area = generatePoints(f, boundingBox);
        return area;
    }
    
    public static void main(String[] args){
        Function f = x-> x*x; // TODO: Actually read it in
        double a = 0.0; // TODO: actually read it in
        double b = 0.0; // TODO: actually read it in
        //TODO: Read args
        //TODO: Make the function
        System.out.println(integrate(f, a, b));
    }
    
    public double generatePoints (Function f, boundingBox) {
        double pointsInRange = 0; 
        for (int i = 0; i <= 1000000; i++) {
            double randomX = (int) Math.floor(Math.random() * boundingBox.x1 + boundingBox.x2));
            double randomY = (int) Math.floor(Math.random() * boundingBox.y1 + boundingBox.y2));
            if (Math.sin(randomX) > 0 && randomY > 0 ) {
                if (y < Math.sin(randomX)) {
                    pointsInRange++;
                }
            }
        } 
        return (pointsInRange/1000000) * boundingBox.area;
    }
    
}

