package pr.dwkim.themoviedatabase.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pr.dwkim.themoviedatabase.view.viewholder.DataBoundViewHolder

abstract class BaseListAdapter<T>(
    private val infiniteScrollListener: (() -> Unit)? = null
) : RecyclerView.Adapter<DataBoundViewHolder>() {
    val dataList: ArrayList<T> = arrayListOf()

    fun addFirst(item: T){
        dataList.add(0, item)
        notifyItemInserted(0)
    }

    fun addAll(itemList: List<T>) {
        dataList.addAll(itemList)
        notifyItemRangeChanged(itemCount, itemList.size)
    }

    fun clear() {
        dataList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder {
        val viewHolder = createBinding(parent, viewType)
        viewHolder.created()

        return viewHolder
    }

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): DataBoundViewHolder

    override fun onBindViewHolder(holder: DataBoundViewHolder, position: Int) {
        if(infiniteScrollListener != null && position == itemCount - 10 ){
            infiniteScrollListener.invoke()
        }

        bind(holder, position)
        holder.getDataBinding().executePendingBindings()
    }

    protected abstract fun bind(holder: DataBoundViewHolder, position: Int)

    fun getItem(position: Int) = dataList[position]

    override fun onViewAttachedToWindow(holder: DataBoundViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.attached()
    }

    override fun onViewDetachedFromWindow(holder: DataBoundViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.detached()
    }

    override fun getItemCount(): Int = dataList.size
}