import kotlinx.html.dom.append
import kotlin.browser.document
import kotlin.browser.window

/**
 * Loads all Todos and renders the main UI
 */
suspend fun render() {
    // Asynchronously fetch all TODOs from the server. We suspend until the response
    // arrives, so we can immediately render the main UI. Usually, we would display
    // a loading indicator here, so the user knows what's going on. Also, it makes
    // sense to store TODOs in some local state so we don't have to fetch them every
    // time we're rendering the App.
    val response = window.fetch("http://localhost:8080/todo/").await()

    // It is important to transform plain JS objects to domain objects here
    // Otherwise, we wouldn't be able to call instance methods on them later on
    val todos = mapJson(response.json().await(), ::deserializeTodo)

    // Remove any previous content
    document.getElementById("todos")?.let {
        it.parentNode!!.removeChild(it)
    }

    // Render our new content
    document.body!!.append {
        Todos(todos)
    }
}

/**
 * This is the main entry point of the Todo app. All imported files will be compiled
 * into a single bundle by the kotlin2js compiler. Since we use certain methods from
 * stdlib we also need to load kotlin.js during runtime.
 */
fun main(args: Array<String>) {
    // Since render is suspending, we need to call it in a coroutine context.
    // This is handled by the launch helper
    launch { render() }
}
