import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

object Example {
    class Test(val test: String)

    @JvmStatic
    fun main(args: Array<String>) {
        val linePublisher = PublishSubject.create<String>()

        Thread{
            var line = ""
            do {
                line = readLine() ?: "end"
                linePublisher.onNext(line)
            } while (line != "end")
        }.start()

        val observable = Observable.range(0, 100)

        observable.concatMap {
            Observable.just("Hello $it").delay(1500, TimeUnit.MILLISECONDS)
        }.subscribe{
            println("concatmap $it")
        }

        observable.repeatWhen {
            linePublisher.doOnNext { println("OnNext $it") }
        }.subscribe {
            println(it)
        }

        Thread.sleep(7000)
    }
}