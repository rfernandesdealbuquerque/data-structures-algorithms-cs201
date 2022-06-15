package test.apt2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import main.apt2.DNAMaxNucleotide;

public class DNAMaxNucleotideTest {
	
	DNAMaxNucleotide dnaMaxNucleotide = new DNAMaxNucleotide();

	@DisplayName("DNAMaxNucleotide Test 1")
	@Test
	public void test1Max() {
		String[] strands = {"agt", "aagt", "taattt", "ccatg" };
		String nuc = "a";
		String actual = dnaMaxNucleotide.max(strands, nuc);
		Assertions.assertEquals("taattt", actual);
		
		
	}

}
