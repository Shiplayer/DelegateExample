abstract class Fragment {

    fun start(){
        onCreate()
        onStart()
        onResume()
        onPause()
        onStop()
        onDestroy()
    }

    open fun onCreate() {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}
}

abstract class BaseLogginedFragment() : Fragment(){
    protected abstract val action: () -> Unit
}
