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
	 * An exception that is thrown when a non-letter character is used to create a Tile.
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
	 * Generates all unique permutations of the tiles in the given list.
	 * 
	 * This method uses a randomization approach to generate permutations. It
	 * randomly shuffles the input list and checks if the resulting permutation
	 * is unique (not already in the result set). This process continues until
	 * all n! permutations have been generated, where n is the number of <b>unique</b> 
	 * tiles in the input list.
	 * 
	 * <p><b>Algorithm:</b>
	 * <ol>
	 * <li>Count the number of tiles in the input list</li>
	 * <li>Randomize the input list by removing random elements and building a new list</li>
	 * <li>Check if the generated permutation already exists in the result set</li>
	 * <li>If unique, add it to the result set</li>
	 * <li>Repeat until the number of permutations equals n! (factorial of the number of tiles)</li>
	 * </ol>
	 * </p>
	 * 
	 * <p><b>Note:</b> This method modifies the input list. If the original list
	 * needs to be preserved, a copy should be passed to this method instead.
	 * If the list contains duplicate tiles, the number of permutations will be 
	 * k!, where k is the number of unique tiles (not the total size of the list).</p>
	 * 
	 * @param tileList an {@code ArrayList} of {@code Tile} objects to permute
	 * @return a {@code ArrayList} containing all unique permutations of the input tiles,
	 *         where the count equals the factorial of the number of unique tiles
	 * @throws ClassCastException if tileList contains elements that are not {@code Tile} objects
	 * @throws NullPointerException if tileList is null
	 * 
	 * @see #factorial(int)
	 * @see #numUniqueTiles(ArrayList)
	 */
	public static ArrayList<ArrayList<Tile>> permutations(ArrayList<Tile> tileList) {
		// 1. Randomize the list by removing random elements and adding to a new list
		// <randList> until <tileList> is empty.
		ArrayList<ArrayList<Tile>> perms = new ArrayList<>();
		int size = tileList.size();
		
		ArrayList<Tile> randList = (ArrayList<Tile>) tileList.clone();
		while (true) {
			Collections.shuffle(randList);
			
			// 2. Check <randList> against members of the return set <perms>. If an
			// identical permutation already exists, reset <tileList> and redo Step 1.
			tileList = (ArrayList<Tile>) randList.clone();
			if (perms.contains(randList)) {
				// Old permutation
				randList = new ArrayList<>();
			} else {
				// New permutation
				perms.add(randList);
				randList = new ArrayList<>();
			}
			
			// 3. Once the size of <perms> reaches <size> factorial, return <perms>
			if (perms.size() == factorial(size))
				return perms;
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

	/**
	 * Returns the factorial of a given number.
	 * 
	 * @param x the number to calculate the factorial of
	 * @return the factorial of x
	 */
	public static int factorial(int x) {
		if (x == 0)
			return 1;
		else
			return x * factorial(x - 1);
	}
}