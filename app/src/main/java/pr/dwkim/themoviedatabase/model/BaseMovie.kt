package pr.dwkim.themoviedatabase.model

import pr.dwkim.themoviedatabase.repository.remote.model.Movie

open class BaseMovie(private val data: Movie?) {
    private val baseUrl = "https://image.tmdb.org/t/p/"
    private val imageSize = "w500/"

    val id: Int = data?.id ?: -1
    val title: String = data?.title ?: "unknown"
    val releaseDate: String = data?.releaseDate ?: "yyyy-mm-dd"
    val voteAverage: Double = data?.voteAverage ?: 0.0
    val voteCount: Int = data?.voteCount ?: 0
    val backdropUrl: String? = if(data?.backDropPath != null) baseUrl + imageSize + data.backDropPath else null
    val posterUrl: String? = if(data?.posterPath != null) baseUrl + imageSize + data.posterPath else null
}