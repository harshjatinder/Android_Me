package `in`.dev_op.androidme.ui

import `in`.dev_op.androidme.R
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

        headFragment.setListIndex(0)
        bodyFragment.setListIndex(0)
        legFragment.setListIndex(0)

        supportFragmentManager.beginTransaction()
                .add(headContainer.id, headFragment)
                .add(bodyContainer.id, bodyFragment)
                .add(legContainer.id, legFragment)
                .commit()
    }

}