package msapps.movies.com.data.db;

import android.telecom.Call;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import msapps.movies.com.data.db.entity.Movie;

@Dao
public interface movieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Movie movie);
    // we will call it in recycle view.
    @Query("SELECT *FROM movies_table ORDER BY title ASC")
    LiveData<List<Movie>> getAllMovies();

    @Query("SELECT *FROM movies_table ORDER BY releaseYear ASC")
    LiveData<List<Movie>> getAllMoviesByIRD();


}
