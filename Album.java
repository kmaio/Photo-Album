import java.util.ArrayList;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public class Album extends PhotographContainer{
	/**
	 * Here is the constructor that initializes the fields
	 */
	public Album(String name) {
		super (name);
		this.photos = new ArrayList<>();
	}


}
