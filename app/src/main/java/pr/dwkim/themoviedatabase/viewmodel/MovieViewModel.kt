package pr.dwkim.themoviedatabase.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import pr.dwkim.themoviedatabase.repository.IRepository
import pr.dwkim.themoviedatabase.util.RxViewModel
import pr.dwkim.themoviedatabase.util.with

class MovieViewModel @ViewModelInject constructor(
    private val repository: IRepository
) : RxViewModel() {
    fun getPopularList(){
        launch {
            repository.getPopularList(1)
                .with
        }
    }
}