# Photo-Album-Viewer

### Overview 
This project was created for a homework assignment for my CS 2110 Software Development Methods course. This project implements object-oriented programming principles to implement a GUI 
to the PhotoLibrary file.

### Project Status 
The files listed are the ones that were submmitted for grading and no more work has been done since.    

### Tech/Framework Used 
* Eclipse 
* Java
* Graphical User Interfaces using Swing 
* JUnit 

### Screenshot of GUI 


### How to Use

### Features
* Photograph class that outlines what it means to be a photograph: must have catption, a filename, date taken in fromat YYYY-MM-DD, and a rating from 0-5  
  * This class implements the comparable interface in order to compare photographs by date taken, rating, and caption
* PhotoLibrary class that outlines what it means to be a photolibrary: must have a name, id, list of photographs, and a hashset of albums 
  * This class extends the PhotographContainer class so it will inherit its methods 
* Album class that contains a list of photographs and must have a name and a hashset of photographs 
  * This class extends the PhotographContainer class so it will inherit its methods
* Abstract class, PhotographContainer, that holds photographs
  * includes methods such as adding photos, erasing photos, returning the number of photos in the photo library, determining if a photo is already within the photo library
  * Can return an arraylist of photos based on rating, year taken, month taken, and between certain dates.
* Unit Tests using JUnit framework 

### Authors 
This project was created by myself.
