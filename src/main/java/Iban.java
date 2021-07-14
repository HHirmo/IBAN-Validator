package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Iban {
	
	public Integer lengthOfCountryIban(String countryCode) {
		String[] countriesAndLenght = { "NO-15", "BE-16", "FO-18", "GL-18", "DK-18", "FI-18", "NL-18", "SD-18", "MK-19",
				"SI-19", "AT-20", "BA-20", "EE-20", "KZ-20", "XK-20", "LT-20", "LU-20", "HR-21", "LV-21", "LI-21",
				"CH-21", "BH-22", "BG-22", "CR-22", "GE-22", "DE-22", "IE-22", "ME-22", "RS-22", "GB-22", "VA-22",
				"TL-23", "GI-23", "IQ-23", "IL-23", "AE-23", "AD-24", "CZ-24", "MD-24", "PK-24", "RO-24", "SA-24",
				"SK-24", "ES-24", "SE-24", "TN-24", "VG-24", "LY-25", "PT-25", "ST-25", "IS-26", "TR-26", "FR-27",
				"GR-27", "IT-27", "MR-27", "MC-27", "SM-27", "AL-28", "AZ-28", "BY-28", "CY-28", "DO-28", "SV-28",
				"GT-28", "HU-28", "LB-28", "PL-28", "PS-29", "BR-29", "EG-29", "QA-29", "UA-29", "JO-30", "KW-30",
				"MU-30", "MT-31", "SC-31", "LC-32" };
		Map<String, Integer> lengthByCountry = new HashMap<>();
		
		for (String countryAndLength : countriesAndLenght) {
			String[] split = countryAndLength.split("-");
			lengthByCountry.put(split[0], Integer.parseInt(split[1]));
		}
		return lengthByCountry.getOrDefault(countryCode, -1);
	}

	public boolean validate(String iban) {

		// remove all non-alphanumeric characters and make the string upper case.
		String ibanParsed = iban.toUpperCase().replaceAll("[^A-Z0-9]", "");

		// verifying that the string is long enough for .substring to not fail
		if (ibanParsed.length() < 2) { 
			return false;
		}

		// Check that the total IBAN length is correct as per the country. If not, the
		// IBAN is invalid
		String countryCode = ibanParsed.substring(0, 2);
		if (ibanParsed.length() != lengthOfCountryIban(countryCode)) {
			return false;
		}

		// Move the four initial characters to the end of the string
		ibanParsed = ibanParsed.substring(4, ibanParsed.length()) + ibanParsed.substring(0, 4);

		// Replace each letter in the string with two digits, thereby expanding the
		// string, where A = 10, B = 11, ..., Z = 35
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alphabet.length(); i++) {
			ibanParsed = ibanParsed.replaceAll(String.valueOf(alphabet.charAt(i)), String.valueOf(i + 10));
		}

		// Interpret the string as a decimal integer and compute the remainder of that
		// number on division by 97. If the remainder is 1, the check digit test is
		// passed and the IBAN might be valid.
		BigInteger ibanBigInt = new BigInteger(ibanParsed);
		if (ibanBigInt.remainder(new BigInteger("97")).compareTo(BigInteger.ONE) == 0) {
			return true;
		} else {
			return false;
		}
	}

	public String validateFile(File file) {
		// Read the file
		if (file.canRead()) {
			Scanner reader;
			try {
				reader = new Scanner(file);
			} catch (FileNotFoundException e) {
				return "File cannot be found.";
			}
			String data = "";
			while (reader.hasNextLine()) {
				data += reader.nextLine();
			}
			reader.close();

			// Split it into an array
			String[] ibans = data.split(",");

			String result = "<html>";
			for (String iban : ibans) {
				
				String ibanParsed = iban.toUpperCase().replaceAll("[^A-Z0-9]", "");
				
				if (!ibanParsed.isBlank()) {
					String answer;
					if (validate(ibanParsed)) {
						answer = " may be valid. ";
					} else {
						answer = " is invalid. ";
					}
					
					result += ibanParsed + answer + "<br>";
				}
			}
			
			return result;
		} else {
			return "File cannot be read.";
		}
	}

}
