package pr.dwkim.themoviedatabase.repository.remote.result

import com.google.gson.annotations.SerializedName
import pr.dwkim.themoviedatabase.repository.remote.model.Video

data class VideoResult(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("results") val results: List<Video?>? = null
)