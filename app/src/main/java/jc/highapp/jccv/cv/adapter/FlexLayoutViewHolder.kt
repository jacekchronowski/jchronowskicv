package jc.highapp.jccv.cv.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jc.highapp.jccv.R
import jc.highapp.jccv.cv.model.CVItem
import jc.highapp.jccv.utils.inflate
import kotlinx.android.synthetic.main.ellipsize_item_layout.view.*
import kotlinx.android.synthetic.main.flexbox_item_layout.view.*

class FlexLayoutViewHolder(viewGroup: ViewGroup) : RecyclerView.ViewHolder(viewGroup.inflate(R.layout.flexbox_item_layout)) {

    fun bind(tool: CVItem.UserToolItem) {
        itemView.fb_container.removeAllViews()
        tool.toolsNames.forEach { toolName ->
            itemView.fb_container.addView(
                itemView.fb_container.inflate(R.layout.ellipsize_item_layout).apply {
                    tv_name.text = toolName
                })
        }
    }

    fun bind(skill: CVItem.UserPersonalSkill) {
        itemView.fb_container.removeAllViews()
        skill.skillssNames.forEach { skillName ->
            itemView.fb_container.addView(
                itemView.fb_container.inflate(R.layout.ellipsize_item_layout).apply {
                    tv_name.text = skillName
                })
        }    }
}