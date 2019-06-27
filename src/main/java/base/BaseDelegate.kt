package base

import kotlin.reflect.KProperty

interface BaseDelegate<V: BaseView, P: BasePresenter<V>, out T>{

    fun initPresenters()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T

    operator fun provideDelegate(thisRef: Any?, prop: KProperty<*>): BaseDelegate<V, P, T> {
        initPresenters()
        println("provideDelegate")
        return this
    }

}