package card;
public enum CardIin {
	VISA		(new int[] {4}, 					16),
	AMEX		(new int[] {34, 37},				15),
	JCB			(new int[] {3528, 3589},			16),
	MAESTRO		(new int[] {50, 56, 57, 58, 59},	16),
	CIRRUS		(new int[] {50, 56, 57, 58, 59},	16),
	MASTER		(new int[] {51, 52, 53, 54, 55},	16),
	DINERSCLUB	(new int[] {300, 301, 302, 303,
							304, 305, 3095, 36,
							38, 39},				16),
	UNIONPAY	(range(new int[]
						   {622126, 622925,
							624,	626}),			16),
	DISCOVER	(range(new int[]
							{60112,		60114,
							 601174,	601179,
							 601186,	601199,
							 60110,		60110,
							 644,		649,
							 60,		61,
							 64,		65}),		16),
	NONE(new int[] {0}, 0);
	
	private int[] iinRange;
	private int length;
	
	CardIin(int[] iinRange, int length) {
		this.iinRange = iinRange;
		this.length = length;
	}
	
	private static int[] range(int[] rangeWidth) {
		int[] max = {0};
		int l = rangeWidth.length>2 ? rangeWidth.length : 1; // i가 도달할 값 측정
		
		// 파라메터로 들어온 배열의 길이가 짝수일 때만 허용
		if( (rangeWidth.length%2) == 0) {
			for(int i=0; i<=rangeWidth[l-2]; i=i+2) {

				int[] temp = makeRange(rangeWidth[i], rangeWidth[i+1]);
				System.arraycopy(temp, 0, max, 0, temp.length-1);
				// 출발지, 출발지 인덱스, 목적지, 목적지 인덱스, 출발지 종료 인덱스
			}
		}
		else {
			//throw new Exception("int[] range(int[] rangeWidth) => rangeWidth is not even.");
		}
		return max;
		
	}
	
	public boolean haveIinCode(int codeNumber) {
		boolean result = false;
		for(int i=0; i<this.iinRange.length; i++) {
			if(this.iinRange[i] == codeNumber) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	private static int[] makeRange(int start, int end) {
		int[] result = new int[end-start+1];
		for(int i=0; start<=end; i++) {
			result[i] = start+i;
		}
		return result;
	}
}