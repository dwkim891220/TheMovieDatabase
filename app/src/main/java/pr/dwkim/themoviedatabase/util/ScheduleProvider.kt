package pr.dwkim.themoviedatabase.util

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import pr.dwkim.themoviedatabase.repository.IRepository
import pr.dwkim.themoviedatabase.repository.remote.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class ScheduleProviderModule{
    @Binds
    @Singleton
    abstract fun bindScheduleProvider(provider: ApplicationSchedulerProvider): SchedulerProvider
}

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