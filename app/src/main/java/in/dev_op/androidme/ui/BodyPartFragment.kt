package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
import `in`.dev_op.androidme.constants.EXTRAS
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_body_part.*

/**
 * Created by harsh on 28/12/17.
 * BodyPartFragment to display different body parts
 */
class BodyPartFragment : Fragment() {

    private val TAG = BodyPartFragment::class.simpleName
    private val IMAGE_ID_LIST = "image_id_list"
    private val LIST_INDEX = "list_index"

    private val mImageIds = ArrayList<Int>()
    private var mListIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (savedInstanceState != null) {
            mImageIds.addAll(savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST))
            mListIndex = savedInstanceState.getInt(LIST_INDEX)
        }
        return inflater.inflate(R.layout.fragment_body_part, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        if (arguments!!.getBoolean(EXTRAS.SET_LISTENERS, false)) setupListener()
    }

    private fun setupListener() {
        ivBodyPart.setOnClickListener({
            if (!mImageIds.isEmpty()) {
                mListIndex++
                if (mListIndex == mImageIds.size) {
                    mListIndex = 0
                }
                ivBodyPart.setImageResource(mImageIds[mListIndex])
            } else {
                Log.d(TAG, "OnClickListener : mImageIds.length = ${mImageIds.size}")
            }
        })
    }

    fun setupView() {
        ivBodyPart.setImageResource(mImageIds[mListIndex])
    }

    fun setImageIds(imageList: List<Int>) {
        this.mImageIds.addAll(imageList)
    }

    fun setListIndex(index: Int) {
        this.mListIndex = index
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, mImageIds)
        outState.putInt(LIST_INDEX, mListIndex)
    }

}