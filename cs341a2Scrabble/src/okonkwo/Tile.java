package okonkwo;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * A class that represents a tile with a letter on it.
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
	 * @param letter the letter on the tile
	 */
	public Tile(char letter) {
		super();
		this.letter = letter;
	}
	
	/**
	 * Returns the letter on the tile.
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
}
