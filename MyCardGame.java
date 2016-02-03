import java.util.Arrays; 
 class MyCardGame {
    public static void main(String[] args) {
	    Card c = new Card(5, 1);
		System.out.println(c.getRank()); //5
	    System.out.println(c.toString());    //option autocalled by Java
	int[] test = new int[3];
	test[0] = 5;
	test[1] = 10;
	test[2]= 2000;
	System.out.println(Arrays.toString(test));
	Deck d = new Deck();
	System.out.println(d);
	}
}