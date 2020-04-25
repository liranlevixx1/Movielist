package msapps.movies.com.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import msapps.movies.com.data.db.entity.Movie;

@Database(entities = Movie.class,version = 1)
public abstract class DatabaseManager extends RoomDatabase {

    public abstract dao dao();


        //setting a singleton to make a database object.
    private static volatile DatabaseManager databaseManager;

    public static DatabaseManager getDatabase(final Context contex){
        //checking if the instance is null and creates it otherwise return it.
        if(databaseManager == null){
            synchronized (DatabaseManager.class) {
                if(databaseManager == null) {

                    databaseManager = Room.databaseBuilder(contex.getApplicationContext()
                            , DatabaseManager.class, "movies_database.db").build();
                }
            }
        }
        return databaseManager;
    }

}
