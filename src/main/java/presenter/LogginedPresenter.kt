package presenter

import UserInteractor
import base.BasePresenter
import view.LogginedView

class LogginedPresenter : BasePresenter<LogginedView>() {
    fun logout(){
        UserInteractor.instance.logout()
    }

}