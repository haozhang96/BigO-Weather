/*
 * This class saves the user's favorite locations on the device for easier access.
 * 
 * @updated 2018/10/03
 *
 * @author Harman Bains
 */
package WeatherModels;

/*
 * This import allows the app to write data to a file on the device.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.naming.Context;

/**
 *
 * @author harmanbains
 */
public class SaveData /* extends LocationCoordinates */ {

    /*
    This creates the file on the system and saves the locations.
    In takes in the latitude and longitude and writes them to a file.
     */
    public void writeToFile(/* _latitude, _longitude */) {
        File SavedLocations = new File("SavedLocations.txt");
        try {
            PrintWriter writerForFile = new PrintWriter("SavedLocations.txt");
            writerForFile.println(/* _latitude */);
            writerForFile.println(/* _longitude */);
            writerForFile.println("Location saved.");
            writerForFile.close();
        } catch (Exception e) {
            System.out.println("Unable to save. Try again.");
        }
    }

    /*
    public void writeAppData(String _coordinates, Context _context){
        try{
    OutputStreamWriter outputWriter = new OuputStreamWriter(context.openFileOuput("SavedLocations.txt"));
    ouputWriter.write(_coordinates);
    outputWriter.close();
    } catch (IOException e){
        System.out.println("Could not save. Try again.");
     */
    
    
    /*
    This method access the saved files and reloads the saved locations.
    */
    //public double retrieveCoordinates (){    
    //}
}
