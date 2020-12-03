package pr.dwkim.themoviedatabase.util

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class RxViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    fun launch(job: () -> Disposable) {
        disposables.add(job())
    }

    fun cleanJobs(){
        disposables.clear()
    }

    fun cleanLaunch(job: () -> Disposable){
        cleanJobs()
        launch(job)
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}