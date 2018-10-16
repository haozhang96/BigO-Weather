package edu.uncg.csc.bigo.weather.models.util;

/*
 * This interface has methods that access the database of locations. This is used to simplify access
 * to the database instead of using direct queries.
 * @updated
 * @authors Harman Bains
 */
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LocationDAO {

    // query selects all the locations stored in the database
    @Query("SELECT * FROM location_table")
    List<LocationEntity> getAllLocations();

    // LiveData<List<LocationEntity>> ggetAllLocations();  //    use this to display updated data in the UI with LiveData


    // select locations based on a given latitude
    @Query("SELECT * FROM location_table where Latitude LIKE :lat")
    LocationEntity findByLat(double lat);



    // count how many entires are in the database
    @Query("SELECT COUNT(*) from location_table")
    int countUsers();


    // replace the row in case of conflict when inserting the data
    //   @Insert(onConflict = OnConflictStrategy.REPLACE)

    // insert coordinates into the database
    @Insert
    void insert(List<LocationEntity> coordinates);


    @Insert
    void insertSingle(LocationEntity singleLocation);


   //avoid deleting from the database. Simply mark it as inactive
/*
    @Query("DELETE FROM location_table")
    void deleteAll();

    @Delete
    void delete(LocationEntity one_coord);
*/
}
