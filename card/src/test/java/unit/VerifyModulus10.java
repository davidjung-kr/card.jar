package unit;

import static org.junit.Assert.*;

import org.junit.Test;

import card.Verify;

/**
 * [] Serialize ����� ����Ͽ� file�� object�� ����
 *
 * @author David Jung
 * @see    https://github.com/davidjung-kr/card.jar
 */
public class VerifyModulus10 {
	/**
	 * �޼����� ��ɼ����� �� ���ٷ� �����ϰ�..
	 *
	 * @param int list1 �޼����� �Ķ���� ����, type��� �������� ���� �����ϰ� ����
	 * @return
	 * @exception ���ܻ����� ���ο� �ϳ���
	 */
	@Test
	public void test() {
		assertEquals(true,	Verify.modulus10("4916854683763796"));
		assertEquals(true,	Verify.modulus10("5111111111111118"));
		assertEquals(false,	Verify.modulus10("1234987645670987"));
	}
}