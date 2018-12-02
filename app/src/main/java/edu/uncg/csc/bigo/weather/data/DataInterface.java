package edu.uncg.csc.bigo.weather.data;

import android.content.Context;

/**
 * This interface will describe all the methods which must be implemented for the text file database.
 * @author Harman Bains
 * @updated 10/29/2018
 */

public interface DataInterface {

    // Create a new file which holds the locations after sorting them.
    public abstract void sortFile();

    // Returns an array of all saved locations to be used for a drop down menu in the view.
    public abstract String[] returnLocation();

    // Insert the location into the text file.
    public abstract void insert(int _zipCode, Context _context);

    // Check if the zip code is saved in the text file.
    public abstract boolean checkFile(int _zipCode, Context _context);

    //Currently not in use.
    public abstract void remove();

}
