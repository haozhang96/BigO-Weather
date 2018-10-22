package com.example.bigo.weatherapp.models.util;
/**
 *This Class allows you to read the DarkSky and Geocodio keys
 *
 * updated 10/3/18
 * @authors John Isaac Wilkinson
 **/
import java.io.*;
import java.net.URL;

public class ReadTxt {

    private URL path;
    private File f;
    private BufferedReader reader;

    public ReadTxt() {

    }

    public String getDarkSkyKey() throws IOException {
        URL path = ReadTxt.class.getResource("util.txt");
        File f = new File(path.getFile());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        return reader.readLine();
    }
    public String getGeocodioKey() throws IOException {
        URL path = ReadTxt.class.getResource("util.txt");
        File f = new File(path.getFile());
        BufferedReader reader = new BufferedReader(new FileReader(f));
        reader.readLine();
        return reader.readLine();
    }
}
