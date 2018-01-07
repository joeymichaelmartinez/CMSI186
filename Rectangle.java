public class Rectangle {
    private double x1, x2, y1, y2;
    private double area;
    
    public Rectangle(double x1, double x2,  double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    
    public double getX1() {
        return this.x1;
    }
    
    public double getX2() {
        return this.x2;
    }
    
    public double getY1() {
        return this.y1;
    }
    
    public double getY2() {
        return this.y2;
    }
    
    public double getArea() {
        this.area = (this.x2-this.x1)*(this.y2-this.y1);
        return this.area;
    }
}