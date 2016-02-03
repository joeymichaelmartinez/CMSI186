public class Cow {
    String name;
	//Leg legs;
	//Head head;
	String gender;
    

    public Cow(){
        this.name = "Betsy";
    }

    public Cow(String name) {
        this.name = name;
    } 

    public void moo() {
        System.out.println("moo");
    }
    public static void herd(Cow [] cows) {
        System.out.println("herded cows");

    }
	
    public static void main(String[] args) {
	
	}

}