package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
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

    private val imageIds = ArrayList<Int>()
    private var listIndex = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (savedInstanceState != null) {
            imageIds.addAll(savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST))
            listIndex = savedInstanceState.getInt(LIST_INDEX)
        }
        return inflater.inflate(R.layout.fragment_body_part, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBodyPart.setImageResource(imageIds[listIndex])
        ivBodyPart.setOnClickListener({
            if (!imageIds.isEmpty()) {
                listIndex++
                if (listIndex == imageIds.size) {
                    listIndex = 0
                }
                ivBodyPart.setImageResource(imageIds[listIndex])
            } else {
                Log.d(TAG, "OnClickListener : imageIds.length = ${imageIds.size}")
            }
        })
    }

    fun setImageIds(imageList: List<Int>) {
        this.imageIds.addAll(imageList)
    }

    fun setListIndex(index: Int) {
        this.listIndex = index
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, imageIds)
        outState.putInt(LIST_INDEX, listIndex)
    }
}