package pr.dwkim.themoviedatabase.util.databinding

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import pr.dwkim.themoviedatabase.util.*

@BindingAdapter("glideUrl", requireAll = false)
fun loadImage(iv: ImageView, glideUrl: String?) {
    getGlideDrawable(
        iv.context,
        glideUrl,
        needGone = true,
        target = iv
    )?.run {
        apply(RequestOptions().centerCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(iv)
    }
}

fun getGlideInstance(
    context: Context?,
    url: String?,
    needGone: Boolean = false,
    target: View? = null
) : GlideRequests? {
    if(context == null) return null

    val glideApp = GlideApp.with(context)

    return if (url.isNullOrEmpty()) {
        if (target != null) {
            glideApp.clear(target)
        }

        if (needGone) {
            target?.show(false)
        }

        null
    } else {
        target?.show()
        glideApp
    }
}

fun getGlideDrawable(
    context: Context?,
    url: String?,
    needGone: Boolean = false,
    target: View? = null
): GlideRequest<Drawable>? =
    getGlideInstance(
        context,
        url,
        needGone,
        target
    )?.let { request ->
        val convertedUrl = url.urlHelper()

        request.apply {
            if(convertedUrl?.contains(".gif") == true){
                asGif()
            }
        }.load(convertedUrl?.addReferer())
    }