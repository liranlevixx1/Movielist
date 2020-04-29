package msapps.movies.com.data.network;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidhiveApiService {
    public Retrofit retrofit;

    // calling the data from the json.
    public void getMovieResponmse() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("Json", "working");

    }
}
