import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

class UserInteractor {
    companion object {
        val instance by lazy {
            UserInteractor()
        }
    }
    private val isLogin = BehaviorSubject.create<Boolean>()

    fun getIsLogin(): Observable<Boolean> = isLogin

    fun login(){
        isLogin.onNext(true)
    }

    fun logout() {
        isLogin.onNext(false)
    }

}