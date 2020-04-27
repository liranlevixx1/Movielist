package msapps.movies.com.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import msapps.movies.com.R;
import msapps.movies.com.data.db.entity.Movie;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder> {

    private List<Movie> movies = new ArrayList<>();

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int position) {
        Movie currentMovie = movies.get(position);
        movieHolder.title.setText(currentMovie.getTitle());
        // movieHolder.movieImage.setImageDrawable(currentMovie.getImage());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class MovieHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView movieImage;

        public MovieHolder(@Nullable View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movieTextView);
            movieImage = itemView.findViewById(R.id.movieImage);

        }
    }
}
