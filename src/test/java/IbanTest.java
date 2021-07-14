package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import main.java.Iban;

class IbanTest {

	Iban iban = new Iban();

	@Test
	void validate_incorrect_singleCharSubstitution() {
		assertFalse(iban.validate("NO8330001234561"));
	}

	@Test
	void validate_incorrect_singleCharShift() {
		assertFalse(iban.validate("NO8330001234576"));
	}

	@Test
	void validate_incorrect_missingChar() {
		assertFalse(iban.validate("NO833000123456"));
	}

	@Test
	void validate_incorrect_extraChar() {
		assertFalse(iban.validate("NO83300012345678"));
	}
	
	@Test
	void validate_incorrect_nonAlphanumericChar() {
		assertFalse(iban.validate("NO833000123456ä"));
	}

	@Test
	void validate_incorrect_missingCountryCode() {
		assertFalse(iban.validate("83300012345678"));
	}

	@Test
	void validate_incorrect_emptyStr() {
		assertFalse(iban.validate(""));
	}

	@Test
	void validate_incorrect_wrongCountryCode() {
		assertFalse(iban.validate("XX83300012345678"));
	}

	@Test
	void validate_correct_withSpaces() {
		assertTrue(iban.validate("NO 8330 00123 4567"));
	}

	@Test
	void validate_correct_lowercase() {
		assertTrue(iban.validate("no8330001234567"));
	}

	@Test
	void validate_correct_NO() {
		assertTrue(iban.validate("NO8330001234567"));
	}

	@Test
	void validate_correct_BE() {
		assertTrue(iban.validate("BE71096123456769"));
	}

	@Test
	void validate_correct_FO() {
		assertTrue(iban.validate("FO9264600123456789"));
	}

	@Test
	void validate_correct_GL() {
		assertTrue(iban.validate("GL8964710123456789"));
	}

	@Test
	void validate_correct_DK() {
		assertTrue(iban.validate("DK9520000123456789"));
	}

	@Test
	void validate_correct_FI() {
		assertTrue(iban.validate("FI1410093000123458"));
	}

	@Test
	void validate_correct_NL() {
		assertTrue(iban.validate("NL02ABNA0123456789"));
	}

	@Test
	void validate_correct_SD() {
		assertTrue(iban.validate("SD8811123456789012"));
	}

	@Test
	void validate_correct_MK() {
		assertTrue(iban.validate("MK07200002785123453"));
	}

	@Test
	void validate_correct_SI() {
		assertTrue(iban.validate("SI56192001234567892"));
	}

	@Test
	void validate_correct_AT() {
		assertTrue(iban.validate("AT483200000012345864"));
	}

	@Test
	void validate_correct_BA() {
		assertTrue(iban.validate("BA393385804800211234"));
	}

	@Test
	void validate_correct_EE() {
		assertTrue(iban.validate("EE471000001020145685"));
	}

	@Test
	void validate_correct_KZ() {
		assertTrue(iban.validate("KZ563190000012344567"));
	}

	@Test
	void validate_correct_XK() {
		assertTrue(iban.validate("XK051212012345678906"));
	}

	@Test
	void validate_correct_LT() {
		assertTrue(iban.validate("LT601010012345678901"));
	}

	@Test
	void validate_correct_LU() {
		assertTrue(iban.validate("LU120010001234567891"));
	}

	@Test
	void validate_correct_HR() {
		assertTrue(iban.validate("HR1723600001101234565"));
	}

	@Test
	void validate_correct_LV() {
		assertTrue(iban.validate("LV97HABA0012345678910"));
	}

	@Test
	void validate_correct_LI() {
		assertTrue(iban.validate("LI7408806123456789012"));
	}

	@Test
	void validate_correct_CH() {
		assertTrue(iban.validate("CH5604835012345678009"));
	}

	@Test
	void validate_correct_BH() {
		assertTrue(iban.validate("BH02CITI00001077181611"));
	}

	@Test
	void validate_correct_BG() {
		assertTrue(iban.validate("BG18RZBB91550123456789"));
	}

	@Test
	void validate_correct_CR() {
		assertTrue(iban.validate("CR23015108410026012345"));
	}

	@Test
	void validate_correct_GE() {
		assertTrue(iban.validate("GE60NB0000000123456789"));
	}

	@Test
	void validate_correct_DE() {
		assertTrue(iban.validate("DE75512108001245126199"));
	}

	@Test
	void validate_correct_IE() {
		assertTrue(iban.validate("IE64IRCE92050112345678"));
	}

	@Test
	void validate_correct_ME() {
		assertTrue(iban.validate("ME25505000012345678951"));
	}

	@Test
	void validate_correct_RS() {
		assertTrue(iban.validate("RS35105008123123123173"));
	}

	@Test
	void validate_correct_GB() {
		assertTrue(iban.validate("GB33BUKB20201555555555"));
	}

	@Test
	void validate_correct_VA() {
		assertTrue(iban.validate("VA59001123000012345678"));
	}

	@Test
	void validate_correct_GI() {
		assertTrue(iban.validate("GI04BARC000001234567890"));
	}

	@Test
	void validate_correct_IL() {
		assertTrue(iban.validate("IL170108000000012612345"));
	}

	@Test
	void validate_correct_TL() {
		assertTrue(iban.validate("TL380010012345678910106"));
	}

	@Test
	void validate_correct_AE() {
		assertTrue(iban.validate("AE460090000000123456789"));
	}

	@Test
	void validate_correct_IQ() {
		assertTrue(iban.validate("IQ20CBIQ861800101010500"));
	}

	@Test
	void validate_correct_AD() {
		assertTrue(iban.validate("AD1400080001001234567890"));
	}

	@Test
	void validate_correct_CZ() {
		assertTrue(iban.validate("CZ5508000000001234567899"));
	}

	@Test
	void validate_correct_MD() {
		assertTrue(iban.validate("MD21EX000000000001234567"));
	}

	@Test
	void validate_correct_PK() {
		assertTrue(iban.validate("PK36SCBL0000001123456702"));
	}

	@Test
	void validate_correct_RO() {
		assertTrue(iban.validate("RO09BCYP0000001234567890"));
	}

	@Test
	void validate_correct_SA() {
		assertTrue(iban.validate("SA4420000001234567891234"));
	}

	@Test
	void validate_correct_SK() {
		assertTrue(iban.validate("SK8975000000000012345671"));
	}

	@Test
	void validate_correct_ES() {
		assertTrue(iban.validate("ES7921000813610123456789"));
	}

	@Test
	void validate_correct_SE() {
		assertTrue(iban.validate("SE7280000810340009783242"));
	}

	@Test
	void validate_correct_TN() {
		assertTrue(iban.validate("TN5904018104004942712345"));
	}

	@Test
	void validate_correct_VG() {
		assertTrue(iban.validate("VG21PACG0000000123456789"));
	}

	@Test
	void validate_correct_PT() {
		assertTrue(iban.validate("PT50002700000001234567833"));
	}

	@Test
	void validate_correct_ST() {
		assertTrue(iban.validate("ST23000200000289355710148"));
	}

	@Test
	void validate_correct_LY() {
		assertTrue(iban.validate("LY38021001000000123456789"));
	}

	@Test
	void validate_correct_IS() {
		assertTrue(iban.validate("IS750001121234563108962099"));
	}

	@Test
	void validate_correct_TR() {
		assertTrue(iban.validate("TR320010009999901234567890"));
	}

	@Test
	void validate_correct_FR() {
		assertTrue(iban.validate("FR7630006000011234567890189"));
	}

	@Test
	void validate_correct_GR() {
		assertTrue(iban.validate("GR9608100010000001234567890"));
	}

	@Test
	void validate_correct_IT() {
		assertTrue(iban.validate("IT60X0542811101000000123456"));
	}

	@Test
	void validate_correct_MR() {
		assertTrue(iban.validate("MR1300020001010000123456753"));
	}

	@Test
	void validate_correct_MC() {
		assertTrue(iban.validate("MC5810096180790123456789085"));
	}

	@Test
	void validate_correct_SM() {
		assertTrue(iban.validate("SM76P0854009812123456789123"));
	}

	@Test
	void validate_correct_AL() {
		assertTrue(iban.validate("AL35202111090000000001234567"));
	}

	@Test
	void validate_correct_AZ() {
		assertTrue(iban.validate("AZ96AZEJ00000000001234567890"));
	}

	@Test
	void validate_correct_CY() {
		assertTrue(iban.validate("CY21002001950000357001234567"));
	}

	@Test
	void validate_correct_DO() {
		assertTrue(iban.validate("DO22ACAU00000000000123456789"));
	}

	@Test
	void validate_correct_GT() {
		assertTrue(iban.validate("GT20AGRO00000000001234567890"));
	}

	@Test
	void validate_correct_HU() {
		assertTrue(iban.validate("HU93116000060000000012345676"));
	}

	@Test
	void validate_correct_LB() {
		assertTrue(iban.validate("LB92000700000000123123456123"));
	}

	@Test
	void validate_correct_PL() {
		assertTrue(iban.validate("PL10105000997603123456789123"));
	}

	@Test
	void validate_correct_BY() {
		assertTrue(iban.validate("BY86AKBB10100000002966000000"));
	}

	@Test
	void validate_correct_SV() {
		assertTrue(iban.validate("SV43ACAT00000000000000123123"));
	}

	@Test
	void validate_correct_BR() {
		assertTrue(iban.validate("BR1500000000000010932840814P2"));
	}

	@Test
	void validate_correct_EG() {
		assertTrue(iban.validate("EG800002000156789012345180002"));
	}

	@Test
	void validate_correct_PS() {
		assertTrue(iban.validate("PS92PALS000000000400123456702"));
	}

	@Test
	void validate_correct_QA() {
		assertTrue(iban.validate("QA54QNBA000000000000693123456"));
	}

	@Test
	void validate_correct_UA() {
		assertTrue(iban.validate("UA903052992990004149123456789"));
	}

	@Test
	void validate_correct_JO() {
		assertTrue(iban.validate("JO71CBJO0000000000001234567890"));
	}

	@Test
	void validate_correct_KW() {
		assertTrue(iban.validate("KW81CBKU0000000000001234560101"));
	}

	@Test
	void validate_correct_MU() {
		assertTrue(iban.validate("MU43BOMM0101123456789101000MUR"));
	}

	@Test
	void validate_correct_MT() {
		assertTrue(iban.validate("MT31MALT01100000000000000000123"));
	}

	@Test
	void validate_correct_SC() {
		assertTrue(iban.validate("SC52BAHL01031234567890123456USD"));
	}

	@Test
	void validate_correct_LC() {
		assertTrue(iban.validate("LC14BOSL123456789012345678901234"));
	}

}
