import java.util.ArrayList;
import java.util.HashSet;


/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */

public class PhotoLibrary extends PhotographContainer{
	
	/**
	 * Here are the fields (instance variables)
	 */
	private int id;
	private ArrayList<Album> albums;
	
	/**
	 * Here is the constructor that initializes the fields
	 */
	public PhotoLibrary(String name, int id) {
		super (name);
		this.id = id;
		albums = new ArrayList<Album>();
	}
	
	/**
	 * These are the accessor methods (AKA getters)
	 * @return the value of the id field and references to the album field
	 */
	public int getId() {
		return id;
	}
	
	public ArrayList<Album> getAlbums(){
		return albums;
	}
	
	/**
	 * Here is the overridden erasePhoto() method to removePhoto() method that removes p 
	 * from the current object's list if Photograph p is in the current PhotoLibrary object's 
	 * list of photos and also from any Albums in list of albums
	 * @return true if Photograph was removed
	 * @return false if it was not there
	 */
	public boolean removePhoto(Photograph p) {
		for(Photograph i: photos) {
			if(i.equals(p)) {
				photos.remove(p);
			}
			for(Album z : albums) {
				if(z.hasPhoto(p)) {
					z.removePhoto(p);
				}
			}
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Here is the equals() method that checks if Object o's id is equal to the 
	 * current PhotoLibrary object's id 
	 * @return true if they are equal
	 * @return false if otherwise
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o instanceof PhotoLibrary) {
			PhotoLibrary p = (PhotoLibrary) o;
			if (this.id == (p.id)) {
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
	 * Here is the toString() method that generates a string to show the values of 
	 * the fields name, id, and photos
	 */
	public String toString() {
		return "Name: " + name + ", " + "Id: " + id + ", " + "Photos: " + photos + "Album names: " + albums;
	}
	
	/**
	 * Here is the commonPhotos() method that determines which photos are in both
	 * the parameters PhotoLibrary a and PhotoLibrary b
	 * @return an arrayList of all the photos that both PhotoLibrary's share
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
		ArrayList<Photograph> samePhotos = new ArrayList<Photograph>();
		for(Photograph i: a.photos) {
			if(b.hasPhoto(i)) {
				samePhotos.add(i);
			}
		}
		return samePhotos;
	}
	
	/**
	 * Here is the similarity() method that measures how similar that photo feeds are 
	 * between the two PhotoLibrarys in terms of a numerical value 0 to 1.
	 * @return 0.0 if they have no similarities 
	 * @return number of commonPhotos divided by smaller of the number photos in a's feed 
	 * and the number of photos in b's feed
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		double samePhotosize = commonPhotos(a, b).size();
		if((a.numPhotographs() == 0) || (b.numPhotographs() == 0)) {
			return 0.0;
		}
		else if(a.numPhotographs() < b.numPhotographs()) {
			return samePhotosize / a.numPhotographs();
		}
		else {
			return samePhotosize / b.numPhotographs();
		}
	}
	
	/**
	 * Creates a new Album with name albumName and adds it to the list of albums, if
	 * Albums with that name does not already exist
	 * @param albumName
	 * @return true if it was added, false if it was not because there was already an 
	 * album with that name
	 */
	public boolean createAlbum(String albumName) {
		Album a = new Album(albumName);
		if(albums.contains(a)){
			return false;
		}
		else {
			albums.add(a);
			return true;
		}
	}
	
	/**
	 * removes the Album with name albumName if an Album with that name
	 * exists in the set of albums
	 * @param albumName
	 * @return true if remove was successful, false if it wasn't
	 */
	public boolean removeAlbum(String albumName) {
		for(Album i : albums) {
			if(i.getName().equals(albumName)) {
				albums.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Add Photograph p in the set of albums with name albumName if it is in the
	 * PhotoLibrary's list of photos and it was not already in the album
	 * @param p
	 * @param albumName
	 * @return true if it was added, false if it was not 
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		for(Album i : albums) {
			if(photos.contains(p) && (i.getName().equals(albumName))) {
				i.addPhoto(p);
				return true;
			}
		}
		return false;
	}

	
	/**
	 * remove the Photo p from album in the set of albums that has the name albumName
	 * @param p
	 * @param albumName
	 * @return true if photo was removed
	 * @return false if it was not
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		for(Album i : albums) {
			if(i.hasPhoto(p)) {
				if(i.getName().equals(albumName)) {
					i.removePhoto(p);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Given an album name, this method returns the Album with that name from the set
	 * of albums
	 * @param albumName
	 * @return the album if it is in set of albums
	 * @return null if it is not in set
	 */
	private Album getAlbumByName(String albumName) {
		for(Album a : albums) {
			if (a.getName().equals(albumName)) {
				return a;
			}	
		}
		return null;
	}
}