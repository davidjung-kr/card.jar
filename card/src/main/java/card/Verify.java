package card;

/**
 * Features about verify a card.
 *
 * @author David Jung
 * @see <a href='https://github.com/davidjung-kr/card.jar'>Github(github.com/davidjung-kr/card.jar)</a>
 */
public class Verify {

	/**
	 * Modulus10 verification

	 * <pre>
	 * {@code
	 * assertEquals(true,	Verify.modulus10("4916854683763796"));
	 * assertEquals(true,	Verify.modulus10("5111111111111118"));
	 * assertEquals(false,	Verify.modulus10("1234987645670987"));
	 * }
	 * </pre>
	 * 
	 * @param	cardNumber	Something card numbers for Modulus 10 verification
	 * @return boolean
	 */
	public static boolean modulus10(String cardNumber) {
		int cardNumberLength = cardNumber.length();
		int[] numbers = new int[cardNumberLength];
		char[] chars = cardNumber.toCharArray();
		
		// String -> char[] -> int[]
		for(int i=0; i<cardNumberLength; i++) {
			numbers[i] =  Character.getNumericValue(chars[i]);
		}
		
		int sum = 0; // 맨 마지막 CheckDigit는 계산하지 않기 위해 -1
		for(int i=0; i<cardNumberLength-1; i++) {
			// 홀수번째 숫자는 그냥 대입, 짝수번째 숫자는 2를 곱함
			int index = i+1;
			int num = Utils.oddCheck(index)?	numbers[i]*2 : numbers[i];
			num = num>9 ?	num/10+num%10 : num;
			sum += num;
		}
		sum += numbers[cardNumberLength-1]; // 맨 마지막 Check Digit 더하기
		return sum%10 == 0 ? true:false;
	}
}