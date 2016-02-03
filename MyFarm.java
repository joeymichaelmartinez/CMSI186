public class MyFarm{
    public static void main(String[] args){
	    Cow C1 = new Cow();
	    C1.moo();
		Cow C2 = new Cow();
		C2.moo();
        Cow [] cows = new Cow[5];
        Cow.herd(cows);
	}
}