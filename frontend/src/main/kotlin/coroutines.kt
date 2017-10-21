import kotlin.coroutines.experimental.*
import kotlin.js.Promise

/**
 * Suspends the coroutine until the promise resolves, then returns its resolved value
 */
suspend fun <T> Promise<T>.await(): T = suspendCoroutine { cont ->
    then({ cont.resume(it) }, { cont.resumeWithException(it) })
}

/**
 * Launches an asynchronous block as coroutine
 *
 * The block is executed with an empty context. If it throws an exception, the error is logged to
 * the console.
 */
fun launch(block: suspend () -> Unit) {
    block.startCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext get() = EmptyCoroutineContext
        override fun resume(value: Unit) {}
        override fun resumeWithException(exception: Throwable) {
            console.log("Coroutine failed: $exception")
        }
    })
}
