package card;

import java.util.List;
import java.util.Random;

public class Card {
    private int[] cardNumber;
    private CardIin iin;
    
    /**
     * ������
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
     * ������
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
    	
    	// IIN ���ڸ� ��� ��������
    	List<String> iins = iin.getIins();
    	
    	// ī���� IIN�� �� �ڸ� ���ϱ�
    	Random r = new Random();
    	int iinSelectedIndex = 0;
    	if(iins.size()>=2)
    		{ iinSelectedIndex = r.nextInt(iins.size()-1); }
    	
    	char[] front = iins.get(iinSelectedIndex).toCharArray();
  
    	// �� �κ� ��ġ
    	for(int i=0; i<front.length; i++) {
    		cardNumber[i] = Character.getNumericValue(front[i]);
    	}
    	
    	// ������ �޺κ� ��ġ
    	for(int i=front.length; i<cardNumberLength; i++) {
    		cardNumber[i] = r.nextInt(9);
    	}
    	this.cardNumber = cardNumber;
    }
}