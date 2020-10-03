package card;

public class Verify {
	// Modulus 10
	public static boolean modulus10(String cardNumber) {
		int cardNumberLength = cardNumber.length();
		int[] numbers = new int[cardNumberLength];
		char[] chars = cardNumber.toCharArray();
		
		// String -> char[] -> int[]
		for(int i=0; i<cardNumberLength; i++) {
			numbers[i] =  Character.getNumericValue(chars[i]);
		}
		
		int sum = 0; // �� ������ CheckDigit�� ������� �ʱ� ���� -1
		for(int i=0; i<cardNumberLength-1; i++) {
			// Ȧ����° ���ڴ� �׳� ����, ¦����° ���ڴ� 2�� ����
			int index = i+1;
			int num = (index==1 || index%2==1)?	numbers[i]*2 : numbers[i];
			num = num>9 ?	num/10+num%10 : num;
			sum += num;
		}
		sum += numbers[cardNumberLength-1]; // �� ������ Check Digit ���ϱ�
		return sum%10 == 0 ? true:false;
	}
}