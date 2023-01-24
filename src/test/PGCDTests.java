package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.iut.uca.PGCD;

public class PGCDTests {
	private PGCD myObject;
	private static Random rdm;
	
	@BeforeAll
	static void initAll() {
		rdm = new Random();
	}
	
	@BeforeEach 
    void initEach() {
		myObject = new PGCD();
    }
	
	// --------------
	// add
	// --------------
	
	@Test
	void addBasic() {
		// Arrange
	
		int a = 1;
		int b = 2;
		int expected = 3;
		
		// Act
		
		int actual = myObject.pgcd(a, b);
		
		// Assert
		assertEquals(expected, actual);
	}
	
}
