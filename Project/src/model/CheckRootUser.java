package model;

public class CheckRootUser {

	private String rootID = "1";

	public boolean Check(String ID) {

		boolean rootCheck = false;
		if (ID.equals(this.rootID)) {
			rootCheck = true;
		} else {
			rootCheck = false;
		}
		return rootCheck;
	}
}
