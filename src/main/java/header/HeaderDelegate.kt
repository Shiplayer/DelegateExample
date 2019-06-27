package header

import ui.DefaultFragment
import Fragment
import ui.LoginnedFragment
import base.BaseDelegate
import kotlin.reflect.KProperty

class HeaderDelegate(val action: HeaderActionView) : BaseDelegate<HeaderView, HeaderPresenter, Fragment> {
    private lateinit var presenter: HeaderPresenter
    override fun initPresenters() {
        presenter = HeaderPresenter()
        presenter.connectToDelegate {
            action.updateHeader()
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): Fragment {
        return if(presenter.getStatusOfLogin()) {
            LoginnedFragment()
        } else
            DefaultFragment()
        //return Fragment()
    }


}