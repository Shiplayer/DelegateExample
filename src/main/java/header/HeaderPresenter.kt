package header

import UserInteractor
import base.BasePresenter
import io.reactivex.disposables.Disposable
import kotlin.properties.Delegates

class HeaderPresenter : BasePresenter<HeaderView>(){
    private var lastStateOfLogin by Delegates.observable(false) { param, old, new ->
        action()
    }
    private val disposable: Disposable

    private var action: () -> Unit = {}

    fun connectToDelegate(action: () -> Unit){
        this.action = action
    }

    init {
        disposable = UserInteractor.instance.getIsLogin().subscribe{
            lastStateOfLogin = it
        }
    }

    fun getStatusOfLogin() = lastStateOfLogin
}