package a.alt.z.tmdb.ui.popular

import a.alt.z.tmdb.databinding.ItemPopularMovieBinding
import a.alt.z.tmdb.model.Movie
import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation

class PopularMoviesViewHolder(
        private val binding: ItemPopularMovieBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) = binding.run {
        popularMovieItemImageView.load(movie.posterUrl) {
            val radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4F, root.context.resources.displayMetrics)
            transformations(RoundedCornersTransformation(radius))
        }
        popularMovieItemTitleTextView.text = movie.title
    }
}