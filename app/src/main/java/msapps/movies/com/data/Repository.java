package msapps.movies.com.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

import msapps.movies.com.data.db.DatabaseManager;
import msapps.movies.com.data.db.entity.Movie;

public class Repository {

    private Dao dao;
    private  LiveData<List<Movie>> allMovies;

     public Repository(Application application){
         DatabaseManager database =DatabaseManager.getDatabase(application);
         dao = (Dao) database.dao();
         allMovies = dao.getAllmovies();
     }

}
