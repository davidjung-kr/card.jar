package card;

import java.util.List;
import java.util.Random;

/**
 * Class for generating any card number, a numeric string that conforms to the modular 10 formula.
 *
 * @author David Jung
 * @see <a href='https://github.com/davidjung-kr/card.jar'>Github(github.com/davidjung-kr/card.jar)</a>
 */
public class Card {
	/** Card number. */
    private int[] cardNumbers;
    /** Card brand */
    private CardIin iin;
    private int iinSize;
    private int modulusSum;
    
    /**
     * Constructor
     * 	- Setting a IIN brand randomly and generate card numbers when initialize.
     * 
	 * <pre>
	 * {@code
	 * Card card = new Card(); // Randomly brand
	 * }
	 * </pre>
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
    	Random random 		= new Random();
    	int selectedIndex 	= random.nextInt(iins.length-1);
    	this.iin 			= iins[selectedIndex];
    	this.cardNumbers 	= new int[iin.getLength()];
    	this.generateCardNumber();
    }

    /**
     * Constructor
     * 	- Generate card numbers when initialize.
     * 
     * @param iin IIN of card brand
     * 
	 * <pre>
	 * {@code
	 * Card masterCard = new Card(CardIin.MASTER); // Master card
	 * }
	 * </pre>
     */
    public Card(CardIin iin){
    	final int CARDNUMBER_LENGTH = iin.getLength();
    	// --- 필드 세팅 ---
    	this.iin			= iin;
    	this.cardNumbers	= new int[CARDNUMBER_LENGTH];	
    	this.iinSize		= 0;
        this.modulusSum 	= 0;
    	this.generateCardNumber();
    }
   
    /**
     * Get card number when initialize instance.
     * 
     * @return Card numbers
     * 
     * <pre>
     * Card masterCard = new Card(CardIin.MASTER);
     * String cardNumber = masterCard.getCardNumber();
     * </pre>
     */
    public String getCardNumber() {
    	StringBuilder str = new StringBuilder();
    	for(int e: this.cardNumbers)
    		str.append(e);
    	return str.toString();
    }

    /**
     * Call methods for generate card numbers.
     */
    private void generateCardNumber() {
    	this.settingBrand		();
    	this.settingNumber		();
    	this.settingCheckDigit	();
    }

    /**
     * Setting card brand(IIN)
     */
    private void settingBrand() {
    	// IIN 앞자리 목록 가져오기
    	List<String> iins = iin.getIins();
    	
    	int selectInt = 0;
    	
    	// IIN 앞자리로 쓸 수 있는 숫자목록 개수
    	int iinsCount = iins.size();
    	if(iinsCount >= 2) { // 2개 이상일 때는 임의의 한 가지를 골라야 함
        	Random random = new Random();
        	selectInt = random.nextInt(iinsCount);
        	selectInt -= selectInt<=0 ? selectInt*-1:selectInt-1; // 인덱싱 용이므로 -1 해줌
    	}
    	
    	char[] frontCardNumbers = iins.get(selectInt).toCharArray();
    	this.iinSize = frontCardNumbers.length; // iinSize 필드에 브랜드명 카드 숫자 길이 세팅
    	
    	// cardNumber 필드에 앞자리 세팅
    	for(int i=0; i<iinSize; i++) {
    		int index  = i+1;
    		int number = Character.getNumericValue(frontCardNumbers[i]);
    		this.cardNumbers[i] = number;
    		
    		if(Utils.oddCheck(index)) {
    			number = Utils.sumForModulus(number*2);
    			this.modulusSum += number;
    		} else {
    			this.modulusSum += number;
    		}
    	}
    }
    
    /**
     * Setting card numbers without check digit.
     */
    private void settingNumber() {
    	int iinSize = this.iinSize;
    	int cardNumberLength = this.iin.getLength();
    	cardNumberLength -= 1; // 마지막 한 자리는 체크디지트 이므로 제외
    	for(int i=iinSize; i<cardNumberLength; i++) {
    		int index  = i+1;
    		Random random = new Random();
    		int number = random.nextInt(9);
    		this.cardNumbers[i] = number;

    		if(Utils.oddCheck(index)) {
    			number = Utils.sumForModulus(number*2);
    			this.modulusSum += number;
    		} else
    			{ this.modulusSum += number; }
    	}
    }

    /**
     * Setting check digit.
     */
    private void settingCheckDigit() {
    	// 모듈러스10에 부합하기 위한 마지막 숫자 결정
    	// 	= sum보다 큰 10의 배수(ex. 61 => 70)
    	int threshold			= (this.modulusSum/10)*10+10; // == 1의 자리 삭제 후 + 10
    	int checkDigit			= threshold-this.modulusSum;
    	int cardNumberLength	= this.iin.getLength()-1;
    	this.cardNumbers[cardNumberLength] = checkDigit;
    }
}