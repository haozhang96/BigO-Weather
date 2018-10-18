package edu.uncg.csc.bigo.weather.models.util;

/*
 * The database created using Room Database. It is a SQLite database with a Room database layer on it.
 * @updated
 * @authors Harman Bains
 */

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;         //added because giving error
import android.arch.persistence.room.Room;      //added bc giving error
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {LocationEntity.class}, version = 1)
public abstract class LocationDatabase extends RoomDatabase {

    // declare the DAO
    public abstract LocationDAO locationDao();

    // private static final String DB_name = "location_db";

    // Use an instance to avoid having multiple databases.
    private static LocationDatabase INSTANCE;


    // This method builds the database
    public static LocationDatabase getLocationDatabase(Context context) {
        if (INSTANCE == null){
                        // The database is created here with its name.
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                LocationDatabase.class, "location_db")

                                // Will be removed in real app.
                                .allowMainThreadQueries()

                                .addCallback(new RoomDatabase.Callback() {

                                    // Add this when the database has been created
                                    @Override
                                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                        super.onCreate(db);
                                        Log.d("LocationDatabase", "Populating the database...");
                                    }
                                })
                                .build();
                    }
            return INSTANCE;
        }


        /* This class is used to add an entity into the database in the background.
           Can also be made to delete everything in the database in the beginning.
           The AsyncTask feature is used because Room database does not function properly on UI thread.
         */
        private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

            private final LocationDAO locationDAO;

            public PopulateDbAsync (LocationDatabase instance) {
                locationDAO = instance.locationDao();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                LocationEntity test = new LocationEntity(45.2, 54.2);
                locationDAO.insertSingle(test);
                return null;
            }
        }
    }

