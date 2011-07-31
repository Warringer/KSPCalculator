package kspcal.utils;

public enum CustomPartType {

	PROP(0, "Prop"),
	CnC(1, "C&C"),
	SaA(2, "Stru"),
	UTILITY(3, "Util");
	
	private final int type;
	private final String name;
	
	private CustomPartType(int type, String name) {
		this.type = type;
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
