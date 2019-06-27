import io.reactivex.subjects.BehaviorSubject
import ui.MainActivity

object Example {
    class Test(val test: String)

    @JvmStatic
    fun main(args: Array<String>) {
        val test = ""

        val linePublisher = BehaviorSubject.create<String>()
        linePublisher.onNext("Hello")

        linePublisher.subscribe {
            println(it)
        }

        linePublisher.onNext("After")

        linePublisher.subscribe {
            println("After: $it")
        }

        MainActivity().onCreate()
        /*Thread{
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
//            it.flatMap {
                linePublisher.doOnNext { println("OnNext $it") }
//            }
        }.subscribe {
            println(it)
        }

        */
        Thread.sleep(7000)
    }
}