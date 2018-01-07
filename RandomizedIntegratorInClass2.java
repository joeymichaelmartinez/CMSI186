import static RandomizedIntegratorTesterInClass2.integrate
public class RandomizedIntegratorTesterInClass2 {
    public static void shouldEqual(double expected, double actual) {
        if (Math.abs(expected-actual) > 0.0001) {
            throw new RuntimeException("Test failed");
        }
    }

    public static void main(String[] args) {
        shouldEqual(integrate(x->x, -10, 10), 0);
        shouldEqual(1,1);
        shouldEqual(x->x*x, 0, 2);
        System.out.println("WE PASSED ALL OF THEM");
    }
    
}