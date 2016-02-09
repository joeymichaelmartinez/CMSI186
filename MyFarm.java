public class MyFarm{
    public static void main(String[] args){
	    Cow C1 = new Cow("Jerry");
	    C1.moo();
		Cow C2 = new Cow();
		C2.moo();
        Cow [] cows = new Cow[5];
        Cow.herd(cows);
        System.out.println(C1.name);
	}
}