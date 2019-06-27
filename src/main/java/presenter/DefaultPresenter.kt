package presenter

import UserInteractor
import base.BasePresenter
import view.DefaultView

class DefaultPresenter: BasePresenter<DefaultView>(){
    fun login(){
        UserInteractor.instance.login()
    }
}