package card;

import java.util.List;
import java.util.Random;

public class Card {
    private int[] cardNumber;
    private CardIin iin;
    
    /**
     * 생성자
     * @return Return any card number of any brand.
     */
    public Card(){
    	CardIin[] iins = {
        	CardIin.AMEX,
        	CardIin.CIRRUS,
        	CardIin.DISCOVER,
        	CardIin.DINERSCLUB,
        	CardIin.JCB,
        	CardIin.MAESTRO,
        	CardIin.MASTER,
        	CardIin.UNIONPAY,
        	CardIin.VISA
    	};
    	Random r = new Random();
    	int selectedIndex = r.nextInt(iins.length-1);
    	this.iin = iins[selectedIndex];
    	this.cardNumber = new int[iin.getLength()];
    	this.generateCardNumber();
    }
  
    /**
     * 생성자
     * @return Return any card number of the brand received as parameter.
     */
    public Card(CardIin iin){
    	this.cardNumber = new int[iin.getLength()];
    	this.iin = iin;

    	this.generateCardNumber();
    }
    
    public String getCardNumber() {
    	StringBuilder str = new StringBuilder();
    	for(int e: this.cardNumber)
    		str.append(e);
    	return str.toString();
    }
    
    private void generateCardNumber() {
    	int cardNumberLength = this.iin.getLength();
    	int[] cardNumber = new int[cardNumberLength];
    	
    	// IIN 앞자리 목록 가져오기
    	List<String> iins = iin.getIins();
    	
    	// 카드의 IIN중 앞 자리 정하기
    	Random r = new Random();
    	int iinSelectedIndex = 0;
    	if(iins.size()>=2)
    		{ iinSelectedIndex = r.nextInt(iins.size()-1); }
    	
    	char[] front = iins.get(iinSelectedIndex).toCharArray();
  
    	// 앞 부분 배치
    	for(int i=0; i<front.length; i++) {
    		cardNumber[i] = Character.getNumericValue(front[i]);
    	}
    	
    	// 나머지 뒷부분 배치
    	for(int i=front.length; i<cardNumberLength; i++) {
    		cardNumber[i] = r.nextInt(9);
    	}
    	this.cardNumber = cardNumber;
    }
}