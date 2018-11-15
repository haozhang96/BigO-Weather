package edu.uncg.csc.bigo.weather.data;

/**
 * This class handles the CRUD operations for the text file. It implements the methods located in
 * DataInterface.
 *
 * @author Harman Bains
 * @updated 10/05/2018
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import edu.uncg.csc.bigo.weather.models.weather.WeatherObject;
import edu.uncg.csc.bigo.weather.views.activities.MainActivity;

import static edu.uncg.csc.bigo.weather.data.CreateFile.newFile;
import static edu.uncg.csc.bigo.weather.data.CreateFile.txtDir;

public class DataStore implements DataInterface {

    // An arrayList to hold the zip codes and coordinates for simple searching.
    ArrayList<String> locationArray = new ArrayList<String>();

    /**
     * Inserts a location into the text file after checking if the location already exists by calling
     * checkFile. If it does not exist, then insert it.
     * exists, then it does not insert.
     *
     * @param _zipCode
     * @param _latitude
     * @param _longitude
     * @return
     */
    @Override
    public void insert(int _zipCode, String _latitude, String _longitude) {

        FileWriter locationWriter;

        // Check if the zip code already exists in the file.
        if (!checkFile(_zipCode)) {

            try {
                // Create a file writer for the text file and allowing for appending.
                locationWriter = new FileWriter(newFile, true);
                locationWriter.append(String.valueOf(_zipCode) + " " + _latitude + " " + _longitude + "\n");

                // Flush will clear the file writer to avoid unintended writing to text file.
                locationWriter.flush();

            } catch (IOException e) {
                Log.e("Exception", " insert error in DataStore " + e.toString());
            }
        } else {
            Log.e("Error ", +_zipCode + " is already saved.");
        }
    }

    /**
     * Checks the text file for a location by searching for the given zip code and returns true
     * if found.
     *
     * @param _zipCode
     */
    @Override
    public boolean checkFile(int _zipCode) {

        // Pass in the directory and file name to be read.
        File loadFile = new File(CreateFile.txtDir, "text.txt");

        try (Scanner scanner = new Scanner(loadFile)) {

            while (scanner.hasNext()) {

                // Add each location that is saved in the file to the arrayList.
                locationArray.add(scanner.next());

            }
        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        }

//        Log.e("ArrayList ", " is : "  + locationArray.toString());

        // Return the boolean if the arrayList contains the passed in zip code.
        return locationArray.contains(String.valueOf(_zipCode));
    }

    /**
     * Searches the text file for a zip code and return the coordinates, if found, as a
     * LocationCoordinate object.
     *
     * @param _zipCode
     */
    @Override
    public LocationCoordinate returnCoordinates(int _zipCode) {

        // Coordinates to return
        LocationCoordinate foundCoordinates;

        String latitude;
        String longitude;

        // First, check if the zip code is saved in the file.
        if (checkFile(_zipCode)) {
            // Get the index of the zip code stored in the arrayList.
            int indexOfZipCode = locationArray.indexOf(String.valueOf(_zipCode));

            // The file structure is zip code, latitude, and longitude.
            latitude = locationArray.get(indexOfZipCode + 1);
            longitude = locationArray.get(indexOfZipCode + 2);
        } else {
            // If the zip code was not found.
            return null;
        }
        // Return the found latitude and longitude as a LocationCoordinate.
        return foundCoordinates = new LocationCoordinate(Double.parseDouble(latitude),
                Double.parseDouble(longitude));
    }


    /**
     * Sorts the file that holds the saved locations and creates a new sorted file.
     */
    @Override
    public void sortFile() {

        ArrayList<String> sortedArray = new ArrayList<String>();

        try {

            // Load the file with saved locations.
            File loadFile = new File(CreateFile.txtDir, "test.txt");
            Scanner fileScanner = new Scanner(loadFile);

            // ArrayList that holds objects of WeatherObject (zipcode and LocationCoordinate).
            ArrayList<WeatherObject> tempArray = new ArrayList<WeatherObject>();

            while (fileScanner.hasNext()) {
                String zip = String.valueOf(fileScanner.nextInt());
                Double lat = fileScanner.nextDouble();
                Double longit = fileScanner.nextDouble();

                // Create an object and add it to the ArrayList.
                WeatherObject tempObj = new WeatherObject(zip, new LocationCoordinate(lat, longit));

                tempArray.add(tempObj);
            }

            // Calls the sort method within java.util.Collections with a Comparator
            Collections.sort(tempArray, new Comparator<WeatherObject>() {
                        @Override
                        public int compare(WeatherObject one, WeatherObject two) {
                            return one.getZipCode().compareTo(two.getZipCode());
                        }
                    }
            );

            // Create a sorted file.
            File sortedFile = new File(txtDir, "SortedFile.txt");
            FileWriter sortedFileWriter = new FileWriter(sortedFile, true);

            for (WeatherObject individualObject : tempArray) {
                sortedFileWriter.write(String.valueOf(individualObject.getZipCode()) + " ");
                sortedFileWriter.write(String.valueOf(individualObject.getCoordinates()) + "\n");

            }
            sortedFileWriter.flush();

        } catch (IOException e) {
            //   Log.e("sortFile ",  e.printStackTrace());
            e.printStackTrace();
        }

    }

    /**
     * Removes a saved location from the text file.
     *
     * @param _zipCode
     */
    @Override
    public void remove(String _zipCode) {

        int removeZipCode = Integer.parseInt(_zipCode);

        ArrayList<String> removeArray = new ArrayList<String>();

        File loadFile = new File(CreateFile.txtDir, "test.txt");

        try (Scanner scanner = new Scanner(loadFile)) {

            // First, check if the zip code is saved in the file.
            if (checkFile(removeZipCode)) {
                while (scanner.hasNext()) {

                    // Add each location that is saved in the file to the arrayList.
                    removeArray.add(scanner.next());
                }
                // Get the index of the zip code stored in the arrayList.
                removeZipCode = removeArray.indexOf(String.valueOf(_zipCode));
                removeArray.remove(removeZipCode);
                removeArray.remove(removeZipCode + 1);
                removeArray.remove(removeZipCode + 2);

                Log.e("zip"," is " + removeZipCode);
                Log.e("lat"," is " + (removeZipCode + 1));
                Log.e("long"," is " + (removeZipCode + 2));


                // Delete the current file with the saved locations.
     //           loadFile.delete();

                // Create a new file with the saved locations except the deleted location.
                File updatedFile = new File(txtDir, "xyz.txt");
                try {
                    FileWriter removeFileWriter = new FileWriter(updatedFile, true);

                    Log.e("inside"," try catch");

                    for(String line : removeArray){
                        Log.e("FOR ", " loop inside write" + line);
                        removeFileWriter.append(line);
                    }

                    removeFileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }


        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        }


    }

}
