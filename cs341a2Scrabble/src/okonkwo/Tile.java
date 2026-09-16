package okonkwo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A class that represents a tile with a letter on it.
 * 
 * @author Taj Okonkwo
 * @version 1.0
 */
public class Tile {

	/**
	 * The letter on the tile.
	 */
	private char letter;

	/**
	 * Constructs a tile with the given letter.
	 * 
	 * @param letter the letter on the tile
	 */
	public Tile(char letter) {
		super();
		this.letter = letter;
	}

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
		return (letter == ((Tile) o2).letter);
	}

	@Override
	public String toString() {
		return "[" + letter + "]";
	}

	/**
	 * Generates all unique permutations of the tiles in the given list.
	 * 
	 * This method uses a randomization approach to generate permutations. It
	 * randomly shuffles the input list and checks if the resulting permutation
	 * is unique (not already in the result set). This process continues until
	 * all n! permutations have been generated, where n is the size of the input list.
	 * 
	 * <p><b>Algorithm:</b>
	 * <ol>
	 * <li>Randomize the input list by removing random elements and building a new list</li>
	 * <li>Check if the generated permutation already exists in the result set</li>
	 * <li>If unique, add it to the result set</li>
	 * <li>Repeat until the number of permutations equals n! (factorial of n)</li>
	 * </ol>
	 * </p>
	 * 
	 * <p><b>Note:</b> This method modifies the input list. If the original list
	 * needs to be preserved, a copy should be passed to this method instead.</p>
	 * 
	 * @param tileList an {@code ArrayList} of {@code Tile} objects to permute
	 * @return a {@code HashSet} containing all unique permutations of the input tiles
	 * @throws ClassCastException if tileList contains elements that are not {@code Tile} objects
	 * @throws NullPointerException if tileList is null
	 * 
	 * @see #factorial(int)
	 */
	public static HashSet<ArrayList<Tile>> permutations(ArrayList<Tile> tileList) {
		// 1. Randomize the list by removing random elements and adding to a new list
		// <randList> until <tileList> is empty.
		HashSet<ArrayList<Tile>> perms = new HashSet<>();
		int size = tileList.size();
		
		ArrayList<Tile> randList = new ArrayList<>();
		while (true) {
			for (int i = 0; i < size; i++)
				randList.add(tileList.remove((int) (Math.random() * tileList.size())));

			// 2. Check <randList> against members of the return set <perms>. If an
			// identical permutation already exists, reset <tileList> and redo Step 1.
			if (perms.contains(randList))
				continue;
			else {
				perms.add(tileList);
				// 3. Once the size of <perms> reaches <size> factorial, return <perms>
				if (perms.size() == factorial(size))
					return perms;
			}
		}
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