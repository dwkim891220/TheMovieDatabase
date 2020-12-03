package pr.dwkim.themoviedatabase.repository.remote.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("genres") val genres: List<Genre?>? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null,
    @SerializedName("backdrop_path") val backDropPath: String? = null,
    @SerializedName("poster_path") val posterPath: String? = null
)

data class Genre(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null
)

data class Video(
    @SerializedName("id") val id: String? = null,
    @SerializedName("key") val key: String? = null
)