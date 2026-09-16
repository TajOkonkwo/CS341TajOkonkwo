package okonkwo;

public class Tile {

	private char letter;

	public Tile(char letter) {
		super();
		this.letter = letter;
	}
	
	public char getLetter() {
		return letter;
	}

	public boolean equals(Object o2) {
		return (letter == ((Tile) o2).letter);
	}

	@Override
	public String toString() {
		return "[" + letter + "]";
	}
}
