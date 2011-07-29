package kspcal.utils;

public enum CustomPartType {

	PROP(0),
	CnC(1),
	SaA(2),
	UTILITY(3);
	
	private final int type;
	
	private CustomPartType(int type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
}
