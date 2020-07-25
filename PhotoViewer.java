import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Homework 4
 * Kaycie O'Boyle, ko2re
 *
 * Sources: TA office hours, lecture notes, Big Java Book
 */


public class PhotoViewer extends JFrame {
	
	//Here are the fields (instance variables)
	private static PhotographContainer imageLibrary;
	private FlowLayout layout = new FlowLayout();
	private JButton exitButton;
	private JButton previousButton;
	private JButton nextButton;
	private JRadioButton sortByDateButton;
	private JRadioButton sortByCaptionButton;
	private JRadioButton sortByRatingButton;
	private JLabel numberedPhotoLabel;
	private JLabel ratingLabel;
	private JRadioButton ratingButton1;
	private JRadioButton ratingButton2;
	private JRadioButton ratingButton3;
	private JRadioButton ratingButton4;
	private JRadioButton ratingButton5;
	private JLabel imageLabel0;
	private JLabel imageLabel1;
	private JLabel imageLabel2;
	private JLabel imageLabel3;
	private JLabel imageLabel4;
	private JLabel imageLabel5;
	private int numPhoto;
	private int index; //which picture should be showing 

	
	//These are the accessor methods (AKA getters)
	public PhotographContainer getImageLibrary() {
		return this.imageLibrary;
	}
	

	//These are the mutator methods (AKA setters)
	public void setImageLibrary(PhotographContainer il) {
		this.imageLibrary = il;
	}
	
	
	
	public void addComponentsToPane(Container pane) {
		// IMAGE PANEL  ---------------------------------------------------------
		
		index = 0;
		imageLabel0 = new JLabel();
		imageLabel1 = new JLabel();
		imageLabel2 = new JLabel();
		imageLabel3 = new JLabel();
		imageLabel4 = new JLabel();
		imageLabel5 = new JLabel();
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1));		
		
		//MAIN PHOTO 
		File mainFile = new File(imageLibrary.getPhotos().get(index).getFilename());	
		
		try {
			BufferedImage defaultPhoto = ImageIO.read(mainFile); 
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(500, 400, Image.SCALE_DEFAULT)); 
			imageLabel0.setIcon(thisIcon);
		}
		catch (Exception e) {
			imageLabel0.setText("Error loading default image or album is empty");
		}
		
		imageLabel0.setLocation(WIDTH/2, HEIGHT/2);
		
		
		//FIRST PHOTO		
		File imageFile1 = new File(imageLibrary.getPhotos().get(index).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile1);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			Photograph photoIndex = imageLibrary.getPhotos().get(index);
			imageLabel1 = new JLabel("<html>" + photoIndex.getCaption() + "<br>" + photoIndex.getDateTaken() + "<br>" + "rated: " + photoIndex.getRating() + "</html>", thisIcon, JLabel.LEFT);
			//got the above line of code from https://stackoverflow.com/questions/685521/multiline-text-in-jlabel
		}
		catch (Exception e) {
			imageLabel1.setText("Error loading default image or album is empty");
		}
		imageLabel1.setLocation(WIDTH/2, HEIGHT/2);
		
		
		//SECOND PHOTO
		File imageFile2 = new File(imageLibrary.getPhotos().get(index+1).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile2);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			Photograph photoIndex = imageLibrary.getPhotos().get(index+1);
			imageLabel2 = new JLabel("<html>" + photoIndex.getCaption() + "<br>" + photoIndex.getDateTaken() + "<br>" + "rated: " + photoIndex.getRating() + "</html>", thisIcon, JLabel.LEFT);
		}
		catch (Exception e) {
			imageLabel2.setText("Error loading default image or album is empty");
		}
		imageLabel2.setLocation(WIDTH/2, HEIGHT/2);
		
		//THIRD PHOTO
		File imageFile3 = new File(imageLibrary.getPhotos().get(index+2).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile3);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			Photograph photoIndex = imageLibrary.getPhotos().get(index+2);
			imageLabel3 = new JLabel("<html>" + photoIndex.getCaption() + "<br>" + photoIndex.getDateTaken() + "<br>" + "rated: " + photoIndex.getRating() + "</html>", thisIcon, JLabel.LEFT);
		}
		catch (Exception e) {
			imageLabel3.setText("Error loading default image or album is empty");
		}
		
		imageLabel3.setLocation(WIDTH/2, HEIGHT/2);
		
		//FOURTH PHOTO
		File imageFile4 = new File(imageLibrary.getPhotos().get(index+3).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile4);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			Photograph photoIndex = imageLibrary.getPhotos().get(index+3);
			imageLabel4 = new JLabel("<html>" + photoIndex.getCaption() + "<br>" + photoIndex.getDateTaken() + "<br>" + "rated: " + photoIndex.getRating() + "</html>", thisIcon, JLabel.LEFT);
		}
		catch (Exception e) {
			imageLabel4.setText("Error loading default image or album is empty");
		}
		
		imageLabel4.setLocation(WIDTH/2, HEIGHT/2);
		
		//FIFTH PHOTO
		File imageFile5 = new File(imageLibrary.getPhotos().get(index+4).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile5);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			Photograph photoIndex = imageLibrary.getPhotos().get(index+4);
			imageLabel5 = new JLabel("<html>" + photoIndex.getCaption() + "<br>" + photoIndex.getDateTaken() + "<br>" + "rated: " + photoIndex.getRating() + "</html>", thisIcon, JLabel.LEFT);
		}
		catch (Exception e) {
			imageLabel5.setText("Error loading default image or album is empty");
		}
		
		imageLabel5.setLocation(WIDTH/2, HEIGHT/2);
		

		this.add(imageLabel0);
		p2.add(imageLabel1);
		p2.add(imageLabel2);
		p2.add(imageLabel3);
		p2.add(imageLabel4);
		p2.add(imageLabel5);
		setVisible(true);
		
		
		// PANEL 1 -------------------------------------------------
		JPanel p1 = new JPanel();
		p1.setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);
		p1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		//info label
		numberedPhotoLabel = new JLabel("Test Library 1 of 5");
		p1.add(numberedPhotoLabel);
		
		//add button
		exitButton = new JButton("Exit");
		exitButton.setActionCommand("click");
		//exitButton.addActionListener(new ButtonListener());
		p1.add(exitButton);
		
		previousButton = new JButton("Previous");
		previousButton.setActionCommand("back");
		p1.add(previousButton);
		
		nextButton = new JButton("Next");
		nextButton.setActionCommand("click");
		p1.add(nextButton);
		
		//button listener for next button
		numPhoto = 0;
		class NextButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("click")) {
					numPhoto += 1;
					if (numPhoto > 5) {
						numPhoto = 1;
						numberedPhotoLabel.setText("Test Library 1 of 5");
					}
					//System.out.print(numPhoto);
					//numberedPhotoLabel.setText("Test Library 1 of 5");
					try {
						File mainFile = new File(imageLibrary.getPhotos().get(numPhoto-1).getFilename());
						BufferedImage defaultPhoto = ImageIO.read(mainFile);
						ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(500, 400, Image.SCALE_DEFAULT));
						imageLabel0.setIcon(thisIcon);
						//imageLabel0.setLocation(WIDTH/2, HEIGHT/2);
						
					}
					catch(NullPointerException z) {
						imageLabel0.setText("it's nullll");
					}
					catch (Exception b) {
						imageLabel0.setText("Error loading default image or album is empty");
					
					}
					numberedPhotoLabel.setText("Test Library " + numPhoto + " of 5");
				}
			}
		}
		
		//button listener for previous button
		class PreviousButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("back")) {
					numPhoto -= 1;
					if(numPhoto < 1 ) {
						numPhoto = 5;
					}
						numberedPhotoLabel.setText("Test Library "+numPhoto+" of 5");
						try {
							File mainFile = new File(imageLibrary.getPhotos().get(numPhoto -1).getFilename());
							BufferedImage defaultPhoto = ImageIO.read(mainFile);
							ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(500, 400, Image.SCALE_DEFAULT));
							imageLabel0.setIcon(thisIcon);					
							
						}
						catch(NullPointerException z) {
							imageLabel0.setText("it's nullll");
						}
						catch (Exception b) {
							imageLabel0.setText("Error loading default image or album is empty");
						}
					}
					
			}
			
		}
		nextButton.addActionListener(new NextButtonListener());
		previousButton.addActionListener(new PreviousButtonListener());
		
		//button listener for sortByCaption radio button
		class CaptionButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				pane.remove(p2);
				ArrayList<Photograph> list = imageLibrary.getPhotos();
		
				Collections.sort(list, new CompareByCaption());
				imageLibrary.setPhotos(list);
				changeImageOrder(0, imageLabel1, list);
				changeImageOrder(1, imageLabel2, list);
				changeImageOrder(2, imageLabel3, list);
				changeImageOrder(3, imageLabel4, list);
				changeImageOrder(4, imageLabel5, list);
				
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(5, 1));
				p2.add(imageLabel1);
				p2.add(imageLabel2);
				p2.add(imageLabel3);
				p2.add(imageLabel4);
				p2.add(imageLabel5);
				pane.add(p2, BorderLayout.WEST);
				setVisible(true);
			}
		}
		
		//button listener for sortByRating radio button
		class RatingButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				pane.remove(p2);
				ArrayList<Photograph> list = imageLibrary.getPhotos();

				Collections.sort(list, new CompareByRating());
				imageLibrary.setPhotos(list);
				changeImageOrder(0, imageLabel1, list);
				changeImageOrder(1, imageLabel2, list);
				changeImageOrder(2, imageLabel3, list);
				changeImageOrder(3, imageLabel4, list);
				changeImageOrder(4, imageLabel5, list);
				
				JPanel p2 = new JPanel();
				p2.setLayout(new GridLayout(5, 1));
				p2.add(imageLabel1);
				p2.add(imageLabel2);
				p2.add(imageLabel3);
				p2.add(imageLabel4);
				p2.add(imageLabel5);
				pane.add(p2, BorderLayout.WEST);
				setVisible(true);
			}
		}
		
		//button listener for sortBydDate button listener
		class DateButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
					pane.remove(p2);
					ArrayList<Photograph> list = imageLibrary.getPhotos();
					
					Collections.sort(list, new CompareByDate());
					imageLibrary.setPhotos(list);
					changeImageOrder(0, imageLabel1, list);
					changeImageOrder(1, imageLabel2, list);
					changeImageOrder(2, imageLabel3, list);
					changeImageOrder(3, imageLabel4, list);
					changeImageOrder(4, imageLabel5, list);
					
					JPanel p2 = new JPanel();
					p2.setLayout(new GridLayout(5, 1));
					p2.add(imageLabel1);
					p2.add(imageLabel2);
					p2.add(imageLabel3);
					p2.add(imageLabel4);
					p2.add(imageLabel5);
					pane.add(p2, BorderLayout.WEST);
					setVisible(true);
				
			}
			
		}
		
		//add radio buttons
		sortByDateButton = new JRadioButton("Sort by Date");
		sortByDateButton.addActionListener(new DateButtonListener());
		p1.add(sortByDateButton);
		
		sortByCaptionButton = new JRadioButton("Sort by Caption");
		sortByCaptionButton.addActionListener(new CaptionButtonListener());
		p1.add(sortByCaptionButton);
		
		sortByRatingButton = new JRadioButton("Sort by Rating");
		sortByRatingButton.addActionListener(new RatingButtonListener());
		p1.add(sortByRatingButton);
		

		
		// PANEL 3 ------------------------------------------------
		JPanel p3 = new JPanel();
		p3.setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);
		p3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//Create inner class for button action listener
		//make sure to change rating of photos when button is clicked
		
		//JLabel
		ratingLabel = new JLabel("Rating");
		p3.add(ratingLabel);
		
		//add radio buttons
		ratingButton1 = new JRadioButton("1");
		ratingButton1.setActionCommand("click");
		p3.add(ratingButton1);
		
		ratingButton2 = new JRadioButton("2");
		ratingButton2.setActionCommand("click");
		p3.add(ratingButton2);
		
		ratingButton3 = new JRadioButton("3");
		ratingButton3.setActionCommand("click");
		p3.add(ratingButton3);
		
		ratingButton4 = new JRadioButton("4");
		ratingButton4.setActionCommand("click");
		p3.add(ratingButton4);
		
		ratingButton5 = new JRadioButton("5");
		ratingButton5.setActionCommand("click");
		p3.add(ratingButton5);
		
		JRadioButton[] buttons = {ratingButton1, ratingButton2, ratingButton3, ratingButton4, ratingButton5};
		JLabel[] labels = {imageLabel1, imageLabel2, imageLabel3, imageLabel4, imageLabel5};
		
		//button listener for all radio buttons...chages the photo rating
		class RadioButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int index = 0;
				if(e.getActionCommand().equals("click")) {
					for(Photograph i : imageLibrary.getPhotos()) {
						for(int j = 0; j < buttons.length; j++) {
							if(buttons[j].isSelected() == true) {
								index += 1;
								int rating = i.getRating();
								int buttonNumber = j;
								rating = buttonNumber;
								i.setRating(rating + 1);
				
							}
						}
					}
				
				}
			}
		}
		
		ratingButton1.addActionListener(new RadioButtonListener());
		ratingButton2.addActionListener(new RadioButtonListener());
		ratingButton3.addActionListener(new RadioButtonListener());
		ratingButton4.addActionListener(new RadioButtonListener());
		ratingButton5.addActionListener(new RadioButtonListener());
		
		//got mouse listener info from https://docs.oracle.com/javase/tutorial/uiswing/events/mouselistener.html
		
		//mouse listeners for the photo thumbnails
	    imageLabel1.addMouseListener(new MouseAdapter()
	    		{
			    	public void mousePressed(MouseEvent me)
			    	{
			    		numPhoto = 1;
			    		changeImage(numPhoto-1, imageLabel0, imageLibrary.getPhotos(), buttons);
			    	}
	    		});
	    imageLabel2.addMouseListener(new MouseAdapter()
		{
	    	public void mousePressed(MouseEvent me)
	    	{
	    		numPhoto = 2;
	    		changeImage(numPhoto-1, imageLabel0, imageLibrary.getPhotos(),buttons);
	    	}
		});
	    imageLabel3.addMouseListener(new MouseAdapter()
		{
	    	public void mousePressed(MouseEvent me)
	    	{
	    		numPhoto = 3;
	    		changeImage(numPhoto-1, imageLabel0, imageLibrary.getPhotos(), buttons);
	    	}
		});
	    imageLabel4.addMouseListener(new MouseAdapter()
		{
	    	public void mousePressed(MouseEvent me)
	    	{
	    		numPhoto = 4;
	    		changeImage(numPhoto-1, imageLabel0, imageLibrary.getPhotos(), buttons);
	    	}
		});
	    imageLabel5.addMouseListener(new MouseAdapter()
		{
	    	public void mousePressed(MouseEvent me)
	    	{
	    		numPhoto = 5;
	    		changeImage(numPhoto-1, imageLabel0, imageLibrary.getPhotos(), buttons);
	    	}
		});
		// ADDING ALL THE PANELS ---------------------------------------------
		pane.add(p1, BorderLayout.NORTH);
		pane.add(p2, BorderLayout.WEST);
		pane.add(p3, BorderLayout.SOUTH);
		pane.setBackground(Color.pink);
		
		
	}
	
	//got setSelected method for buttons from https://docs.oracle.com/javase/8/docs/api/javax/swing/ButtonGroup.html
	/**
	 * method that highlights which radio button corresponds the current image's rating
	 * @param index
	 * @param buttons
	 */
	public void setButtonSelected(int index, JRadioButton[] buttons)
	{
		
		for(int i=0;i<buttons.length; i++)
		{
			if(i!=index-1)
			{
				buttons[i].setSelected(false);	
			}
			else
			{
				buttons[i].setSelected(true);
			}
		}
	}
	
	//rating stuff here
	/**
	 * Method that changes the main image when its corresponding thumbnail is chosen
	 * @param index
	 * @param jlabel
	 * @param list
	 * @param buttons
	 */
	public void changeImage(int index, JLabel jlabel, ArrayList<Photograph> list, JRadioButton[] buttons)
	{
		File imageFile5 = new File(list.get(index).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile5);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(500, 400, Image.SCALE_DEFAULT));
			jlabel.setIcon(thisIcon);
		}
		catch (Exception ex) {
			System.out.print("Error loading default image or album is empty");
		}
		setButtonSelected(list.get(index).getRating(), buttons );
		numberedPhotoLabel.setText("Photo Library "+numPhoto+" of 5");
	}
	
	/**
	 * Method that generalizes the changing of a thumbnail so I don't have to keep repeating code
	 * @param index
	 * @param jlabel
	 * @param list
	 */
	public void changeImageOrder(int index, JLabel jlabel, ArrayList<Photograph> list)
	{
		File imageFile5 = new File(list.get(index).getFilename());	
		try {
			BufferedImage defaultPhoto = ImageIO.read(imageFile5);
			ImageIcon thisIcon = new ImageIcon(defaultPhoto.getScaledInstance(150, 100, Image.SCALE_DEFAULT)); 
			jlabel.setIcon(thisIcon);
			jlabel.setText("<html>" + list.get(index).getCaption() + "<br>" + list.get(index).getDateTaken() + "<br>" + "rated: " + list.get(index).getRating() + "</html>");
		}
		catch (Exception ex) {
			System.out.print("Error loading default image or album is empty");
		}
	}

	//Create and set up the window
	private static void createAndShowGUI() {
		PhotoViewer frame = new PhotoViewer();
		frame.setImageLibrary(imageLibrary);
		frame.setTitle("Homework #4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.addComponentsToPane(frame.getContentPane());	
	
		
		frame.pack();
		frame.setVisible(true);
	}
	

	//main method
	public static void main(String[] args) {
		PhotoViewer myViewer = new PhotoViewer();
	
		
		Photograph p1 = new Photograph("Cute kitty", "images/cat.jpg", "2016-07-10", 5);
		p1.loadImageData("images/cat.jpg");
		
		Photograph p2 = new Photograph("A Flower", "images/Flower2.jpg", "2017-04-10", 4);
		p2.loadImageData("images/Flower2.jpg");
		
		Photograph p3 = new Photograph("I want to go to the beach", "images/beach.jpg", "2018-03-09", 3);
		p3.loadImageData("images/beach.jpg");
		
		Photograph p4 = new Photograph("Niagara Falls", "images/NiagaraFalls.jpg", "2018-06-09", 2);
		p4.loadImageData("images/NiagaraFalls.jpg");
		
		Photograph p5 = new Photograph("I miss my dog", "images/puppy.jpg", "2019-07-25", 1);
		p5.loadImageData("images/puppy.jpg");
		
		myViewer.setImageLibrary(new PhotoLibrary("Photo Library", 1));
		myViewer.getImageLibrary().addPhoto(p1);
		myViewer.getImageLibrary().addPhoto(p2);
		myViewer.getImageLibrary().addPhoto(p3);
		myViewer.getImageLibrary().addPhoto(p4);
		myViewer.getImageLibrary().addPhoto(p5);
		
		
		Collections.sort(myViewer.getImageLibrary().getPhotos());
		
		
		javax.swing.SwingUtilities.invokeLater(() -> myViewer.createAndShowGUI());
		
	}
	
	
}
