import java.util.ArrayList;


/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public abstract class PhotographContainer {
		/**
		 * Here are the fields (instance variables) from Album class
		 */
		protected String name;
		protected ArrayList<Photograph> photos = new ArrayList<>();
		
		/**
		 * Here is the constructor that initializes the fields from Album class
		 */
		public PhotographContainer(String name) {
			this.name = name;
			this.photos = new ArrayList<Photograph>();
		}
		
		/**
		 * These are the accessor methods (AKA getters) from Album class
		 * @return references to the name and photo fields
		 */
		public String getName() {
			return name;
		}
		public ArrayList<Photograph> getPhotos(){
			ArrayList<Photograph> p = new ArrayList<>();
			for(Photograph i : photos) {
				p.add(i);
			}
			return p;
		}
		
		/**
		 * These are the mutator (setter) methods for the name field from Album class
		 */
		public void setName(String n) {
			this.name = n;
		}
		
		/**
		 * Adds Photograph p to list of current object's photos if and only if it was not already in the list
		 * from Album class
		 * @param Photogrph p
		 * @return true if Photograph was added
		 * @return false if it was not added or if p is null
		 */
		public boolean addPhoto(Photograph p) {
			if(p== null) {
				return false;
			}
			if(photos.contains(p) == false) {
				photos.add(p);
				return true;
			}
			return false;
		}
		
		/**
		 * here is the hasPhoto() method from Album class
		 * @param Photogrpah p
		 * @return true if the current object has p 
		 * @return false if it doesn't
		 */
		
		public boolean hasPhoto(Photograph p) {
			for(Photograph i: photos) {
				if(i.equals(p)) {
					return true;
				}
			}
			return false;
		}
		
		public void setPhotos(ArrayList<Photograph> list)
		{
			
			this.photos = list;
		}
		/**
		 * removePhoto() method from Album class
		 * @param p
		 * @return true if p was in list of photos and was removed
		 * @return false if it wasn't in list and wasn't removed
		 */
		public boolean removePhoto(Photograph p) {
			for(Photograph i: photos) {
				if(i.equals(p)) {
					photos.remove(p);
					return true;
				}
				
			}
				return false;
		}
		
		/**
		 * numPhotograph() method from Album class
		 * @return number of Photographs in current album 
		 */
		public int numPhotographs() {
			return photos.size();
		}
		
		/**
		 * here is the equals() method from Album class
		 * @param Object o
		 * @return true if current Album's object's name is equal to name of Album object 
		 * passed to equals()
		 * @return false if not or if object passed to equals is null
		 */
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			if (o instanceof Album) {
				Album a = (Album) o;
				if (this.name.equals(a.name)) {
					return true;
				}
				else {
					return false;
				}
			}
		
			return false;		
		}
		

		/**
		 * the toString() method from Album class
		 * Generates a string that has the name of the album on the first line,
		 * followed by a list of the contained photos' filenames
		 */
		public String toString() {
			ArrayList<String> filenames = new ArrayList<String>();
			for(Photograph p : photos) {
				filenames.add(p.getFilename());
			}
			return "Album Name: " + name + "\n" + "Photo's Filename: " + filenames + "\n";
		
		}
		
		/**
		 * hashCode() method from Album class
		 * Overrides the default hashCode method in Object class
		 * @return the hashCode() of the name field
		 */
		@Override
		public int hashCode() {
			return name.hashCode();
		}
		
		/**
		 * getPhotos method from PhotoLibrary class
		 * @param rating
		 * @return an ArrayList called ratedPhotos that have photos that have a rating
		 * greater than or equal to the parameter rating. Will return an empty ArrayList if
		 * there are no ratings greater than or equal to
		 * @return null if rating is incorrectly formatted
		 */
		public ArrayList<Photograph> getPhotos(int rating) {
			ArrayList<Photograph> ratedPhotos = new ArrayList<Photograph>();
			if(rating < 0 || rating > 5) {
				return null;
			}
			for(Photograph i : photos) {
				if(i.getRating() >= rating) {
					ratedPhotos.add(i);
				}
			}
			return ratedPhotos;
		}
		
		/**
		 * This method returns an ArrayList from photos feed that were taken in the same year
		 * as the parameter year from PhotoLibrary class
		 * @param year
		 * @return yearPhotos with an ArrayList of photos from the same year
		 * @return null if year is incorrectly formatted 
		 */
		
		public ArrayList<Photograph> getPhotosInYear(int year){
			ArrayList<Photograph> yearPhotos = new ArrayList<Photograph>();
			if(String.valueOf(year).length() != 4) {
				return null;
			}
			for(Photograph i : photos) {
				String justYear = i.getDateTaken().substring(0,4);
				int justYearInt = Integer.parseInt(justYear);
				if(justYearInt == year) {
					yearPhotos.add(i);
				}
			}
			return yearPhotos;
		}
		
		/**
		 * Returns an ArrayList of photos from the photos feed that were taken in the month 
		 * and year provided from PhotoLibrary class
		 * @param month
		 * @param year
		 * @return yearAndMonthPhotos ArrayList that were taken in same month and year as 
		 * provided
		 * @return null if month or year are incorrectly formatted
		 */
		public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
			ArrayList<Photograph> yearAndMonthPhotos = new ArrayList<Photograph>();
			if(String.valueOf(year).length() != 4) {
				return null;
			}
			if(month > 12 || month < 1)  {
				return null;
			}
			for(Photograph i : photos) {
				String justYear = i.getDateTaken().substring(0,4);
				int justYearInt = Integer.parseInt(justYear);
				String justMonth1Num = i.getDateTaken().substring(6,7);
				int justMonth1Int = Integer.parseInt(justMonth1Num);
				String justMonth2Num = i.getDateTaken().substring(5,7);
				int justMonth2Int = Integer.parseInt(justMonth2Num);
				if((justMonth1Int == month || justMonth2Int ==month) && (justYearInt == year)){
					yearAndMonthPhotos.add(i);
				}
			}
			return yearAndMonthPhotos;
		}
		
		/**
		 * This method returns an ArrayList of photos from the photos feed that were taken 
		 * between the begin date and end date given from PhotoLibrary class
		 * @param beginDate
		 * @param endDate
		 * @return ArrayList photosBewtween
		 * @return null if if beginDate or endDate are incorrectly formatted
		 */
		public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
			ArrayList<Photograph> photosBetween = new ArrayList<Photograph>();			
			//Checking formatting of dates
			if(endDate.compareTo(beginDate) <= 0) {
				return null;
			}
			if(beginDate.length() != 10 || endDate.length() != 10) {
				return null;
			}
			if(beginDate.charAt(4) != '-' || beginDate.charAt(7) != '-') {
				return null;
			}
			if(endDate.charAt(4) != '-'  || endDate.charAt(7) != '-') {
				return null;
			}
			if(beginDate.substring(8).compareTo("31") > 0 || endDate.substring(8).compareTo("31") > 0) {
				return null;
			}
			if(beginDate.substring(5, 7).compareTo("12") > 0 || endDate.substring(5, 7).compareTo("12") > 0) {
				return null;
			}
			for(Photograph i : photos) {
				String date = i.getDateTaken();
				if(date.compareTo(beginDate) == 0 || date.compareTo(endDate) == 0 ) {
					photosBetween.add(i);
				}
				else if (date.compareTo(beginDate) >= 0 && date.compareTo(endDate) <= 0) {
					photosBetween.add(i);
				}
			}
			return photosBetween;
		}	

}