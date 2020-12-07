package pr.dwkim.themoviedatabase.view.viewholder

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import pr.dwkim.themoviedatabase.databinding.IMovieListBinding
import pr.dwkim.themoviedatabase.model.MovieList

class MovieListViewHolder(
    private val lifecycleOwner: LifecycleOwner,
    private val binding: IMovieListBinding
): DataBoundViewHolder(binding){
    fun bind(data: MovieList?){
        data?.let {
            binding.lifecycleOwner = lifecycleOwner
            binding.data = data
        }
    }
}