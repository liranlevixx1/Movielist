package msapps.movies.com.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import msapps.movies.com.R;
import msapps.movies.com.data.db.entity.Movie;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieHolder> {

    //private List<Movie> movies = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private Context context;


    public MovieListAdapter(Context context, ArrayList<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return the inflater with the card view movie_item.
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder movieHolder, int position) {
        movieHolder.title.setText(movies.get(position).getTitle());

        Picasso.get().load(movies.get(position).getImage()).into(movieHolder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = (ArrayList<Movie>) movies;
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
