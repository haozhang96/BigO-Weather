package edu.uncg.csc.bigo.weather.controllers;

import android.content.Context;
import edu.uncg.csc.bigo.weather.data.DataInterface;
import edu.uncg.csc.bigo.weather.data.DataStore;

public final class DataController {

    DataInterface interfaceController = new DataStore();

    // Create a new file which holds the locations after sorting them.
    public void sortFile() {
        interfaceController.sortFile();
    }

    // Returns an array of all saved locations to be used for a drop down menu in the view.
    public String[] returnLocation() {
        return interfaceController.returnLocation();
    }

    // Insert the location into the text file.
    public void insert(int _zipCode, Context _context) {
        interfaceController.insert(_zipCode, _context);
    }

    // Check if the zip code is saved in the text file.
    public boolean checkFileController (int _zipCode, Context _context){
        return interfaceController.checkFile(_zipCode, _context);
    }

    // Clear all the saved locations.
    public void removeController() {
        interfaceController.remove();
    }

    // Clear an invalid zip code from the file.
    public void removeInvalidZipCodeController (int _zipCode, Context _context){
        interfaceController.removeInvalidZipCode(_zipCode, _context);
    }

}
