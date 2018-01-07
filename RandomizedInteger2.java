public class RandomizedIntegrater {
    
    public class RandomizedInteger {
    
        private Rectangle boundingBox =
            new Rectangle(0, 0, 2, 1);
    private int insidePoints = 0;
    private int totalPoints = 
   }
    
    
    public double areaOfOneHalfFromZeroTo2() {
        return (insidePoints/totalPoints) * boundingBoxArea();
    }
    
    public double boundingBoxArea() {
        return boundBox.getWidth * boundingBox.getHeight;
    }
    
    public static void main(String[] args) {
        System.out.println("We are alive");
    }
    
    
}