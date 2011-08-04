package kspcal.utils;

public enum CustomPartType {

	PROP(0, "Propulsion", "Propulsion"),
	CnC(1, "Command", "Command & Control"),
	SaA(2, "Structural", "Structural Elements"),
	UTILITY(3, "Utilities", "Utilities");
	
	private final int type;
	private final String name;
	private final String  fullName;
	
	private CustomPartType(int type, String name, String fullName) {
		this.type = type;
		this.name = name;
		this.fullName = fullName;
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

	public String getFullName() {
		return fullName;
	}
}
