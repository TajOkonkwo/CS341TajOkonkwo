package tester;

import java.util.ArrayList;
import java.util.ArrayList;

import okonkwo.Tile;

/**
 * A test main class
 * @author Taj Okonkwo
 * @version 1.0
 */
public class TesterMain {

	public static void main(String[] args) {
		// Test Tile class
		ArrayList<Tile> myTileList = new ArrayList<>();
		
		myTileList.add(new Tile('A'));
		myTileList.add(new Tile('A'));
		//myTileList.add(new Tile('C'));
		//myTileList.add(new Tile('D'));
		//myTileList.add(new Tile('E'));
		int size = myTileList.size();
		
		ArrayList<ArrayList<Tile>> perms = Tile.permutations(myTileList);
		System.out.println("Permutations: " + perms);
		System.out.println("Size of list: " + size);
		System.out.println("Size of perms: " + perms.size());
	}

}
