package msapps.movies.com;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import msapps.movies.com.data.db.entity.Movie;
import msapps.movies.com.data.network.AndroidhiveApiService;
import msapps.movies.com.data.network.JsonPlaceHolderApi;
import msapps.movies.com.ui.MovieListAdapter;
import msapps.movies.com.ui.MovieListVM;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MovieListVM movieListVM;
    ArrayList<Movie> movies = new ArrayList<>();
    private RecyclerView recyclerView;
    private MovieListAdapter adapter;
    private AndroidhiveApiService androidhiveApiService;
    private JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // making an instance of the json parse class.
        //AndroidhiveApiService androidhiveApiService = new AndroidhiveApiService();
        // calling the method that parse the json.
        androidhiveApiService.getMovieResponmse();
        getMovieCalls();

        recyclerView = findViewById(R.id.movieRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

       /* adapter = new MovieListAdapter();
        recyclerView.setAdapter(adapter);
        //update our recycler view.
        adapter.setMovies(movies);*/

        movieListVM = new ViewModelProvider(this).get(MovieListVM.class);
        movieListVM.getAllMoviesByIRD().observe(this, new Observer<List<Movie>>() {
            @Override
            // will trigger every time our data in LiveData changes.
            public void onChanged(List<Movie> movies) {

            }
        });
    }

    public void getMovieCalls() {

        jsonPlaceHolderApi = androidhiveApiService.retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Movie>> call = jsonPlaceHolderApi.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(@NotNull Call<List<Movie>> call, @NotNull Response<List<Movie>> response) {
                assert response.body() != null;
                movies = new ArrayList<>(response.body());
                adapter = new MovieListAdapter(MainActivity.this, movies);
                recyclerView.setAdapter(adapter);
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "unsuccessful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                //  Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }

        });

    }
}
