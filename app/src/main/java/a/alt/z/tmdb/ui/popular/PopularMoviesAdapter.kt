package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.databinding.ItemPopularMovieBinding
import a.alt.z.tmdb.model.Movie
import a.alt.z.tmdb.util.layoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class PopularMoviesAdapter: ListAdapter<Movie, PopularMoviesViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        return ItemPopularMovieBinding
                .inflate(parent.layoutInflater, parent, false)
                .let { PopularMoviesViewHolder(it) }
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) = holder.bind(getItem(position))

    companion object {
        private val callback = object: DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
        }
    }
}