package edu.uncg.csc.bigo.weather.data;

/**
 * This class creates the directory and file where locations will be saved. Zip code, latitude and
 * longitude will be saved to the file.
 *
 * @author Harman Bains
 * @updated 10/29/2018
 */

import android.content.Context;
import android.util.Log;

import java.io.File;

public class CreateFile {

    // The name of the file and directory created. Will be stored in another file along with API keys.

    final static String fileName = "zip.txt";
    final static String sortedFileName = "zipSorted.txt";
    final static String directoryName = "ZipDirectory";
    public static String sortedFilePath = "/data/user/0/edu.uncg.csc.bigo.weather/files/ZipDirectory/zipSorted.txt";
    public static String originalFilePath = "/data/user/0/edu.uncg.csc.bigo.weather/files/ZipDirectory/zip.txt";
    public static File txtDir;
    static File newFile;

    /**
     * @param _context is passed in for the app to create the file and directory.
     * of the app at that moment.
     * @return void. Creates the file and directory.
     * @throws Exception in case the file or directory were not created.
     */
    public static void createFile(Context _context) {
        try {
            // Update the path to the files if needed.
            originalFilePath = _context.getFilesDir().getPath() + "/" + directoryName + "/" + fileName;
            sortedFilePath = _context.getFilesDir().getPath() + "/" + directoryName + "/" + sortedFileName;

            // Create the directory for the locations file.
            txtDir = new File(_context.getFilesDir(), directoryName);
            if (!txtDir.exists()) {
                txtDir.mkdir();
            }

            // Create the file in the directory made above.
            try {
                newFile = new File(txtDir, fileName);

            } catch (Exception e) {
                Log.e("Exception", " could not create file in directory " + e.toString());
            }

        } catch (Exception e) {
            Log.e("Exception", " could not create directory " + e.toString());
        }
    }
}

