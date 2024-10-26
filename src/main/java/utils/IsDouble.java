package utils;

public class IsDouble {

	public boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			return true; // If parsing succeeds, it's a valid double
		} catch (NumberFormatException e) {
			return false; // If an exception is thrown, it's not a valid double
		}
	}

}
