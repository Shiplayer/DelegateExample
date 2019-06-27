package ui

import base.ContentView
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class ButtonView : ContentView, ButtonClickable {
    override fun call(action: () -> Unit) {
        Single.just("").delay(1500, TimeUnit.MILLISECONDS).subscribe ({
            action()
        }, {
            it.printStackTrace()
            println(it)
        }
        )
    }

}