import java.util.Comparator;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public class CompareByRating implements Comparator<Photograph> {
	/**
	 * This method compares the ratings of two photos. 
	 * @param p1 and p2
	 * @return compareRating, which is the ordering of the photo's ratings in descending order
	 * @return 1.getCaption().compareTo(p2.getCaption(), if ratings are the same, which is the 
	 * ordering of the photo's captions in alphabetical order
	 */
	public int compare(Photograph p1, Photograph p2) {
		int compareRating = p2.getRating()- p1.getRating();
		return compareRating;
	}
	

}
