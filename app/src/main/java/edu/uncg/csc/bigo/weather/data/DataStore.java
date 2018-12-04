package edu.uncg.csc.bigo.weather.data;

/**
 * This class handles the CRUD operations for the text file. It implements the methods located in
 * DataInterface.
 *
 * @author Harman Bains
 * @updated 10/05/2018
 */

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import static edu.uncg.csc.bigo.weather.data.CreateFile.newFile;
import static edu.uncg.csc.bigo.weather.data.CreateFile.txtDir;

// import edu.uncg.csc.bigo.weather.models.weather.WeatherObject;

public class DataStore implements DataInterface {

    // An arrayList to hold the zip codes and coordinates for simple searching.
    ArrayList<String> locationArray = new ArrayList<String>();

    /**
     * Inserts a location into the text file after checking if the location already exists by calling
     * checkFile. If it does not exist, then insert it.
     * exists, then it does not insert.
     *
     * @param _zipCode
     * @param
     * @param
     * @return
     */
    @Override
    public void insert(int _zipCode, Context _context) {

        FileWriter locationWriter;

        // Check if the zip code already exists in the file.
        if (!checkFile(_zipCode, _context)) {

            try {
                // Create a file writer for the text file and allowing for appending.
                locationWriter = new FileWriter(newFile, true);

                locationWriter.append(_zipCode + "\n");

                // Flush will clear the file writer to avoid unintended writing to text file.
                locationWriter.flush();

                // Sort the file after each insertion.
                sortFile();

            } catch (IOException e) {
                Log.e("Exception", " insert error in DataStore " + e.toString());
            }
        } else {
            Log.e("Error ", +_zipCode + " is already saved.");
        }
    }

    // Holds the locations.
    ArrayList<String> zipArray = new ArrayList<String>();

    /**
     * Checks the text file for a location by searching for the given zip code and returns true
     * if found.
     *
     * @param _zipCode
     */
    @Override
    public boolean checkFile(int _zipCode, Context _context) {

        // Pass in the directory and file name to be read.
        File loadFile = new File(CreateFile.txtDir, "zip.txt");

        try (Scanner scanner = new Scanner(loadFile)) {

            // Clear the arrayList.
            zipArray.clear();

            while (scanner.hasNext()) {

                // Add each location that is saved in the file to the arrayList.
                zipArray.add(scanner.next());
            }

        } catch (FileNotFoundException | InputMismatchException e) {
            e.printStackTrace();
        }

        // Return the boolean if the arrayList contains the passed in zip code.
        return zipArray.contains(String.valueOf(_zipCode));
    }

    /**
     * Sorts the file that holds the saved locations and creates a new sorted file.
     */
    @Override
    public void sortFile() {

        // Holds the sorted array.
        ArrayList<String> sortedArray = new ArrayList<String>();

        try {

            // Load the file with saved locations.
            File loadFile = new File(CreateFile.txtDir, "zip.txt");
            Scanner fileScanner = new Scanner(loadFile);

            // Clear the array.
            sortedArray.clear();

            while (fileScanner.hasNextInt()) {

                int zip = fileScanner.nextInt();

                // Add each zip code to the array.
                sortedArray.add(String.valueOf(zip) + "\n");
            }

            // Use Java Collections to sort the array.
            Collections.sort(sortedArray);

            // Create a sorted file.
            File sortedFile = new File(txtDir, "zipSorted.txt");

            // Set append to false so it will overwrite the file and avoid duplicating zip codes.
            FileWriter sortedFileWriter = new FileWriter(sortedFile, false);

            for (int i = 0; i < sortedArray.size(); i++) {
                sortedFileWriter.write(sortedArray.get(i));
            }
            sortedFileWriter.flush();

        } catch (IOException e) {
            Log.e("sortFile ", " " + e.toString());
        }

    }

    @Override
    public  String[] returnLocation() {
        // This generates the drop down list from the text file for the view.

        // Create ArrayList and Array that will hold the saved locations.
        ArrayList<String> zipList = new ArrayList<String>();
        String[] zipArray = null;


        try {
            // Pass in the directory and file name to be read.
            File loadFile = new File(CreateFile.sortedFilePath);



            // Create ArrayList and Array that will hold the saved locations.
            zipList = new ArrayList<String>();
            zipArray = null;

            try (Scanner scanner = new Scanner(loadFile)) {

                // Clear the arrayList.
                zipList.clear();

                while (scanner.hasNext()) {
                    // Add each location that is saved in the file to the arrayList.
                    zipList.add(scanner.next());
                }

                // Transfer the locations from the ArrayList to an Array so they can be used in the
                // AutoCompleteTextView.
                zipArray = (String[]) zipList.toArray(new String[zipList.size()]);


            } catch (FileNotFoundException | InputMismatchException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.toString();
        }
        return zipArray;
    }

    /**
     * WILL BE UPDATED
     * <p>
     * Removes a saved location from the text file.
     *
     * @param
     */
    @Override
    public void remove() {

        try {

            // Pass in the directory and file name to be read.
            File loadFile = new File(CreateFile.sortedFilePath);
            PrintWriter writer = new PrintWriter(loadFile);
            writer.print("");
            writer.close();

            // Pass in the directory and file name to be read.
            loadFile = new File(CreateFile.originalFilePath);
            writer = new PrintWriter(loadFile);
            writer.print("");


        } catch (Exception e) {
            e.toString();
        }
    }

    /**
     * Removal an invalid zip code from the text file.
     *
     * @param _zipCode
     */
    public void removeInvalidZipCode(int _zipCode, Context _context) {

        try {

            // Load the file for reading.
            File loadFile = new File(CreateFile.sortedFilePath);

            // ArrayList to hold the locations.
            ArrayList<String> zipList = new ArrayList<String>();

            Scanner scanner = new Scanner(loadFile);

            while (scanner.hasNextInt()) {

                int zip = scanner.nextInt();

                // Add each location that is saved in the file to the arrayList.
                zipList.add(String.valueOf(zip));
            }

            // Get the index of the invalid zip code.
            int removeIndex = zipList.indexOf(String.valueOf(_zipCode));

            // Wipe the files so they can be rewritten without the invalid zip code.
            remove();

            // Remove the invalid zip code from the ArrayList.
            zipList.remove(removeIndex);

            // Write the ArrayList back to the files.
            for (int i = 0; i < zipList.size(); i++) {
                int zipCode = Integer.valueOf(zipList.get(i));
                insert(zipCode, _context);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
