package edu.uncg.csc.bigo.weather.models.util;

/*
 * This entity class describes the coordinates we will be storing in the database. It will consist
 * of zip code, latitude, longitude and active / inactive.
 * @updated
 * @authors Harman Bains
 */

import android.support.annotation.NonNull;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


// set the table name to location_table
@Entity(tableName = "location_table")
public class LocationEntity {

    // possibly make the zip code the primary key for easier searching in the database
    /*
    @ColumnInfo (name = "zipCode")
    private int zipCode;
     */

    // generate the primary keys automatically
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "locationID")
    private int locationId;

    //sets the column names
    @ColumnInfo (name = "Latitude")
    private double lat;

    @ColumnInfo (name = "Longitude")
    private double lng;

    @ColumnInfo (name = "Active")
    private int activity;

    public LocationEntity(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
        this.activity = activity;

    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(@NonNull int locationId) {
        this.locationId = locationId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}
