package pr.dwkim.themoviedatabase.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.rxjava3.core.Single
import pr.dwkim.themoviedatabase.repository.remote.RepositoryImpl
import pr.dwkim.themoviedatabase.repository.remote.result.BaseResult
import pr.dwkim.themoviedatabase.repository.remote.result.DetailResult
import pr.dwkim.themoviedatabase.repository.remote.result.PopularListResult
import pr.dwkim.themoviedatabase.repository.remote.result.VideoResult
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule{
    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): IRepository
}

interface IRepository {
    fun getPopularList(page: Int): Single<BaseResult<PopularListResult>>
    fun getDetail(movieId: Int): Single<BaseResult<DetailResult>>
    fun getVideos(movieId: Int): Single<BaseResult<VideoResult>>
}
