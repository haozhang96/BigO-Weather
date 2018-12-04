package edu.uncg.csc.bigo.weather.controllers;
/**
 * This controller connects the data (text files) and the views. The CRUD operations are available
 * through this controller.
 *
 * @author Harman Bains
 * @LastUpdated: 12/3/2018
 */

import android.content.Context;
import edu.uncg.csc.bigo.weather.data.DataInterface;
import edu.uncg.csc.bigo.weather.data.DataStore;

public final class DataController {
    DataInterface interfaceController = new DataStore();

    /**
     * Check if the zip code is saved in the text file.
     * @param _zipCode Entered by the user.
     * @param _context Context of the application.
     * @return Boolean if zip code is saved in file.
     */
    public boolean checkFileController(int _zipCode, Context _context) {
        return interfaceController.checkFile(_zipCode, _context);
    }


    /**
     * Insert the location into the text file after checking if it exists and is valid.
     *
     * @param _zipCode Entered by the user.
     * @param _context Context of the application.
     */
    public void insert(int _zipCode, Context _context) {
        interfaceController.insert(_zipCode, _context);
    }


    /**
     * Clear all the saved locations from the text files.
     */
    public void removeController() {
        interfaceController.remove();
    }


    /**
     * Clear an invalid zip code from the file automatically.
     *
     * @param _zipCode Entered by the user.
     * @param _context Context of the application.
     */
    public void removeInvalidZipCodeController(int _zipCode, Context _context) {
        interfaceController.removeInvalidZipCode(_zipCode, _context);
    }


    /**
     * Returns an array of all saved locations to be used for a drop down menu in the view.
     *
     * @return Array of all saved locations.
     */
    public String[] returnLocation() {
        return interfaceController.returnLocation();
    }


    /**
     * Create a new file which holds the locations after sorting them.
     */
    public void sortFile() {
        interfaceController.sortFile();
    }
}