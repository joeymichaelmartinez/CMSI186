import java.lang.Math;

public class Triangle extends Shape{
    private double vertexX1, vertexY1, vertexX2, vertexY2, vertexX3, vertexY3;
    private double area;
    private Point a, b, c;
    private Rectangle boundingBox;
    private int pointsIn;
    
    public Triangle(Point a, Point b, Point c) {
        this.vertexX1 = a.getX();
        this.vertexY1 = a.getY();
        this.vertexX2 = b.getX();
        this.vertexY2 = b.getY();
        this.vertexX3 = c.getX();
        this.vertexY3 = c.getY();
        this.a = a;
        this.b = b;
        this.c = c;
        this.boundingBox = makeBoundingBox();
    }
    
    public Rectangle makeBoundingBox() {
        double xMin = Math.min(Math.min(this.a.getX(),this.b.getX()),this.c.getX());
        double xMax = Math.max(Math.max(this.a.getX(),this.b.getX()),this.c.getX());
        double yMin = Math.min(Math.min(this.a.getY(),this.b.getY()),this.c.getY());
        double yMax = Math.max(Math.max(this.a.getY(),this.b.getY()),this.c.getY());
        return new Rectangle(xMin,xMax,yMin,yMax);
    } 
    
    @Override
    public Rectangle getBoundingBox() {
        return this.boundingBox;
        
    }
    
    public Point getA() {
        return this.a;
    }
    
    public Point getB() {
        return this.b;
    }
    
    public Point getC() {
        return this.c;
    }
    
    
    
    /*public double getVertexY1() {
        return this.vertexY1;
    }
    
    public double getVertexX2() {
        return this.vertexX2;
    }
    
    public double getVertexY2() {
        return this.vertexY2;
    }
    
    public double getVertexX3() {
        return this.vertexX3;
    }
    
    public double getVertexY3() {
        return this.vertexY3;
    }*/
    
    public double dot(Point p1, Point p2) {
        double dotProduct = ((p1.getX() * p2.getX()) + (p1.getY() * p2.getY()));
        return dotProduct;
    }
        
    @Override
    public boolean insidePoint(Point p) {
        Point v0 = new Point(this.c.getX() - this.a.getX(), this.c.getY() - this.a.getY());
        Point v1 = new Point(this.b.getX() - this.a.getX(), this.b.getY() - this.a.getY());
        Point v2 = new Point(p.getX() - this.a.getX(), p.getY() - this.a.getY());
        
        double dot00 = dot(v0, v0);
        double dot01 = dot(v0, v1);
        double dot02 = dot(v0, v2);
        double dot11 = dot(v1, v1);
        double dot12 = dot(v1, v2);
        
        double invDenom = 1 / (dot00 * dot11 - dot01 * dot01);
        double u = (dot11 * dot02 - dot01 * dot12) * invDenom;
        double v = (dot00 * dot12 - dot01 * dot02) * invDenom;
        
        
        return (u >= 0) && (v >= 0) && (u + v < 1);
    }
    
    public void pointsIn(){
        this.pointsIn++;
        
    }
    
    public double getPointsIn(){
        return this.pointsIn;
    }
    
    /*boolean inside = false;
        double Area = 1/2*(-this.b.getY()*this.c.getX() + this.a.getY()*(-this.b.getX() + this.c.getX()) + this.a.getX()*(this.b.getY() - this.c.getY()) + this.b.getX()*this.c.getY());
        double s = 1/(2*Area)*(this.a.getY()*this.c.getX() - this.a.getX()*this.c.getY() + (this.c.getY() - this.a.getY())*p.getX() + (this.a.getX() - this.c.getX())*p.getX());
        double t = 1/(2*Area)*(this.a.getX()*b.getY() - this.a.getY()*this.b.getX() + (this.a.getY() - this.b.getY())*p.getX() + (this.b.getX() - this.a.getX())*p.getX());
        System.out.println(this.a.getY()*this.c.getX() - this.a.getX()*this.c.getY() + (this.c.getY() - this.a.getY())*p.getX() + (this.a.getX() - this.c.getX())*p.getX());
        System.out.println(area);
        if (s >= 0 || t >= 0 || 1-s-t > 0) {
            inside = true;
    
    public static double sign(Point a, Point b, Point c){
        return (a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY());
    }

    public static boolean PointInTriangle(Point p, Point a, Point b, Point c)
    {
    boolean b1, b2, b3;

    b1 = sign(p, a, b) < 0;
    b2 = sign(p, b, c) < 0;
    b3 = sign(p, c, a) < 0;

    boolean finalBoolean = ((b1 == b2) && (b2 == b3));
    return finalBoolean;
}*/
    
    /*public double getArea() {
        this.area = (this.x2-this.x1)*(this.y2-this.y1);
        return this.area;
    }*/
}