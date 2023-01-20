package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.iut.uca.Operations;

class OperationsTests {

	private Operations op;
	
	@BeforeEach 
    void init() {
		op = new Operations();
    }
	
	@Test
	void basicAdd() {
		// Arrange
	
		long x = 1;
		long y = 2;
		long expected = 3;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void beyondMax() {
		// Arrange
		
		long x = Long.MAX_VALUE;
		long y = 1;
		long expected = Long.MIN_VALUE;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}

	@Test
	void belowMin() {
		// Arrange
		
		long x = Long.MIN_VALUE;
		long y = -1;
		long expected = Long.MAX_VALUE;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void allZeros() {
		// Arrange
		
		long x = 0;
		long y = 0;
		long expected = 0;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void withZeroLeft() {
		// Arrange
		
		long x = 0;
		long y = 2;
		long expected = 2;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void withZeroRight() {
		// Arrange
		
		long x = 4; 
		long y = 0;
		long expected = 4;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void allNegatives() {
		// Arrange
		
		long x = -3;
		long y = -4;
		long expected = -7;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void oppositesCancelOut() {
		// Arrange
		
		long x = -4;
		long y = 4;
		long expected = 0;
		
		// Act
		
		long actual = op.Add(x, y, null);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test 
	void manyNumbers() {
		// Arrange
		
		long x = 1;
		long y = 2;
		long z1 = 3;
		long z2 = 4;
		long z3 = 5;
		long expected = 15;
		
		// Act
		
		long actual = op.Add(x, y, z1, z2, z3);
		
		// Assert

		assertEquals(expected, actual);
	}
	
	@Test
	void rdm() {
		for(int i = 0 ; i <10; i++) {
			// Arrange
		
			Random rdm = new Random();
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
		
			long actual = op.Add(rdmX, rdmY, null);
		
			// Assert
		
			assertEquals(expected, actual);
		}
	}
}
