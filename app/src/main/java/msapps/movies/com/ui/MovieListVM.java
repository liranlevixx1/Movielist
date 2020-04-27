package msapps.movies.com.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import msapps.movies.com.data.Repository;
import msapps.movies.com.data.db.entity.Movie;

public class MovieListVM extends AndroidViewModel {

    private Repository repository;
    private LiveData<List<Movie>> allMovies;

    public MovieListVM(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        allMovies = repository.getAllMoviesByIRD();
    }

    // accessing our repository insert method.
    public void insert(Movie movie) {

        repository.insert(movie);
    }

    public LiveData<List<Movie>> getAllMoviesByIRD() {
        return allMovies;
    }
}
