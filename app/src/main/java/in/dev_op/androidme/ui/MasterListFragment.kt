package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
import `in`.dev_op.androidme.data.AndroidImageAssets
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import kotlinx.android.synthetic.main.fragment_master_list.*

/**
 * Created by harsh on 31/12/17.
 * List Fragment to display list of images in GridView
 */
class MasterListFragment : Fragment() {

    private lateinit var mMasterListAdapter: MasterListAdapter

    private lateinit var mCallback: OnImageClickListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnImageClickListener) mCallback = context
        else throw ClassCastException(context.toString() + " must implement OnImageClickListener")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMasterListAdapter = MasterListAdapter(AndroidImageAssets.getAll(), mCallback)
        gridView.numColumns = 2
        gridView.stretchMode = GridView.STRETCH_COLUMN_WIDTH
        gridView.adapter = mMasterListAdapter
    }

}