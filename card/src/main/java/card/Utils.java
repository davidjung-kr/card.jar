package card;

public class Utils {
	protected static boolean emptyCheck(String data) {
		if("".equals(data) || data == null) {
			return true;
		}
		return false;
	}
	
	protected static int sumForModulus(int number) {
		int result = 0;
		if(number >= 5)
			result = (number/10) + (number%10);
		return result;
	}
	
}