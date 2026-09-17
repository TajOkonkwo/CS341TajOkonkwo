package okonkwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * A class that represents a tile with a letter on it.
 * 
 * @author Taj Okonkwo
 * @version 1.0
 */
public class Tile {

	// Data Members
	/**
	 * The letter on the tile.
	 */
	private char letter;

	// Constructors
	/**
	 * Constructs a tile with the given letter. The letter will be upper-case
	 * 
	 * @param letter the letter on the tile
	 */
	public Tile(char letter) {
		super();

		if (!(('a' <= letter && letter <= 'z') || ('A' <= letter && letter <= 'Z')))
			throw new NotALetterException("'" + letter + "' was entered. Only letters allowed!");

		this.letter = Character.toUpperCase(letter);
	}

	// Exceptions
	/**
	 * An exception that is thrown when a non-letter character is used to create a
	 * Tile.
	 */
	public class NotALetterException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NotALetterException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public NotALetterException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public NotALetterException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public NotALetterException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public NotALetterException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}

	}

	// Methods
	/**
	 * Returns the letter on the tile.
	 * 
	 * @return the letter on the tile
	 */
	public char getLetter() {
		return letter;
	}

	@Override
	public boolean equals(Object o2) {
		if (this == o2)
			return true;
		if (o2 == null)
			return false;
		if (getClass() != o2.getClass())
			return false;
		Tile other = (Tile) o2;
		return this.letter == other.letter;
	}

	@Override
	public String toString() {
		return "" + letter;
	}

	/**
	 * Overrides {@code Object.hashCode()} by only checking letter equivalence
	 */
	@Override
	public int hashCode() {
		// Must be consistent with equals so HashSet and other hash-based
		// collections can correctly detect Tiles with the same letter.
		return Character.hashCode(letter);
	}

	/**
	 * Returns a list of all unique permutations of the given list of tiles.
	 * 
	 * @param tiles an {@code ArrayList} of {@code Tile} objects
	 * @return an {@code ArrayList} of {@code ArrayList<Tile>} objects, each
	 *         representing a unique permutation of the input tiles
	 */
	public static ArrayList<ArrayList<Tile>> uniquePermutations(ArrayList<Tile> tiles) {
		int n = tiles.size();
		// TreeMap gives deterministic sorted order of keys (letters)
		java.util.Map<Character, Integer> counts = new java.util.TreeMap<>();
		for (Tile t : tiles) {
			counts.put(t.getLetter(), counts.getOrDefault(t.getLetter(), 0) + 1);
		}

		ArrayList<ArrayList<Tile>> result = new ArrayList<>();
		ArrayList<Tile> current = new ArrayList<>(n);
		backtrackPermutations(counts, n, current, result);
		return result;
	}

	private static void backtrackPermutations(java.util.Map<Character, Integer> counts, int targetLength,
			ArrayList<Tile> current, ArrayList<ArrayList<Tile>> result) {
		if (current.size() == targetLength) {
			// copy of current permutation; create new Tile instances
			result.add(new ArrayList<>(current));
			return;
		}

		for (java.util.Map.Entry<Character, Integer> e : counts.entrySet()) {
			char ch = e.getKey();
			int c = e.getValue();
			if (c == 0)
				continue;
			counts.put(ch, c - 1);
			current.add(new Tile(ch)); // safe: Tile constructor accepts letters
			backtrackPermutations(counts, targetLength, current, result);
			current.remove(current.size() - 1);
			counts.put(ch, c); // restore
		}
	}

	/**
	 * Returns the number of unique elements in the given list of tiles.
	 * 
	 * @param tileList an {@code ArrayList} of {@code Tile} objects
	 * @return the number of unique elements in the list
	 */
	public static int numUniqueTiles(ArrayList<Tile> tileList) {
		HashSet<Tile> uniqueElements = new HashSet<Tile>(tileList);
		return uniqueElements.size();
	}
}