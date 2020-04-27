package msapps.movies.com;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import msapps.movies.com.data.db.entity.Movie;
import msapps.movies.com.ui.MovieListAdapter;
import msapps.movies.com.ui.MovieListVM;

public class MainActivity extends AppCompatActivity {
    private MovieListVM movieListVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.movieRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final MovieListAdapter adapter = new MovieListAdapter();
        recyclerView.setAdapter(adapter);

        movieListVM = new ViewModelProvider(this).get(MovieListVM.class);
        movieListVM.getAllMoviesByIRD().observe(this, new Observer<List<Movie>>() {
            @Override
            // will trigger every time our data in LiveData changes.
            public void onChanged(List<Movie> movies) {
                //update our recycler view.
                adapter.setMovies(movies);
            }
        });
    }
}
