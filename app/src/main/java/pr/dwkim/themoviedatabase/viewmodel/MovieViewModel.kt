package pr.dwkim.themoviedatabase.viewmodel

import android.os.Parcelable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import pr.dwkim.themoviedatabase.model.MovieList
import pr.dwkim.themoviedatabase.repository.IRepository
import pr.dwkim.themoviedatabase.util.*
import pr.dwkim.themoviedatabase.view.util.ListLayoutState
import javax.inject.Inject

class MovieViewModel @ViewModelInject constructor(
    private val repository: IRepository,
    private val scheduleProvider: ScheduleProvider
) : RxViewModel() {
    val movieList = MutableLiveData<List<MovieList>>()
    val movieListLoading = MutableLiveData<Boolean>()
    val movieListLayoutStatus = MutableLiveData(ListLayoutState.List)
    private var movieListPage = 1

    fun refreshPopularList(){
        movieListPage = 1
        movieListLayoutStatus.value = ListLayoutState.Empty
        movieListLoading.value = false
    }

    fun getPopularList(){
        movieListLoading.value = true
        launch {
            repository.getPopularList(movieListPage)
                .with(scheduleProvider)
                .subscribe(
                    { result ->
                        val list =
                            result?.results
                                ?.map { movie ->
                                    MovieList(movie)
                                }

                        movieList.value = list
                        movieListLayoutStatus.value = list?.getListLayoutState()
                        movieListLoading.value = false
                        movieListPage++
                    },
                    { throwable ->
                        states.value = ErrorState(throwable)
                        movieListLoading.value = false
                    }
                )
        }
    }
}