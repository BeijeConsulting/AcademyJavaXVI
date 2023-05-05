package it.beije.neumann.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
		int expected = -9;
		int actual;
		
		actual = MathUtils.subtraction(4, 13);
		
		assertEquals(expected, actual);
	}

	@Disabled
	@Test
	void test2() {
		System.out.println("secondo test");
	}
}
