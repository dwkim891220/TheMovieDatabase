package pr.dwkim.themoviedatabase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import pr.dwkim.themoviedatabase.R
import pr.dwkim.themoviedatabase.databinding.ActivityMainBinding
import pr.dwkim.themoviedatabase.util.WrapperLayoutManager
import pr.dwkim.themoviedatabase.util.initDefault
import pr.dwkim.themoviedatabase.view.adapter.MovieListAdapter
import pr.dwkim.themoviedatabase.viewmodel.MovieViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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
        binding.list.initDefault(
            context = this,
            adapter = MovieListAdapter(this@MainActivity)
        )
    }
}