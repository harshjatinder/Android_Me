package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
import `in`.dev_op.androidme.constants.EXTRAS
import `in`.dev_op.androidme.data.AndroidImageAssets
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_android_me.*

/**
 * Created by harsh on 28/12/17.
 * Launcher Activity
 */
class AndroidMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        if (savedInstanceState == null) {
            setFragments()
        }
    }

    private fun setFragments() {
        val headFragment = BodyPartFragment()
        val legFragment = BodyPartFragment()
        val bodyFragment = BodyPartFragment()

        headFragment.setImageIds(AndroidImageAssets.getHeads())
        bodyFragment.setImageIds(AndroidImageAssets.getBodies())
        legFragment.setImageIds(AndroidImageAssets.getLegs())


        if (intent.extras != null) {
            val bundle = intent.extras
            headFragment.setListIndex(bundle.getInt(EXTRAS.HEAD_INDEX))
            bodyFragment.setListIndex(bundle.getInt(EXTRAS.BODY_INDEX))
            legFragment.setListIndex(bundle.getInt(EXTRAS.LEG_INDEX))
        } else {
            throw NullPointerException("Bundle Not received!")
        }

        supportFragmentManager.beginTransaction()
                .add(headContainer.id, headFragment)
                .add(bodyContainer.id, bodyFragment)
                .add(legContainer.id, legFragment)
                .commit()
    }

}