public class RandomizedIntegrater2 {
    
    public class RandomizedIntegrater {
    
        private Rectangle boundingBox =
            new Rectangle();
        private int insidePoints = 0;
        private int totalPoints = 
    }
    
    
    public double areaOfOneHalfFromZeroTo2() {
        return (insidePoints/totalPoints) * boundingBoxArea();
    }
    
    public double boundingBoxArea() {
        return boundingBox.getWidth * boundingBox.getHeight;
    }
    
    public static void main(String[] args) {
        
    }
    
    
}