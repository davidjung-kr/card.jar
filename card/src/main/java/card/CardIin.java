package card;

import java.util.ArrayList;
import java.util.List;

public enum CardIin {

	AMEX		(new String[] {"34",	 "37"},					15),
	CIRRUS		(new String[] {"50", "56", "57", "58", "59"},	16),
	DINERSCLUB	(new String[] {"300", "301", "302", "303",
							   "304", "305",
							   "36", "38", "39", "3095"},		16),
	JCB			(new String[] {"3528", "3589"},					16),
	MAESTRO		(new String[] {"50", "56", "57", "58", "59"},	16),
	MASTER		(new String[] {"51", "52", "53", "54", "55"},	16),
	VISA		(new String[] {"4"}, 							16),
	UNIONPAY	(arrayListGlue(
					makeStringList(622126, 622925),
					makeStringList(624,		  626)),			16),
	DISCOVER	(	arrayListGlue(
					arrayListGlue(
					arrayListGlue(
					arrayListGlue(
					arrayListGlue(
					arrayListGlue(
						makeStringList(60112,  60114),
						makeStringList(601174, 601179)	),
						makeStringList(601186, 601199)	),
						makeStringList(60110,  60110)	),
						makeStringList(644,		 649)	),
						makeStringList(60,		  61)	),
						makeStringList(64,		  65)	),		16),
	NONE(new String[] {"0"}, 0);
	
	;
	
	private List<String> iinList;
	private int length;
	
	CardIin(ArrayList<String> iins, int length){
		this.iinList = iins;
		this.length = length;
	}
	
	CardIin(String[] iins, int length) {
		this.iinList = new ArrayList<String>();
		for(int i=0; i<iins.length; i++) {
			iinList.add(iins[i]);
		}
		this.length		= length;
	}

	// IIN 얻기
	public List<String> getIins() {
		return this.iinList;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean haveIinCode(String cardNumber) {
		boolean result = false;
		
		// isNull & isLengthNotZero ?
		if(card.Utils.emptyCheck(cardNumber))
			{ return result; } // === return false;
		
		// 순서대로 IIN 목록을 가져와 비교
		for(int i=0; i<this.iinList.size(); i++) {
			String iinFront = iinList.get(i);

			if(	!(cardNumber.length() > iinFront.length()) ) {
				return result; // === return false;
			}
			
			if(iinFront.equals(cardNumber.substring(0, iinFront.length()))) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private static ArrayList<String> makeStringList(int start, int end) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i=start; i<=end; i++) {
			result.add(Integer.toString(i));
		}
		return result;
	}
	
	private static ArrayList<String> arrayListGlue(ArrayList<String> x, ArrayList<String> y) {
		ArrayList<String> result = new ArrayList<String>();
		x.addAll(y);
		return x;
	}
}