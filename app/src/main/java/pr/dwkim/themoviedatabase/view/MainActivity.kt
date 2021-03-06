package pr.dwkim.themoviedatabase.view

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import pr.dwkim.themoviedatabase.R
import pr.dwkim.themoviedatabase.databinding.ActivityMainBinding
import pr.dwkim.themoviedatabase.util.WrapperLayoutManager
import pr.dwkim.themoviedatabase.util.initDefault
import pr.dwkim.themoviedatabase.util.toPixel
import pr.dwkim.themoviedatabase.view.adapter.MovieListAdapter
import pr.dwkim.themoviedatabase.viewmodel.MovieViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: MovieListAdapter
    private val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initBinding()
        initLayouts()

        viewModel.getPopularList()
    }

    private fun initBinding(){
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun initLayouts(){
        listAdapter =
            MovieListAdapter(
                infiniteScrollListener = {
                    viewModel.getPopularList()
                },
                this@MainActivity
            )

        binding.list.initDefault(
            context = this,
            adapter = listAdapter,
            decoration = DividerItemDecorator()
        )

        binding.srl.setOnRefreshListener {
            binding.srl.isRefreshing = false
            listAdapter.clear()
            viewModel.refreshPopularList()
            viewModel.getPopularList()
        }
    }

    inner class DividerItemDecorator : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)

            val padding = 8.toPixel(view.context)

            outRect.left = padding
            outRect.top = padding
            outRect.right = padding
        }
    }
}