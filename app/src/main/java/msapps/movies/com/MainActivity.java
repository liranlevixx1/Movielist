package msapps.movies.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.List;

import msapps.movies.com.data.db.entity.Movie;
import msapps.movies.com.ui.MovieDetailsVM;

public class MainActivity extends AppCompatActivity {
    private MovieDetailsVM movieDetailsVM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieDetailsVM = new ViewModelProvider(this).get(MovieDetailsVM.class);
        movieDetailsVM.getAllMoviesByIRD().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {

            }
        });
    }
}
