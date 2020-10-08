package card;

/**
 * card.jar 내부에서 사용하는 유틸리티성이 강한 메서드 모음.
 *
 * @author David Jung
 * @see <a href='https://github.com/davidjung-kr/card.jar'>Github(github.com/davidjung-kr/card.jar)</a>
 */
public class Utils {
	
	/**
	 * 입력받은 숫자가 10보다 큰 경우, 10의 자리와 1의 자리를 구해 더한 값을 돌려준다.
	 *
	 * @param int number 계산할 대상 숫자
	 * @return int (number/10)+(number%10)
	 */
	protected static int sumForModulus(int number) {
		int result = number;
		if(number >= 5)
			result = (number/10) + (number%10);
		return result;
	}
	
	/**
	 * 입력 받은 문자열이 NULL 혹은 빈 문자열 인 지 여부를 검사한다.
	 *
	 * @param String data 대상 문자열
	 * @return boolean
	 */
	protected static boolean emptyCheck(String data) {
		if("".equals(data) || data == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 짝수인 지 체크한다.
	 *
	 * @param int number 판단할 대상 숫자
	 * @return boolean
	 */
	protected static boolean evenCheck(int number) {
		if(number%2 == 0 && number>1)
			return true;
		return false;
	}

	/**
	 * 홀수인 지 체크한다.
	 *
	 * @param int number 판단할 대상 숫자
	 * @return boolean
	 */
	protected static boolean oddCheck(int number) {
		if(number%2 == 1 && number>=1)
			return true;
		return false;
	}
}