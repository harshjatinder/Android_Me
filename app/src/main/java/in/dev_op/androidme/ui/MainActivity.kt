package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
import `in`.dev_op.androidme.constants.EXTRAS
import `in`.dev_op.androidme.data.AndroidImageAssets
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.fragment_master_list.*

/**
 * Created by harsh on 31/12/17.
 * MainActivity as Launcher activity
 */
class MainActivity : AppCompatActivity(), OnImageClickListener {

    private val TAG = MainActivity::class.java.simpleName
    private val totalPiecesPerPart = 12

    private var mHeadIndex = 0
    private var mBodyIndex = 0
    private var mLegIndex = 0

    private var mShowMasterDetail = false

    private lateinit var mHeadFragment: BodyPartFragment
    private lateinit var mLegFragment: BodyPartFragment
    private lateinit var mBodyFragment: BodyPartFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowMasterDetail = findViewById<View>(R.id.center) != null
        setupMasterDetailFragments()
    }

    private fun setupMasterDetailFragments() {
        if (mShowMasterDetail) {

            mHeadFragment = BodyPartFragment()
            mLegFragment = BodyPartFragment()
            mBodyFragment = BodyPartFragment()

            mHeadFragment.setImageIds(AndroidImageAssets.getHeads())
            mBodyFragment.setImageIds(AndroidImageAssets.getBodies())
            mLegFragment.setImageIds(AndroidImageAssets.getLegs())
            supportFragmentManager.beginTransaction()
                    .add(R.id.headContainer, mHeadFragment)
                    .add(R.id.bodyContainer, mBodyFragment)
                    .add(R.id.legContainer, mLegFragment)
                    .commit()
            btNext.visibility = View.GONE
        }
    }

    override fun onImageSelected(position: Int) {
//        when (position) {
//            in (0..11) -> makeText(this, "Head Index = " + position, LENGTH_SHORT).show()
//            in (12..23) -> makeText(this, "Body Index = " + position, LENGTH_SHORT).show()
//            else -> makeText(this, "Leg Index = " + position, LENGTH_SHORT).show()
//        }
        val bodyPartNumber = position / totalPiecesPerPart
        val lastIndex = position - (12 * bodyPartNumber)
        when (bodyPartNumber) {
            0 -> mHeadIndex = lastIndex
            1 -> mBodyIndex = lastIndex
            2 -> mLegIndex = lastIndex
        }

        if (mShowMasterDetail) {
            mHeadFragment.setListIndex(mHeadIndex)
            mBodyFragment.setListIndex(mBodyIndex)
            mLegFragment.setListIndex(mLegIndex)
            mHeadFragment.setupView()
            mBodyFragment.setupView()
            mLegFragment.setupView()
        } else {
            val bundle = Bundle()
            bundle.putInt(EXTRAS.HEAD_INDEX, mHeadIndex)
            bundle.putInt(EXTRAS.BODY_INDEX, mBodyIndex)
            bundle.putInt(EXTRAS.LEG_INDEX, mLegIndex)

            val intent = Intent(this, AndroidMeActivity::class.java)
            intent.putExtras(bundle)

            btNext.setOnClickListener({ startActivity(intent) })
        }
    }
}