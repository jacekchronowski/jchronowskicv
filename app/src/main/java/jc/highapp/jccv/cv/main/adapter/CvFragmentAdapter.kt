package jc.highapp.jccv.cv.main.adapter

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import jc.highapp.jccv.R
import jc.highapp.jccv.cv.education.view.EducationFragment
import jc.highapp.jccv.cv.experience.view.ExperienceFragment
import jc.highapp.jccv.cv.skills.view.SkillsFragment

class CvFragmentAdapter(
    private val resources: Resources,
    fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SkillsFragment()
            1 -> ExperienceFragment()
            2 -> EducationFragment()
            else -> throw IllegalStateException()
        }
    }

    override fun getCount(): Int = CV_PAGES_NUMBER

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> resources.getString(R.string.skills_title)
            1 -> resources.getString(R.string.experience_title)
            2 -> resources.getString(R.string.education_title)
            else -> throw IllegalStateException()
        }
    }

    companion object {
        const val CV_PAGES_NUMBER = 3
    }

}
