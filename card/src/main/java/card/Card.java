package card;

public class Card {
    private int[] cardNumber;
    private CardIin iin;

    public Card(){
    	this.cardNumber = new int[16];
    	this.iin = CardIin.NONE;
    }
    
    public int[] getCardNumber() {
    	return this.cardNumber;
    }
}