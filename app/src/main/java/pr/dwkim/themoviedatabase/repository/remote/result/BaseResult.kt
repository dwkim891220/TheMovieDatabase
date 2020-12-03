package pr.dwkim.themoviedatabase.repository.remote.result

import com.google.gson.annotations.SerializedName

open class BaseResult<T> {
    @SerializedName("status_message") val statusMessage: String? = null
    val data: T? = null
}