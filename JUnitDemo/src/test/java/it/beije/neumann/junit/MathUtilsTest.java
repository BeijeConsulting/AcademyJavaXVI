package it.beije.neumann.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class MathUtilsTest {
	
	// --- assertEquals, assertNotEquals ---
	@Test
	void testSubtraction1() {
		int expected = -9;
		int actual;
		
		actual = MathUtils.subtraction(4, 13);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSubtraction2() {
		int expected = 50;
		int actual;
		
		actual = MathUtils.subtraction(2, 1);
		
		assertNotEquals(expected, actual);
	}
	
	// --- assertArrayEquals ---	
	@Test
	void testArraySum1() {
		int a[] = {3, 6, 8};
		int b[] = {5, 9, 4};
		
		int expected[] = {8, 15, 12};
		int actual[] = MathUtils.arraySum(a, b);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testArraySum2() {
		int a[] = {3, 6, 8, 9, 4};
		int b[] = {5, 9, 4};
		
		int expected[] = {8, 15, 12, 9, 4};
		int actual[] = MathUtils.arraySum(a, b);
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	void testArraySum3() {
		int a[] = {3, 6, 8};
		int b[] = {5, 9, 4, 7, 3};
		
		int expected[] = {8, 15, 12};
		int actual[] = MathUtils.arraySum(a, b);
		
		assertArrayEquals(expected, actual); // NON esiste assertArrayNotEquals!
	}
	
	// --- assertNull ---	
	@Test
	void testSumExpression1() {
		assertNull(MathUtils.sumExpression(null));
	}
	
	@Test
	void testSumExpression2() {
		int a[] = {3, 6, 8};
		assertNotNull(MathUtils.sumExpression(a));
	}
	
	// --- assertTrue, assertFalse ---	
	@Test
	void testIsEven1() {
		assertTrue(MathUtils.isEven(6));
	}
	
	@Test
	void testIsEven2() {
		assertFalse(MathUtils.isEven(5));
	}
	
	@Test
	void fallito() {
		System.out.println("Sto eseguendo un test");
		fail();
	}

	// Error e failures sono due cose diverse...
	@Test
	void divisionTest() {
		float expected = 0;
		float actual;
		
		actual = MathUtils.division(10, 0);
		
		assertEquals(expected, actual);
	}
	
	@Disabled
	@Test
	void disabledTest() {
		System.out.println("secondo test");
	}
	
	//le classi con annotations @BeforeAll e @AfterAll devono essere static!
	@BeforeAll
	static void beforeTests() {
		System.out.println("Prima di eseguire i test");
	}
	
	@AfterAll
	static void afterTests() {
		System.out.println("Dopo aver eseguito i test");
	}
}
