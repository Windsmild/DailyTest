package myTest;

/**
 * Created by Stephen Cai on 2017-09-13 13:53.
 */
public enum PaymentType {

	ALIPAY(1, 1),
	WEIXIN(2, 2),
	WEIXIN_WEB(3, 3),
	ALIPAY_MWEB(4, 1),
	ALIPAY_PC_WEB(5, 1),
	WEIXIN_WAP(6, 3),
	CMB_APP(7, 7),//招行一网通
	WEIXIN_SCAN(8, 3),
	CMB_PC(9, 9),//招行PC,
	WEIXIN_LITTLE_APP(10, 2),//小程序,
	HUABEI(11,1),
	HUABEI_MWEB(12,1),
	HUABEI_PC_WEB(13,1),
	DOULI_INTEGRAL(14,14),//兜礼积分
	MONEYACCOUNT(99, 99),//余额支付,
	NO_AMOUNT(100, 100),//无金额支付,
	AGENT(0,0),
	AGENT1(0,0)
	;

	private final int code;
	private final int notifyCode;

	PaymentType(int code, int notifyCode) {
		this.code = code;
		this.notifyCode = notifyCode;
	}

	public int getValue() {
		return code;
	}

	public PaymentType getNotifyType() {
		return fromValue(notifyCode);
	}

	public static PaymentType fromValue(int value){
		for (PaymentType paymentType : PaymentType.values()) {
			if (paymentType.getValue()==value){
				return paymentType;
			}
		}
		return null;
	}

	public boolean is(int value){

		return getValue() == value;
	}

	public static void main(String[] args) {
		PaymentType p1 = PaymentType.AGENT;
		PaymentType p2 = PaymentType.AGENT1;
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}
}

