package pr.dwkim.themoviedatabase.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import pr.dwkim.themoviedatabase.databinding.IMovieListBinding
import pr.dwkim.themoviedatabase.model.BaseMovie
import pr.dwkim.themoviedatabase.model.MovieList
import pr.dwkim.themoviedatabase.view.viewholder.DataBoundViewHolder
import pr.dwkim.themoviedatabase.view.viewholder.MovieListViewHolder
import java.lang.RuntimeException

class MovieListAdapter(
    private val lifecycleOwner: LifecycleOwner,
): BaseListAdapter<BaseMovie>() {
    override fun getItemViewType(position: Int): Int =
        when(dataList[position]) {
            is MovieList -> MovieListType.Item.ordinal
            else -> throw RuntimeException()
        }

    override fun createBinding(parent: ViewGroup, viewType: Int): DataBoundViewHolder =
        when(viewType){
            MovieListType.Item.ordinal -> {
                MovieListViewHolder(
                    lifecycleOwner,
                    IMovieListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> throw RuntimeException()
        }

    override fun bind(holder: DataBoundViewHolder, position: Int) {
        when (holder) {
            is MovieListViewHolder -> holder.bind(dataList[position] as? MovieList)
            else -> throw RuntimeException()
        }
    }

    enum class MovieListType {
        Item, Divider
    }
}