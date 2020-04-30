package msapps.movies.com.data.network;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AndroidhiveApiService {
    //public Retrofit retrofit;
    public  Retrofit retrofit;
    private static final String BASE_URL = "https://api.androidhive.info/json/";




    // calling the data from the json.
   /* public void getMovieResponse() {

     /*   retrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



    }*/


    public  Retrofit getMovieResponse() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
