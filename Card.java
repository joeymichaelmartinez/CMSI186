class  Card {    
    private int rank;    //attributes
    private int suit;
	public Card(int rank, int suit) {    //constructor
	    this.rank = rank;
		this.suit = suit;
	}
	public int getRank() {   //methods
	    return this.rank;    // getters/setters?
	}
    public int getSuit() {  
		return this.suit;
	}	
    public String toString() {
		return "Rank: " + this.rank + " Suit: " + this.suit;
	}
}