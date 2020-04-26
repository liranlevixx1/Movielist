package msapps.movies.com.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Dao;

import msapps.movies.com.data.db.DatabaseManager;
import msapps.movies.com.data.db.movieDao;

//used it in order to parse the application context.
public class SplashVM extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private movieDao dao;

    public SplashVM(@NonNull Application application) {
        super(application);
    }

    protected void onCleard(){
        super.onCleared();
        Log.i(TAG,"ViewModel destroyed.");

    }
}
