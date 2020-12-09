package pr.dwkim.themoviedatabase.util.databinding

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import pr.dwkim.themoviedatabase.util.*
import pr.dwkim.themoviedatabase.view.adapter.BaseListAdapter

@BindingAdapter("show")
fun setLayoutShow(v: View, show: Boolean){
    v.show(show)
}

@BindingAdapter("bind_item")
fun <T> setBindItem(rv: RecyclerView, items: List<T>?){
    @Suppress("UNCHECKED_CAST")
    (rv.adapter as? BaseListAdapter<T>)?.run {
        if(items != null) addAll(items)
    }
}

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