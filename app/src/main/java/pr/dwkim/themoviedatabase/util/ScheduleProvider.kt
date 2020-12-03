package pr.dwkim.themoviedatabase.util

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
@InstallIn(ApplicationComponent::class)
interface SchedulerProvider {
    fun io(): Scheduler
    fun ui(): Scheduler?
    fun computation(): Scheduler
}

class ApplicationSchedulerProvider : SchedulerProvider {
    override fun io() = Schedulers.io()
    override fun ui(): Scheduler? = AndroidSchedulers.mainThread()
    override fun computation() = Schedulers.computation()
}