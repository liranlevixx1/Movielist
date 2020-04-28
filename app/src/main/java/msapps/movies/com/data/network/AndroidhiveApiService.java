package msapps.movies.com.data.network;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import msapps.movies.com.MainActivity;
import msapps.movies.com.data.db.entity.Movie;
import msapps.movies.com.ui.MovieListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidhiveApiService {
    /*public ArrayList<Movie> movies = new ArrayList<>();
    private MainActivity mainActivity;

    public void getMovieResponmse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Movie>> call = jsonPlaceHolderApi.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movies = new ArrayList<>(response.body());
                mainActivity.adapter = new MovieListAdapter(MainActivity.this ,movies);
                mainActivity.recyclerView.setAdapter(mainActivity.adapter);
                if (!response.isSuccessful()) {

                }

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
              //  Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }

        });

    }*/
}
