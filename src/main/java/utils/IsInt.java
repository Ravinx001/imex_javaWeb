package utils;

public class IsInt {

	public boolean isInt(String value) {
		try {
			Integer.parseInt(value);
			return true; // If parsing succeeds, it's a valid double
		} catch (NumberFormatException e) {
			return false; // If an exception is thrown, it's not a valid double
		}
	}

}
