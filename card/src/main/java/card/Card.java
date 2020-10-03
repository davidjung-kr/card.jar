package card;

import java.util.List;
import java.util.Random;

public class Card {
    private int[] cardNumbers;
    private CardIin iin;
    private int iinSize;
    private int modulusSum;
    
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
    	this.cardNumbers = new int[iin.getLength()];
    	this.generateCardNumber();
    }
  
    /**
     * 생성자
     * @return Return any card number of the brand received as parameter.
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
    
    public String getCardNumber() {
    	StringBuilder str = new StringBuilder();
    	for(int e: this.cardNumbers)
    		str.append(e);
    	return str.toString();
    }

    /**
     * 카드번호 생성
     */
    private void generateCardNumber() {
    	this.settingBrand		();
    	this.settingNumber		();
    	this.settingCheckDigit	();
    }

    /**
     * IIN번호 세팅
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
    	
    	
    	// 브랜드의 카드 앞자리 패턴 중 한가지를 char[] 형태로 가져옴
    	System.out.println("iins.get(selectInt) : " + selectInt);
    	char[] frontCardNumbers = iins.get(selectInt).toCharArray();
    	this.iinSize = frontCardNumbers.length; // iinSize 필드에 브랜드명 카드 숫자 길이 세팅
    	
    	// cardNumber 필드에 앞자리 세팅
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
     * 나머지 카드번호 세팅
     */ 
    private void settingNumber() {
    	int intSize = this.iinSize;
    	int cardNumberLength = this.iin.getLength();
    	cardNumberLength -= 1; // 마지막 한 자리는 체크디지트 이므로 제외
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
    	// 모듈러스10에 부합하기 위한 마지막 숫자 결정
    	// 	= sum보다 큰 10의 배수(ex. 61 => 70)
    	int threshold = (this.modulusSum/10)*10+10; // == 1의 자리 삭제 후 + 10
    	int checkDigit = threshold-this.modulusSum;
    	int cardNumberLength = this.iin.getLength()-1;
    	this.cardNumbers[cardNumberLength] = checkDigit;
    }
}