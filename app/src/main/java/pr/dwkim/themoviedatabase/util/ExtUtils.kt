package pr.dwkim.themoviedatabase.util

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.ParcelableSpan
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.core.Single
import pr.dwkim.themoviedatabase.R

fun <T> Single<T>.with(schedulerProvider: ScheduleProvider): Single<T> =
    observeOn(schedulerProvider.ui())
        .subscribeOn(schedulerProvider.io())

fun View.show(show: Boolean = true){
    this.visibility = if(show) View.VISIBLE else View.GONE
}

fun View.isVisibility() : Boolean{
    return this.visibility == View.VISIBLE
}

fun Int.toPixel(context: Context): Int =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    ).toInt()

fun String.setBoldSpan(text: String): SpannableStringBuilder =
    SpannableStringBuilder(this).apply {
        var startIndex = this.indexOf(text)

        while (startIndex > -1){
            setSpan(
                StyleSpan(Typeface.BOLD),
                startIndex,
                startIndex + text.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            startIndex = this.indexOf(text, startIndex+1)
        }
    }

fun String.setBoldSpan(textList: List<String>): SpannableStringBuilder =
    SpannableStringBuilder(this).apply {
        textList.forEach { text ->
            var startIndex = this.indexOf(text)

            while (startIndex > -1){
                setSpan(
                    StyleSpan(Typeface.BOLD),
                    startIndex,
                    startIndex + text.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                startIndex = this.indexOf(text, startIndex+1)
            }
        }
    }

fun String.getSpannableString(spans: List<TextSpanInfo>): SpannableStringBuilder =
    SpannableStringBuilder(this).apply {
        spans.filter { spanInfo ->
            spanInfo.startIndex > -1 && spanInfo.endIndex > 0
        }.forEach { spanInfo ->
            setSpan(
                spanInfo.span,
                spanInfo.startIndex,
                spanInfo.endIndex,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }

open class TextSpanInfo(val span: ParcelableSpan, val startIndex: Int, val endIndex: Int)

class ColorSpan(
    context: Context,
    color: Int,
    startIndex: Int,
    endIndex: Int
) : TextSpanInfo(
    ForegroundColorSpan(ContextCompat.getColor(context, color)),
    startIndex,
    endIndex
)

class BoldSpan(
    startIndex: Int,
    endIndex: Int
) : TextSpanInfo(
    StyleSpan(Typeface.BOLD),
    startIndex,
    endIndex
)

fun RecyclerView.initDefault(
    context: Context?,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    orientation: Int = RecyclerView.VERTICAL,
    layoutManager: RecyclerView.LayoutManager = WrapperLayoutManager(context, orientation),
    scrollListener: RecyclerView.OnScrollListener? = null,
    decoration: RecyclerView.ItemDecoration? = null
){
    initRecyclerView(
        recyclerView = this,
        lm = layoutManager,
        pAdapter = adapter,
        scrollListener = scrollListener,
        decoration = decoration
    )
}

private fun initRecyclerView(
    recyclerView: RecyclerView,
    lm: RecyclerView.LayoutManager,
    pAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    scrollListener: RecyclerView.OnScrollListener? = null,
    decoration: RecyclerView.ItemDecoration? = null
){
    recyclerView.run {
        adapter = pAdapter
        layoutManager = lm
        scrollListener?.let { listener ->
            addOnScrollListener(listener)
        }
        decoration?.let { decor ->
            addItemDecoration(decor)
        }
    }
}

fun FragmentTransaction.setUpAnimation(): FragmentTransaction =
    this.setCustomAnimations(
        R.anim.slide_in_up,
        R.anim.slide_out_down,
        R.anim.slide_in_down,
        R.anim.slide_out_up
    )

fun FragmentTransaction.setSlideAnimation(): FragmentTransaction =
    this.setCustomAnimations(
        R.anim.slide_in_right,
        R.anim.slide_out_left,
        R.anim.slide_in_left,
        R.anim.slide_out_right
    )

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.argument(key: String) = lazy { arguments?.get(key) as T}

@Suppress("UNCHECKED_CAST")
fun <T> AppCompatActivity.argument(key: String) = lazy { intent?.extras?.get(key) as T }