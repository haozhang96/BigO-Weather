package edu.uncg.csc.bigo.weather.data;
/**
 * This interface will describe all the methods which must be implemented for the text file database.
 * @author Harman Bains
 * @updated 10/29/2018
 */

import android.content.Context;

public interface DataInterface {
    /**
     * Check if the zip code is saved in the text file.
     *
     * @param _zipCode Entered by the user.
     * @param _context Context of the application.
     * @return Boolean if the zip code exists in the file.
     */
    public abstract boolean checkFile(int _zipCode, Context _context);


    /**
     * Insert the location into the text file after checking if it is valid and not a duplicate.
     *
     * @param _zipCode Entered by the user.
     * @param _context Context of the application.
     */
    public abstract void insert(int _zipCode, Context _context);


    /**
     * Remove all of the saved locations from the files.
     */
    public abstract void remove();


    /**
     * Remove an invalid zip code from the text file automatically.
     *
     * @param _zipCode
     * @param _context
     */
    public abstract void removeInvalidZipCode(int _zipCode, Context _context);


    /**
     * Returns an array of all saved locations to be used for a drop down menu in the view.
     *
     * @return Array of the saved locations in the file.
     */
    public abstract String[] returnLocation();


    /**
     * Create a new file which holds the locations after sorting them.
     */
    public abstract void sortFile();
}