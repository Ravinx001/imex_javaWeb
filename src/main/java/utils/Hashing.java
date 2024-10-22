package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

	public String hashPassword(String password) {
		try {
			// Get a MessageDigest instance for SHA-256
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// Digest the password (hash it)
			byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

			// Convert the byte array into a signum representation
			BigInteger number = new BigInteger(1, hashedBytes);

			// Convert the number to a hex value
			StringBuilder hexString = new StringBuilder(number.toString(16));

			// Pad with leading zeros to ensure 64-character length
			while (hexString.length() < 64) {
				hexString.insert(0, '0');
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error: Could not generate hash", e);
		}
	}

}
