public class Circle extends Shape{
    private double x, y, r;
    private double area;
    private Point center;
    private Rectangle boundingBox;
    private int pointsIn;
    
    public Circle(Point center,  double r) {
        this.x = center.getX();
        this.y = center.getY();
        this.r = r;
        this.center = center;
        this.boundingBox = new Rectangle(x - r, x + r, y - r, y + r);
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getR() {
        return this.r;
    }
    
    @Override
    public Rectangle getBoundingBox() {
        return this.boundingBox;
    }
    
    
    public boolean insidePoint(Point p) {
        //System.out.println(center.getX() + " " + center.getY() );
        return center.getDistance(p) < r;
        
    }
    
    public void pointsIn(){
        this.pointsIn++;
        
    }
    
    public double getPointsIn(){
        return this.pointsIn;
    }
    
    /*public double getArea() {
        this.area = (this.x2-this.x1)*(this.y2-this.y1);
        return this.area;
    }*/
}