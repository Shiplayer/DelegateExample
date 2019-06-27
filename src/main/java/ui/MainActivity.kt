package ui

import base.BaseActivity
import header.HeaderActionView
import header.HeaderDelegate

class MainActivity : BaseActivity(), HeaderActionView {
    override fun updateHeader() {
        val fragment = instance
        fragment.start()
        println(fragment::class.simpleName)
    }

    private val instance by HeaderDelegate(this)

    override fun onCreate() {
        super.onCreate()
        instance.start()
        Thread.sleep(1000)
    }
}
