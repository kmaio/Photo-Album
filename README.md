# Photo-Album-Viewer

### Overview 
This project was created for a homework assignment for my CS 2110 Software Development Methods course. This assingment built off previous homework assignments where we practiced object-oriented programming principles, JUnit testing, hashCodes, inheritance with an abstract classes, and comparable interfaces. For this project we implemented a GUI to the PhotoLibrary file by creating the PhotoViewer class. The GUI displays a set of five photos that you can scroll through, rate each picture from 1-5, and sort by caption, date or rating.  

### Project Status 
The files listed are the ones that were submmitted for grading and no more work has been done since.    

### Tech/Framework Used 
* Eclipse 
* Java
* Graphical User Interfaces using Swing 
* JUnit 

### Screenshot of GUI 
![Alt Text](https://user-images.githubusercontent.com/60328293/88489717-fe193c00-cf63-11ea-8d05-18fb2295f956.png)

### How to Use
Launch the GUI interface from the PhotoViewer class. 

### Features
* The Photograph class outlines what it means to be a photograph: must have catption, a filename, date taken in fromat YYYY-MM-DD, and a rating from 0-5  
  * This class implements the comparable interface in order to compare photographs by date taken, rating, and caption
* The PhotoLibrary class outlines what it means to be a photolibrary: must have a name, id, list of photographs, and a hashset of albums 
  * This class extends the PhotographContainer class so it will inherit its methods 
* The Album class contains a list of photographs and must have a name and a hashset of photographs 
  * This class extends the PhotographContainer class so it will inherit its methods
* The Abstract class, PhotographContainer, holds photographs
  * It includes methods such as adding photos, erasing photos, returning the number of photos in the photo library, determining if a photo is already within the photo library
  * Can return an arraylist of photos based on rating, year taken, month taken, and between certain dates.
* Unit Tests using JUnit framework 
* An easy to navigate GUI 

### Authors 
This project was created by myself.

