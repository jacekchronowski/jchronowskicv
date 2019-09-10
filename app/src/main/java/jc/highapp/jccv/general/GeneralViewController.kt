package jc.highapp.jccv.general

import jc.highapp.jccv.architecture.BaseViewController

class GeneralViewController : BaseViewController<GeneralState, GeneralViewModel>() {

    private val renderPlugin : GeneralRenderPlugin = GeneralRenderPlugin()

    override fun setupView() {
        addPlugin(renderPlugin)
    }

    override fun destroyView() {

    }

    override fun render(state: GeneralState) {
        renderPlugin.render(state)
    }

}