package jc.highapp.jccv.cv.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import jc.highapp.jccv.cv.education.view.EducationFragment
import jc.highapp.jccv.cv.experience.view.ExperienceFragment
import jc.highapp.jccv.cv.skills.view.SkillsFragment

class CvFragmentAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> SkillsFragment()
            1 -> ExperienceFragment()
            2 -> EducationFragment()
            else -> throw IllegalStateException()
        }
    }

    override fun getCount(): Int = CV_PAGES_NUMBER

    override fun getPageTitle(position: Int): CharSequence {
        return "OBJECT ${(position + 1)}"
    }

    companion object {
        const val CV_PAGES_NUMBER = 3
    }

}
