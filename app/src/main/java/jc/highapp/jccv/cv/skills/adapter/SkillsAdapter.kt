package jc.highapp.jccv.cv.skills.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import jc.highapp.jccv.cv.skills.model.SkillItem

class SkillsAdapter : ListDelegationAdapter<List<SkillItem>>() {

    init {
        delegatesManager.addDelegate(ToolDelegate())
        delegatesManager.addDelegate(LanguageDelegate())
        delegatesManager.addDelegate(PersonalSkillDelegate())
    }
}