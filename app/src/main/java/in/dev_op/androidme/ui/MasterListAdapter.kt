package `in`.dev_op.androidme.ui

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

/**
 * Created by harsh on 31/12/17.
 * Adapter to inflate and handle Grid of Available Images
 */
class MasterListAdapter(private val mImageIds: List<Int>,
                        private val mListener: OnImageClickListener) : BaseAdapter() {

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(parent!!.context)
            imageView.adjustViewBounds = true
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }
        imageView.setImageResource(mImageIds[position])
        imageView.setOnClickListener({
            mListener.onImageSelected(position)
        })
        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }


    override fun getCount(): Int {
        return mImageIds.size
    }

}