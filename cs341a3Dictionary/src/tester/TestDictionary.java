package tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import okonkwo.Dictionary;

class TestDictionary {

	/**
	 * Test the constructor
	 */
	@Test
	void testDictionary() {
		// 1. Create a new Dictionary
		Dictionary dict = new Dictionary();
		
		// 2. Assert that it is empty
		assertTrue(dict.isEmpty());
	}

	/**
	 * Test the {@code add()} method (Overrode by {@code insertWordNode()})
	 */
	@Test
	void testAddString() {
		// 1. Create a new Dictionary
		Dictionary dict = new Dictionary();
		
		// 2. Assert that an addition from the superclass will throw an exception
		assertThrows(UnsupportedOperationException.class, () -> {
			dict.add("my word");
		});
	}

	/**
	 * Test the {@code remove()} method (Overrode by {@code checkWord()})
	 */
	@Test
	void testRemoveString() {
		// 1. Create a new Dictionary
		Dictionary dict = new Dictionary();
		
		// 2. Assert that a removal from the superclass will throw an exception
		assertThrows(UnsupportedOperationException.class, () -> {
			dict.remove("to remove");
		});
	}

	@Test
	void testInsertWordNode() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckWord() {
		fail("Not yet implemented");
	}

}
