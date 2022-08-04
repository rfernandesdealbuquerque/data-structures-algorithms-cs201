package test.apt4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt4.MemberCheck;

public class MemberCheckTest {
	
	MemberCheck memberCheck = new MemberCheck();

	@Test
	public void test1WhosDishonest() {
		String[] club1 = {"JAMES","HUGH","HUGH","GEORGE","ELIZABETH","ELIZABETH","HUGH",
				"DAVID","ROBERT","DAVID","BOB","BOBBY","PAM","JAMES","JAMES"};
		String[] club2 = {"BOBBY","ROBERT","GEORGE","JAMES","PEG","JAMES","DAVID","JOHN","LIZ",
				"SANDRA","GEORGE","JOHN","GEORGE","ELIZABETH","LIZ","JAMES"};
		String[] club3 = {"ROBERT","ROBERT","ROBERT","SANDRA","PAM","BOB","LIZ","GEORGE"};
		String[] expected = {"BOB","BOBBY","DAVID","ELIZABETH","GEORGE","JAMES","LIZ","PAM","ROBERT", "SANDRA"};
		String[] actual = memberCheck.whosDishonest(club1, club2, club3);
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2WhosDishonest() {
		String[] club1 = {"AHHOZY","AHHAPLL","ASNV"};
		String[] club2 = {"AHDLTOE","AHUKPJ","AHDENCTPP","AHDENCJ","AHDLNZC","AHDLTOGG","AHHAPMBG",
				"ALE","AHBHA","AHUKP","AHDQMILLP","AHDENEDY","AHDENEE","AHHOHVCX","AHISK",
				"AHW","AQDB","AHUP","AQDBNPU","AGWZUV","AHHOSUW","AHXS","AHDENCP","AHDQM",
				"AHDLTURV","AHBHVV","AHDQMILL","AHDQMD","AHH","AHDLTU","AHISFNO","AHURF",
				"AH","AHHAPNQ","AQPL","AHDXL","AHDLTUGX","AHDLT","AHUKRC","AHDLTUGX",
				"AQDTXYX","AGWZS"};
		String[] club3 = {"AHHAPMFF","AHURA","AHHOZ","AHISKH","AHUPR","AHHAPM","AHUKRHIN","AHHAP",
				"AHDLTMO","AHDLTUJ","AHDQY","AHUK","AHDENEDY","AHWK","AHHOZGJJ","AHXS",
				"AHDLTUREL","AHHOZQNL","AHHOSUWOS"};
		String[] expected = {"AHDENEDY", "AHXS"};
		String[] actual = memberCheck.whosDishonest(club1, club2, club3);
		Assertions.assertArrayEquals(expected, actual);
	}

}
