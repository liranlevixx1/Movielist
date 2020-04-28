package msapps.movies.com.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import msapps.movies.com.data.db.DatabaseManager;
import msapps.movies.com.data.db.MovieDao;
import msapps.movies.com.data.db.entity.Movie;

public class Repository {

    private MovieDao movieDao;
    private LiveData<List<Movie>> allMovies;

    public Repository(Application application) {
        DatabaseManager database = DatabaseManager.getDatabase(application);
        movieDao = database.movieDao();
        allMovies = movieDao.getAllMoviesByIRD();

    }

    public void insert(Movie movie) {
        //   movieDao.insert(movie);
        new InsertMoviesAsyncTask(movieDao).execute(movie);
    }

    public LiveData<List<Movie>> getAllMoviesByIRD() {
        return allMovies;
    }

    private static class InsertMoviesAsyncTask extends AsyncTask<Movie, Void, Void> {
        private MovieDao movieDao;

        private InsertMoviesAsyncTask(MovieDao movieDao) {
            this.movieDao = movieDao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDao.insert(movies[0]);
            return null;
        }
    }

}


