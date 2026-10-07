package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import okonkwo.DoubleList;
import okonkwo.StatCalculator;

/**
 * Test class for the {@code StatCalculator} class
 * <p>Comments, documentation, and code generated in part by GitHub Copilot</p>
 * @author Taj Okonkwo
 * @version 1.0.1
 */
class TestStatCalculator {

	/**
	 * Test {@code mean()} method
	 */
	@Test
	void testMean() {
		// 1. Create a list of doubles
		DoubleList list = new DoubleList();
		for (int i = 1; i <= 10; i++) {
			list.add((double)i);
		}
		
		// 2. Calculate the mean
		double mean = StatCalculator.mean(list);
		
		// 3. Assert that the mean is correct
		assertEquals(5.5, mean);
	}

	/**
	 * Test {@code stDev()} method
	 */
	@Test
	void testStDev() {
		// 1. Create a list of doubles
		DoubleList list = new DoubleList();
		for (int i = 1; i <= 10; i++) {
			list.add((double)i);
		}
		
		// 2. Calculate the standard deviation
		double stDev = StatCalculator.stDev(list);
		
		// 3. Assert that the standard deviation is correct
		assertEquals(3.0, Math.round(stDev));
	}

}
