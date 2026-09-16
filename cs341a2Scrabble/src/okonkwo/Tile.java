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
