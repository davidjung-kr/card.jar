package card;

/**
 * card.jar ���ο��� ����ϴ� ��ƿ��Ƽ���� ���� �޼��� ����.
 *
 * @author David Jung
 * @see    https://github.com/davidjung-kr/card.jar
 */
public class Utils {
	
	/**
	 * �Է¹��� ���ڰ� 10���� ū ���, 10�� �ڸ��� 1�� �ڸ��� ���� ���� ���� �����ش�.
	 *
	 * @param int number ����� ��� ����
	 * @return int (number/10)+(number%10)
	 */
	protected static int sumForModulus(int number) {
		int result = number;
		if(number >= 5)
			result = (number/10) + (number%10);
		return result;
	}
	
	/**
	 * �Է� ���� ���ڿ��� NULL Ȥ�� �� ���ڿ� �� �� ���θ� �˻��Ѵ�.
	 *
	 * @param String data ��� ���ڿ�
	 * @return boolean
	 */
	protected static boolean emptyCheck(String data) {
		if("".equals(data) || data == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * ¦���� �� üũ�Ѵ�.
	 *
	 * @param int number �Ǵ��� ��� ����
	 * @return boolean
	 */
	protected static boolean evenCheck(int number) {
		if(number%2 == 0 && number>1)
			return true;
		return false;
	}

	/**
	 * Ȧ���� �� üũ�Ѵ�.
	 *
	 * @param int number �Ǵ��� ��� ����
	 * @return boolean
	 */
	protected static boolean oddCheck(int number) {
		if(number%2 == 1 && number>=1)
			return true;
		return false;
	}
}