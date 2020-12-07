package pr.dwkim.themoviedatabase.util

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

fun String?.urlHelper() : String? =
    if(this.isNullOrEmpty()) {
        null
    }else{
        if (contains("https://") || contains("http://")) {
            this
        } else {
            if (contains("//")) {
                "https:$this"
            } else {
                "https://$this"
            }
        }
    }

fun String.addReferer(): GlideUrl =
    GlideUrl(
        this,
        LazyHeaders.Builder()
            .addHeader(
                "",
                ""
            ).build()
    )