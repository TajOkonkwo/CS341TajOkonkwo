package okonkwo;

import java.util.NoSuchElementException;

public class Dictionary extends BSTree<String> {

	public Dictionary() {
		super();
	}
	
	/**
	 * Unsupported operation | Use {@code insertWordNode()} instead.
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void add(String word) {
		throw new UnsupportedOperationException("Use 'insertWordNode' instead");
	}
	
	/**
	 * Unsupported operation | Use {@code checkWord()} instead.
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void remove(String word) {
		throw new UnsupportedOperationException("Use 'checkWord' instead");
	}
	
	/**
	 * Add a word node to the tree
	 * <p>The word can only contain letter characters with no spaces</p>
	 * @param word - The word string to add
	 * @throws DuplicateNodeException if {@code word} already exists in
	 *                                the tree
	 * @throws IllegalArgumentException if {@code word} contains non-letter characters
	 */
	public void insertWordNode(String word) {
		// 1. Check for non-letter characters
		for (char c: word.toCharArray()) {
			if (!Character.isAlphabetic(c))
				throw new IllegalArgumentException("The word '" + word + "' contains non-letter characters.");
		}
		
		// 2. Add the word
		super.add(word);
	}
	
	/**
	 * Remove a word node from the tree
	 * @param word - The word string to remove
	 * @throws EmptyTreeException     if attempting to remove an element from an
	 *                                empty tree
	 * @throws NoSuchElementException if {@code word} does not exist in the tree
	 *
	 */
	public void checkWord(String word) {
		super.remove(word);
	}
	
}
