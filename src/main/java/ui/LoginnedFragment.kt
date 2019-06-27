package ui

import Fragment
import presenter.LogginedPresenter

class LoginnedFragment : Fragment() {
    private var action: () -> Unit = {}
    private val presenter by lazy {
        LogginedPresenter()
    }

    companion object {
        fun instance(action: () -> Unit) = LoginnedFragment().apply {
            this.action = action
        }
    }

    override fun onCreate() {
        super.onCreate()
        ButtonView().call { presenter.logout() }
    }
}