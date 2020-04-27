package msapps.movies.com.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import msapps.movies.com.data.db.MovieDao;

//used it in order to parse the application context.
public class SplashVM extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MovieDao moviedao;

    public SplashVM(@NonNull Application application) {
        super(application);
    }

    protected void onCleard() {
        super.onCleared();
        Log.i(TAG, "ViewModel destroyed.");

    }
}
