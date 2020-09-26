package card;

public class Utils {
	protected static boolean emptyCheck(String data) {
		if("".equals(data) || data == null) {
			return true;
		}
		return false;
	}
}