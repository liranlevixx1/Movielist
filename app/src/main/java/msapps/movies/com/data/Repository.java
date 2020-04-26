package msapps.movies.com.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import java.util.List;

import msapps.movies.com.data.db.DatabaseManager;
import msapps.movies.com.data.db.entity.Movie;
import msapps.movies.com.data.db.movieDao;

public class Repository {

    private movieDao dao;
    private LiveData<List<Movie>> allMovies;

     public Repository(Application application){
         DatabaseManager database =DatabaseManager.getDatabase(application);
         dao =  database.dao();
         allMovies = dao.getAllMoviesByIRD();

     }

     public void insert(Movie movie){
        dao.insert(movie);
     }
     public LiveData<List<Movie>> getAllMovies(){
        return allMovies;
    }

}
