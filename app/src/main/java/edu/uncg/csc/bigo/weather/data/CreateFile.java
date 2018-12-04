package edu.uncg.csc.bigo.weather.data;
/**
 * This class creates the directory and file where locations will be saved. Zip code will be taken
 * as input and saved to the files.
 *
 * @author Harman Bains
 * @updated 12/3/2018
 */

import android.content.Context;
import java.io.File;

public class CreateFile {
    // Declare the paths of the files. Some paths can cause conflict due to threading issues on Android.
    final static String fileName = "zip.txt";
    final static String sortedFileName = "zipSorted.txt";
    final static String directoryName = "ZipDirectory";
    public static String sortedFilePath = "/data/user/0/edu.uncg.csc.bigo.weather/files/ZipDirectory/zipSorted.txt";
    public static String originalFilePath = "/data/user/0/edu.uncg.csc.bigo.weather/files/ZipDirectory/zip.txt";
    public static File txtDir;
    static File newFile;

    /**
     * This method creates the directory and file on the device if they do not exist.
     *
     * @param _context is passed in for the app to create the file and directory of the app at that moment.
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
                e.toString();
            }
        } catch (Exception e) {
            e.toString();
        }
    }
}