package card;

import java.util.ArrayList;
import java.util.List;

/**
 * Card brand(IIN) type collection.
 *
 * @author David Jung
 * @see    https://github.com/davidjung-kr/card.jar
 */
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
					makeStringList(624,		  626)  ),			16),
	DISCOVER	(arrayListGlue(
					makeStringList(60112,   60114),
					makeStringList(601174, 601179),
					makeStringList(601186, 601199),
					makeStringList(60110,   60110),
					makeStringList(644,		  649),
					makeStringList(60,		   61),
					makeStringList(64,		   65)  ),			16),
	NONE(new String[] {"0"}, 0);
	
	;
	
	private List<String> iinList;
	private int length;

	/**
	 * Constructor
	 *
	 * @param 	ArrayList<String> - First card numbers range corresponding IIN,
	 * 			int - Card number length of corresponding IIN
	 * @return boolean
	 */
	CardIin(ArrayList<String> iins, int length){
		this.iinList	= iins;
		this.length		= length;
	}

	/**
	 * Constructor
	 *
	 * @param 	String[] - First card numbers corresponding IIN,
	 * 			int - Card number length of corresponding IIN
	 * @return boolean
	 */
	CardIin(String[] iins, int length) {
		this.iinList = new ArrayList<String>();
		for(int i=0; i<iins.length; i++) {
			iinList.add(iins[i]);
		}
		this.length	= length;
	}

	/**
	 * Getter - IIN number list
	 *
	 * @param void
	 * @return void
	 */
	public List<String> getIins() {
		return this.iinList;
	}

	/**
	 * Getter - Get card number corresponding IIN
	 *
	 * @param void
	 * @return void
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Checking correct card brand.
	 * ex)
	 * 	CardIin.MASTER.haveIinCode	( 52************** ) == true  // MASTER CARD
	 * 	CardIin.VISA.haveIinCode	( 52************** ) == false // NOT VISA CARD
	 * 
	 * @param void
	 * @return void
	 */
	public boolean haveIinCode(String cardNumber) {
		boolean result = false;
		
		// isNull & isLengthNotZero ?
		if(card.Utils.emptyCheck(cardNumber))
			{ return result; } // === return false;
		
		// 순서대로 IIN 목록을 가져와 비교
		for(int i=0; i<this.iinList.size(); i++) {
			String iinFront = iinList.get(i);

			if(	!(cardNumber.length() > iinFront.length()) )
				{ return result; } // === return false;
			
			if(iinFront.equals(cardNumber.substring(0, iinFront.length())))
				{ result = true; break; }
		}
		return result;
	}

	/**
	 * Like a Range from Python but it is ArrayList<String>.
	 * 
	 * @param 	int - Start number,
	 * 			int - End number
	 * @return ArrayList<String>
	 */
	private static ArrayList<String> makeStringList(int start, int end) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i=start; i<=end; i++) {
			result.add(Integer.toString(i));
		}
		return result;
	}

	/**
	 * Append ArrayList `...y` at ArrayList `x`
	 * 
	 * @param 	ArrayList<String> - x,
	 * 			ArrayList<String> - ...y
	 * @return ArrayList<String>
	 */
	private static ArrayList<String> arrayListGlue(ArrayList<String> x, ArrayList<String>... y) {
		for(ArrayList<String> t:y)
			x.addAll(t);
		return x;
	}
}