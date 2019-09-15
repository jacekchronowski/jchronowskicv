package jc.highapp.jccv.cv.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.services.model.ProgrammingLanguage

class CVAdapter : ListDelegationAdapter<List<CVItem>>() {

    init {
        delegatesManager.addDelegate(ToolsDelegate())
        delegatesManager.addDelegate(LanguageDelegate())
        delegatesManager.addDelegate(PersonalSkillsDelegate())
        delegatesManager.addDelegate(ProgrammingLanguageDelegate())
        delegatesManager.addDelegate(ExperienceDelegate())
    }
}