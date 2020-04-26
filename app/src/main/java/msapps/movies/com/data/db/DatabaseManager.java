package msapps.movies.com.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import msapps.movies.com.data.db.entity.Movie;

@Database(entities = Movie.class,version = 1)
public abstract class DatabaseManager extends RoomDatabase {

    public abstract movieDao dao();

    //setting a singleton to make a database object.
    private static DatabaseManager databaseManager;
    // a method to check if the object was'nt created if it was return it.
    public static DatabaseManager getDatabase(Context contex){
        //checking if the instance is null and creates it otherwise return it.
        if(databaseManager == null){
            synchronized (DatabaseManager.class) {
                if(databaseManager == null) {
                    //creating a data base file .
                    databaseManager = Room.databaseBuilder(contex.getApplicationContext()
                            , DatabaseManager.class, "movies_database.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return databaseManager;
    }


}
