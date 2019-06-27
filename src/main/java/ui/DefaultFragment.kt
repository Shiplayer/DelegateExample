package ui

import BaseLogginedFragment
import view.DefaultView
import presenter.DefaultPresenter

class DefaultFragment : BaseLogginedFragment(), DefaultView {
    override val action = {
        presenter.login()
    }
    private val presenter by lazy{
        DefaultPresenter()
    }
    //override val action =

    override fun onCreate() {
        super.onCreate()
        ButtonView().call { presenter.login() }
    }
}