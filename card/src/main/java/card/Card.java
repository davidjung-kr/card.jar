package card;

import java.util.List;
import java.util.Random;

public class Card {
    private int[] cardNumbers;
    private CardIin iin;
    private int iinSize;
    private int modulusSum;
    
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
    	this.cardNumbers = new int[iin.getLength()];
    	this.generateCardNumber();
    }
  
    /**
     * ������
     * @return Return any card number of the brand received as parameter.
     */
    public Card(CardIin iin){
    	final int CARDNUMBER_LENGTH = iin.getLength();
    	// --- �ʵ� ���� ---
    	this.iin			= iin;
    	this.cardNumbers	= new int[CARDNUMBER_LENGTH];	
    	this.iinSize		= 0;
        this.modulusSum 	= 0;
    	this.generateCardNumber();
    }
    
    public String getCardNumber() {
    	StringBuilder str = new StringBuilder();
    	for(int e: this.cardNumbers)
    		str.append(e);
    	return str.toString();
    }

    /**
     * ī���ȣ ����
     */
    private void generateCardNumber() {
    	this.settingBrand		();
    	this.settingNumber		();
    	this.settingCheckDigit	();
    }

    /**
     * IIN��ȣ ����
     */
    private void settingBrand() {
    	// IIN ���ڸ� ��� ��������
    	List<String> iins = iin.getIins();
    	
    	int selectInt = 0;
    	
    	// IIN ���ڸ��� �� �� �ִ� ���ڸ�� ����
    	int iinsCount = iins.size();
    	if(iinsCount >= 2) { // 2�� �̻��� ���� ������ �� ������ ���� ��
        	Random random = new Random();
        	selectInt = random.nextInt(iinsCount);
        	selectInt -= selectInt<=0 ? selectInt*-1:selectInt-1; // �ε��� ���̹Ƿ� -1 ����
    	}
    	
    	
    	// �귣���� ī�� ���ڸ� ���� �� �Ѱ����� char[] ���·� ������
    	System.out.println("iins.get(selectInt) : " + selectInt);
    	char[] frontCardNumbers = iins.get(selectInt).toCharArray();
    	this.iinSize = frontCardNumbers.length; // iinSize �ʵ忡 �귣��� ī�� ���� ���� ����
    	
    	// cardNumber �ʵ忡 ���ڸ� ����
    	for(int i=0; i<iinSize; i++) {
    		int index  = i+1;
    		int number = Character.getNumericValue(frontCardNumbers[i]);
    		this.cardNumbers[i] = number;
    		
    		if(index%2 == 0 && index>1) {
    	    	System.out.println(number*2);
    			this.modulusSum += Utils.sumForModulus(number*2); }
    		else
    			{ System.out.println(number); this.modulusSum += number; }
    	}
    }
    
    /**
     * ������ ī���ȣ ����
     */ 
    private void settingNumber() {
    	int intSize = this.iinSize;
    	int cardNumberLength = this.iin.getLength();
    	cardNumberLength -= 1; // ������ �� �ڸ��� üũ����Ʈ �̹Ƿ� ����
    	for(int i=iinSize; i<cardNumberLength; i++) {
    		int index  = i+1;
    		int number = 1;
    		this.cardNumbers[i] = number;
    		
    		if(index%2 == 0 && index>1) {
    	    	System.out.println(number*2);
    			this.modulusSum += Utils.sumForModulus(number*2); }
    		else
    			{ System.out.println(number); this.modulusSum += number; }
    	}
    }
    
    private void settingCheckDigit() {
    	// ��ⷯ��10�� �����ϱ� ���� ������ ���� ����
    	// 	= sum���� ū 10�� ���(ex. 61 => 70)
    	int threshold = (this.modulusSum/10)*10+10; // == 1�� �ڸ� ���� �� + 10
    	int checkDigit = threshold-this.modulusSum;
    	int cardNumberLength = this.iin.getLength()-1;
    	this.cardNumbers[cardNumberLength] = checkDigit;
    }
}