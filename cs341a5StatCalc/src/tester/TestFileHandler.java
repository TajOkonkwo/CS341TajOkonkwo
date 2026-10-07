package tester;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.InterruptedIOException;

import javax.swing.JFileChooser;

import org.junit.jupiter.api.Test;

import okonkwo.FileHandler;

/**
 * A class for testing the {@code FileHandler} class
 * <p>Comments, documentation, and code generated in part by GitHub Copilot</p>
 * @author Taj Okonkwo
 * @version 1.0.1
 */
class TestFileHandler {

	/**
	 * Test the explicit constructor
	 */
	@Test
	void testFileHandler() {
		// 1. Create new file and create a file handler with it
		FileHandler handler = newFileHandler();
	}

	@Test
	void testChooseFile() {
		// 1. Create new file chooser and create a file handler with it
		FileHandler handler = newFileHandler();
		
		// 2. Assert that the file is null before choosing a file
		assertNull(handler.getFile());
		
		// 3. Select a file with the chooser
		try {
			handler.chooseFile();
		} catch (InterruptedIOException e) {
			fail("Interrupted");
		}
		
		// 4. Assert that the file exists
		assertNotNull(handler.getFile());
		
		// 5. Select a new file with the chooser
		try {
			handler.chooseFile();
		} catch (InterruptedIOException e) {
			fail("Interrupted");
		}
		
		// 6. Assert that the file exists
		assertNotNull(handler.getFile());
	}

	@Test
	void testFileText() {
		// 1. Create new file and create a file handler with it
		FileHandler handler = newFileHandler();
		
		// 2. Select a file with the chooser
		try {
			handler.chooseFile();
		} catch (InterruptedIOException e) {
			fail("Interrupted");
		}
		
		// 3. Test-print the file's text
		try {
			System.out.println(handler.fileText());
		} catch (FileNotFoundException e) {
			fail("File not found");
		}
	}

	/**
	 * Test the {@code toDoubleList()} method
	 */
	@Test
	void testToDoubleList() {
		// 1. Create new file chooser and create a file handler with it
		FileHandler handler = newFileHandler();
		
		// 2. Select a file with the chooser
		try {
			handler.chooseFile();
		} catch (InterruptedIOException e) {
			fail("Interrupted");
		}
		
		// 3. Assert that the double list is not empty
		try {
			assertNotEquals(0, handler.toDoubleList().size());
		} catch (FileNotFoundException e) {
			fail("File not found");
		}
	}

	/**
	 * Test the {@code getFile()} method
	 */
	@Test
	void testGetFile() {
		// 1. Create new file chooser and create a file handler with it
		FileHandler handler = newFileHandler();
		
		// 2. Select a file with the chooser
		try {
			handler.chooseFile();
		} catch (InterruptedIOException e) {
			fail("Interrupted");
		}
		
		// 3. Assert that the file is not null
		assertNotNull(handler.getFile());
	}
	
	/**
	 * Create a new file handler with a new file chooser
	 */
	private static FileHandler newFileHandler() {
		// 1. Create new file chooser
		JFileChooser chooser = new JFileChooser();
		
		// 2. Create a file handler with it
		FileHandler handler = new FileHandler(chooser);
		
		return handler;
	}

}
