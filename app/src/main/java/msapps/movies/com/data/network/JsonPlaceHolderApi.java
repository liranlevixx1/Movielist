package msapps.movies.com.data.network;

import java.util.List;

import msapps.movies.com.data.db.entity.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    // matching it to our json api movies Object.
    @GET("movies.json")
    Call<List<Movie>> getMovies();
}
