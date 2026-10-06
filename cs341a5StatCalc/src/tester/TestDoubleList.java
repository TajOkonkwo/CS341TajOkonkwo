package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import okonkwo.DoubleList;
import okonkwo.LinkedList;

class TestDoubleList {

	/**
	 * Test the default constructor
	 */
	@Test
	void testDoubleList() {
		// 1. Create a new list
		DoubleList list = new DoubleList();
		
		// 2. Assert that the list is an instance of LinkedList
		assertTrue(list instanceof LinkedList<Double>);
		
		// 3. Assert that the list is empty
		assertTrue(list.isEmpty());
	}

	@Test
	void testDoubleListDoubleArray() {
		// 1. Create an array of doubles
		Double[] doubles = new Double[10];
		for (int i = 0; i < 10; i++) {
			doubles[i] = (double) i;
		}
		
		// 2. Construct a list from the doubles
		DoubleList list = new DoubleList(doubles);
		
		// 3. Assert that each value is contained
		assertTrue(list.containsAll(Arrays.asList(doubles)));
	}

}
