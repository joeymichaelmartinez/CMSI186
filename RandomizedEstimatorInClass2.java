public class RandomizedEstimatorTesterInClass {
    public void testOneCirceAndOneTriangle() {
        Circle c = new Circle(new Point(0,0), 1);
        Triangle t = new Triangle (
                    new Point(2,0),
                    new Point(2,0),
                    new Point(0,2)
                    );
    
        RandomizedEstimator re =
                new RandomizedEstimator (c, t);
            asserCloseTo(re.areaOfOverlap:(), Math.PI/4);
    }
    
    private static void assertCloseTo(double actual, double expected) {
        if (Math.abs(actual-expected)/actual > 0.01) {
            throw new RuntimeException("FAIL");
        }
    
    }

}
