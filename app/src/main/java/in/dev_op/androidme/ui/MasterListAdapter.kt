package `in`.dev_op.androidme.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

/**
 * Created by harsh on 31/12/17.
 * Adapter to inflate and handle Grid of Available Images
 */
class MasterListAdapter(private val mImageIds: List<Int>,
                        private val mListener: OnImageClickListener) : RecyclerView.Adapter<MasterListAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(ImageView(parent!!.context))
    }

    override fun getItemCount(): Int {
        return mImageIds.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder!!.mImageView.setImageResource(mImageIds[position])
        holder.mImageView.setOnClickListener({ mListener.onImageSelected(position) })
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mImageView: ImageView

        init {
            mImageView = itemView as ImageView
            mImageView.adjustViewBounds = true
            mImageView.scaleType = ImageView.ScaleType.FIT_CENTER
            mImageView.setPadding(8, 8, 8, 8)
        }
    }

}