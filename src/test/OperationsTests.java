package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.iut.uca.Operations;

class OperationsTests {

	private Operations op;
	private static Random rdm;
	
	@BeforeAll
	static void initAll() {
		rdm = new Random();
	}
	
	@BeforeEach 
    void initEach() {
		op = new Operations();
    }
	
	// --------------
	// add
	// --------------
	
	@Test
	void addBasic() {
		// Arrange
	
		long x = 1;
		long y = 2;
		long expected = 3;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void addBeyondMax() {
		// Arrange
		
		long x = Long.MAX_VALUE;
		long y = 1;
		long expected = Long.MIN_VALUE;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}

	@Test
	void addBelowMin() {
		// Arrange
		
		long x = Long.MIN_VALUE;
		long y = -1;
		long expected = Long.MAX_VALUE;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void addAllZeros() {
		// Arrange
		
		long x = 0;
		long y = 0;
		long expected = 0;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void addWithZeroLeft() {
		// Arrange
		
		long x = 0;
		long y = 2;
		long expected = 2;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void addWithZeroRight() {
		// Arrange
		
		long x = 4; 
		long y = 0;
		long expected = 4;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void addAllNegatives() {
		// Arrange
		
		long x = -3;
		long y = -4;
		long expected = -7;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void addOppositesCancelOut() {
		// Arrange
		
		long x = -4;
		long y = 4;
		long expected = 0;
		
		// Act
		
		long actual = op.add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void addManyNumbers() {
		// Arrange
		
		long x = 1;
		long y = 2;
		long z1 = 3;
		long z2 = 4;
		long z3 = 5;
		long expected = 15;
		
		// Act
		
		long actual = op.add(x, y, z1, z2, z3);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void addRdm() {
		
		for(int i = 0 ; i <10; i++) {
			// Arrange
		
			long rdmX =rdm.nextLong();
			long rdmY = rdm.nextLong();
		
			long expected;
		
			if(rdmX == 0) {
				expected = rdmY;
			} else if(rdmY == 0) {
				expected = rdmX;
			} else if(rdmX == rdmY * (-1)) {
				expected = 0;
			} else {
				expected = rdmX + rdmY;
			}
		
			// Act
		
			long actual = op.add(rdmX, rdmY, null);
		
			// Assert
		
			assertEquals(expected, actual);
		}
	}
	
	// --------------
	// multiply
	// --------------
	
	@Test 
	void multBasic() {
		// Arrange
		
		long x = 2;
		long y = 3;
		long expected = 6;
		
		// Act
		
		long actual = op.multiply(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void multWithOne() {
		// Arrange
		
		long x = 8;
		long y = 1;
		long expected = 8;
		
		// Act
		
		long actual = op.multiply(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	
	@Test 
	void multWithZero() {
		// Arrange
		
		long x = 0;
		long y = 2;
		long expected = 0;
		
		// Act
		
		long actual = op.multiply(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	
	@Test 
	void multWithNegLeft() {
		// Arrange
		
		long x = 4;
		long y = -2;
		long expected = -8;
		
		// Act
		
		long actual = op.multiply(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	
	@Test 
	void multWithNegRight() {
		// Arrange
		
		long x = -7;
		long y = 4;
		long expected = -28;
		
		// Act
		
		long actual = op.multiply(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void multWithMany() {
		// Arrange
		
		long x = 1;
		long y = 2;
		long z1 = 3;
		long z2 = 4;
		long z3 = 5;
		long expected = 120;
		
		// Act
		
		long actual = op.multiply(x, y, z1, z2, z3);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void multRdmEquals() {
		Random rdm = new Random();
		
		for(int i = 0 ; i <10; i++) {
			// Arrange
		
			long rdmX = rdm.nextLong();
			long rdmY = rdm.nextLong();
		
			long expected;
		
			if(rdmX == 1) {
				expected = rdmY;
			} else if(rdmY == 1) {
				expected = rdmX;
			} else if(rdmX == 0) {
				expected = 0;
			} else if(rdmY == 0) {
				expected = 0;
			} else {
				expected = rdmX * rdmY;
			}
		
			// Act
		
			long actual = op.multiply(rdmX, rdmY, null);
		
			// Assert
		
			assertEquals(expected, actual);
		}
	}
	
	@Test
	void multRdmIntervals() {
		
		for(int i = 0 ; i < 10 ; i++) {
			// Arrange
		
			long right = 3037000500L; // square root of 2^64, to avoid going beyond max_long or below min_long
			long left = -3037000499L;
			
			long rdmX = rdm.nextLong(left, right);
			long rdmY = rdm.nextLong(left, right);
		
			// Act
		
			long actual = op.multiply(rdmX, rdmY, null);
		
			// Assert
		
			if((rdmX > 0 && rdmY > 0)
					|| (rdmX < 0 && rdmY < 0)) {
					assertTrue(actual > 0);
				} else if((rdmX < 0 && rdmY > 0)
						|| (rdmX > 0 && rdmY < 0)) {
					assertTrue(actual < 0);
				} else { // rdmX == 0 || rdmY == 0
					assertTrue(actual == 0);
				}
		}
	}
	
	// --------------
	// divide
	// --------------
	
	@Test
	void divBasic() {
		// Arrange
		
		long x = 4;
		long y = 2;
		long expected = 2;
		
		// Act
		
		long actual = op.divide(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void divWithRemainder() {
		// Arrange
		
		long x = 6;
		long y = 4;
		long expected = 1; // would be 1.5 with real numbers
		
		// Act
		
		long actual = op.divide(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void divByZero() {
		// Arrange
		
		long x = 4;
		
		// Act
		
		long y = 0;

		// Assert

		Exception exc = assertThrows(ArithmeticException.class, () -> {
			op.divide(x, y, null);
		});
		assertEquals(exc.getMessage(), "attempted to divide by zero");
	}
	
	@Test
	void divByZeroVariadic() {
		// Arrange
		
		long x = 4;
		long y = 2;
		long z1 = 3;
		long z3 = 5;

		// Act 
		
		long z2 = 0;
		
		// Assert

		Exception exc = assertThrows(ArithmeticException.class, () -> {
			op.divide(x, y, z1, z2, z3);
		});
		assertEquals(exc.getMessage(), "attempted to divide by zero");
	}
}
