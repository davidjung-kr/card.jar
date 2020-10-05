package unit;

import static org.junit.Assert.*;

import org.junit.Test;

import card.Verify;

/**
 * [] Serialize 기능을 사용하여 file에 object를 저장
 *
 * @author David Jung
 * @see    https://github.com/davidjung-kr/card.jar
 */
public class VerifyModulus10 {
	/**
	 * 메서드의 기능설명은 한 두줄로 간결하게..
	 *
	 * @param int list1 메서드의 파라미터 설명, type명과 변수명을 적고 간략하게 설명
	 * @return
	 * @exception 예외사항한 라인에 하나씩
	 */
	@Test
	public void test() {
		assertEquals(true,	Verify.modulus10("4916854683763796"));
		assertEquals(true,	Verify.modulus10("5111111111111118"));
		assertEquals(false,	Verify.modulus10("1234987645670987"));
	}
}