import java.util.Comparator;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public class CompareByCaption implements Comparator<Photograph> {
	/**
	 * This method compares the captions of two photos. 
	 */
	public int compare(Photograph p1, Photograph p2) {
		int compareCaption = p1.getCaption().compareTo(p2.getCaption());
		return compareCaption;
	}
	

}
