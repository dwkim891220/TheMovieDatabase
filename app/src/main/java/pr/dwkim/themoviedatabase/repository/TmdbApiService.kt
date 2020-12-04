package pr.dwkim.themoviedatabase.repository

import io.reactivex.rxjava3.core.Single
import pr.dwkim.themoviedatabase.BuildConfig
import pr.dwkim.themoviedatabase.repository.remote.result.BaseResult
import pr.dwkim.themoviedatabase.repository.remote.result.DetailResult
import pr.dwkim.themoviedatabase.repository.remote.result.PopularListResult
import pr.dwkim.themoviedatabase.repository.remote.result.VideoResult
import pr.dwkim.themoviedatabase.util.API_KEY
import pr.dwkim.themoviedatabase.util.MOVIE
import pr.dwkim.themoviedatabase.util.MOVIE_POPULAR
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApiService {
    @GET(MOVIE_POPULAR)
    fun getPopularList(
        @Query(encoded = true, value = API_KEY) apiKey: String = BuildConfig.ApiKey,
        @Query(encoded = true, value = "page") page: Int
    ): Single<PopularListResult>

    @GET("$MOVIE/{movie_id}")
    fun getDetail(
        @Query(encoded = true, value = API_KEY) apiKey: String = BuildConfig.ApiKey,
        @Path(encoded = true, value = "movie_id") movieId: Int
    ): Single<BaseResult<DetailResult>>

    @GET("$MOVIE/{movie_id}/videos")
    fun getVideos(
        @Query(encoded = true, value = API_KEY) apiKey: String = BuildConfig.ApiKey,
        @Path(encoded = true, value = "movie_id") movieId: Int
    ): Single<BaseResult<VideoResult>>
}