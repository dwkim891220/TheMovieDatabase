package pr.dwkim.themoviedatabase.repository.remote

import io.reactivex.rxjava3.core.Single
import pr.dwkim.themoviedatabase.repository.IRepository
import pr.dwkim.themoviedatabase.repository.TmdbApiService
import pr.dwkim.themoviedatabase.repository.remote.result.BaseResult
import pr.dwkim.themoviedatabase.repository.remote.result.DetailResult
import pr.dwkim.themoviedatabase.repository.remote.result.PopularListResult
import pr.dwkim.themoviedatabase.repository.remote.result.VideoResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: TmdbApiService
): IRepository {
    override fun getPopularList(page: Int): Single<BaseResult<PopularListResult>> =
        apiService.getPopularList(page = page)

    override fun getDetail(movieId: Int): Single<BaseResult<DetailResult>> =
        apiService.getDetail(movieId = movieId)

    override fun getVideos(movieId: Int): Single<BaseResult<VideoResult>> =
        apiService.getVideos(movieId = movieId)
}