import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */
public class Photograph implements Comparable<Photograph> {
	
	/**
	 * Here are the fields (instance variables)
	 */
	private String caption;
	private String filename;
	private String dateTaken;
	private int rating;
	protected BufferedImage imageData; 
	
	/**
	 * Here is the constructor that initializes the fields
	 */
	public Photograph(String caption, String filename) {//remember to set like this!!
		this.caption = caption;
		this.filename = filename;
		this.dateTaken = "1901-01-01";
		this.rating = 0;
	}
	
	public Photograph(String caption, String filename, String dateTaken, int rating) {
		int month = dateTaken.charAt(5);
		int month2 = dateTaken.charAt(6);
		int day = dateTaken.charAt(8);
		int day2 = dateTaken.charAt(9);
		if(rating >= 0 && rating <= 5) {
			this.rating = rating;
		}
		this.dateTaken = dateTaken;
		if(dateTaken.charAt(4) != '-'  || dateTaken.charAt(7) != '-') {
			dateTaken = this.dateTaken;
		}
		
		if(month > 1 || (month == 1 && month2 > 2)) {
			dateTaken = this.dateTaken;
		}
		
		if(day > 3 || (day == 3 && day2 > 1)) {
			dateTaken = this.dateTaken;
		}
		this.filename=filename; //always set/initialize your global variables
		this.caption=caption;   //otherwise you will lose them outside of constructor
								//aka null values == null pointer exceptions
	}
	
	/**
	 * These are the accessor methods (AKA getters)
	 * @return the references to the caption and filename fields
	 */
	public String getCaption() {
		return caption;
	}
	public String getFilename() {
		return filename;
	}
	public String getDateTaken() {
		return dateTaken;
	}
	public int getRating() {
		return rating;
	}
	protected BufferedImage getImageDate() {
		return imageData;
	}
	
	/**
	 * These are the mutator methods for the rating and caption fields 
	 */
	public void setRating(int r) {
		this.rating = r;
	}
	
	public void setCaption(String c) {
		this.caption = c;
	}
	
	protected void setImageData(BufferedImage id) {
		this.imageData = id;
	}
	
	
	/**
	 * Here is the equals method
	 * @return true if the Photograph object passed to equals() with caption and filename 
	 * match the caption and filename strings of the current Photograph object
	 * @return false if otherwise
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof Photograph) {
			Photograph p = (Photograph) o;
			if ((this.caption.equals(p.caption)&&!this.caption.equals(null)) && (this.filename.equals(p.filename)&&!this.filename.equals(null))) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else {
			return false;
			}
	}
	
	/**
	 * This hashCode() method overrides the default hashCode method in Object class and produces a 
	 * unique integer for a Photograph
	 * @return the hashCode() of the filename field 
	 */
	@Override
	public int hashCode() {
		return filename.hashCode();
	}
	
	
	/**
	 * Here is the tostring() method that generates a string that shows the values of the
	 * fields caption and filename  
	 */
	public String toString() {
		return "Caption: " + caption + ", " + "Filename: " + filename;
	}
	
	/**
	 * This compareTo() method compares the dateTaken of the current Photograph object with the 
	 * given parameter
	 * @param Photograph p
	 * @return negative number if the current object's dateTaken is before parameter P
	 * @return positive number if the if parameter p's date is earlier
	 * @return a comparison of the object's caption if the dates are equal
	 */
	@Override 
	public int compareTo(Photograph p) {
		int compareDate = this.dateTaken.compareTo(p.dateTaken);
		if (compareDate == 0) {
			int compareCaption = this.caption.compareTo(p.caption);
			return compareCaption;
		}
		return compareDate;
	}
	
	public boolean loadImageData(String filename1) {
		try {
			BufferedImage img= ImageIO.read(new File(filename1));
			this.imageData =  img;
			return true;
				
		}
		catch(IOException e) {
			System.out.print("Failed or interrupted IO operations");
			return false;
		}
	} 
		
}	