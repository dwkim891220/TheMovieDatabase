package pr.dwkim.themoviedatabase.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import pr.dwkim.themoviedatabase.model.MovieList
import pr.dwkim.themoviedatabase.repository.IRepository
import pr.dwkim.themoviedatabase.util.RxViewModel
import pr.dwkim.themoviedatabase.util.ScheduleProvider
import pr.dwkim.themoviedatabase.util.with
import javax.inject.Inject

class MovieViewModel @ViewModelInject constructor(
    private val repository: IRepository,
    private val scheduleProvider: ScheduleProvider
) : RxViewModel() {
    fun getPopularList(){
        launch {
            repository.getPopularList(1)
                .with(scheduleProvider)
                .subscribe(
                    { result ->
                        result?.results?.map { movie ->
                            MovieList(movie)
                        }
                    },
                    { throwable ->

                    }
                )
        }
    }
}