import kotlinx.html.dom.append
import kotlin.browser.document
import kotlin.browser.window

suspend fun render() {
    val response = window.fetch("http://localhost:8080/todo/").await()
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

fun main(args: Array<String>) {
    launch {
        render()
    }
}
