package test.apt4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.apt4.SoccerLeagues;

public class SoccerLeaguesTest {
	
	SoccerLeagues soccerLeagues = new SoccerLeagues();

	@Test
	public void test1Points() {
		String[] matches = {"-LWWLWDLDWWWWWWDDWDW",
				 "D-WWLDDWDWDLWDDWLWDD",
				 "LL-DLDWDLDLDWWWLWDDW",
				 "LDD-LLLDLWLWWWWDWDWL",
				 "LWWW-DWDLWDWDWWWDWDW",
				 "DLLWD-WWLLDDDLWWDWWW",
				 "WWLWDL-LLDWWWWWDWWLW",
				 "LLLLLDW-LDLWDDLLLDWL",
				 "DWWWWDDD-DWWWWDWWWDW",
				 "WWWWLLLWL-LWWWWWLWWW",
				 "DWWWWWWWLW-WDWWWWWWW",
				 "DDDLLLDWWWL-DDWDWLDD",
				 "LWLWLDLLLDLW-DDDWWDD",
				 "LLWWLWDDLWLWL-WWWDLL",
				 "WWWWLLDDDWLWDD-WWWLW",
				 "DLDLLLWWLLLWWLW-DWLL",
				 "DLWWWLDLWWDWWDWL-WWD",
				 "LLDDLLWLLWLWLDLWW-WW",
				 "LLWLLLWWLWLWWDWWLD-W",
				 "LLWDLWDWDWLLWWDDWWL-"};
		int[] actual = soccerLeagues.points(matches);
		int[] expected = {72, 62, 41, 41, 83, 63, 53, 35, 86, 50, 90, 32, 34, 41, 45, 36, 51, 32, 51, 45 };
		Assertions.assertArrayEquals(expected, actual);
	}

}
