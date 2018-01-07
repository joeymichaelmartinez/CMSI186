import java.util.scanner;

public class PokeInsult {
    public static void main (String[] args) {
        System.out.println("Tell me your top cp Pokemon");
        Scanner input = new Scanner(System.in);
        
        int cp = Integer.parseInt(input.nextLine());
        
        if (cp < 1000) {
            System.out.println("how very sad to be you");
        } else {
            System.out.println("oh, well mine is" + cp + 1);
        }
    }


}