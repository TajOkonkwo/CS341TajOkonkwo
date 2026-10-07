package okonkwo;

/**
 * A {@code LinkedList} of doubles for numeric analysis
 * <p>Comments, documentation, and code generated in part by GitHub Copilot</p>
 * @author Taj Okonkwo
 * @version 1.0.1
 */
public class DoubleList extends LinkedList<Double> {
	
	// Constructors
	/**
	 * Default constructor | Create an empty list of doubles
	 */
	public DoubleList() {
		super();
	}
	
	/**
	 * Explicit constructor | Create a list from an array of doubles
	 * @param doubles - the doubles to add
	 */
	public DoubleList(Double[] doubles) {
		super();
		for (Double d: doubles) {
			add(d);
		}
	}
	
}
