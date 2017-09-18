import domain.Todo
import org.w3c.fetch.RequestInit
import kotlin.browser.window

/**
 * Creates or updates a [todo] on the server and redraws the UI on success
 */
private fun putTodo(todo: Todo) {
    launch {
        window.fetch("http://localhost:8080/todo/${todo.id}", object : RequestInit {
            override var method: String? = "PUT"
            override var body: dynamic = JSON.stringify(todo)
            override var headers: dynamic = JSON.parse("""{"Content-Type": "application/json"}""")
        }).await()
        render()
    }
}

/**
 * Creates a new todo with the given [title]
 *
 * This method is asynchronous and automatically redraws the UI on completion. In case of an error,
 * the error is printed to the console and the UI is not updated.
 */
fun createTodo(title: String) {
    val id = Lodash.uniqueId("todo_")
    val todo = Todo(id = id, title = title)
    putTodo(todo)
}

/**
 * Toggles the completed state of the given [todo]
 *
 * This method is asynchronous and automatically redraws the UI on completion. In case of an error,
 * the error is printed to the console and the UI is not updated.
 */
fun toggleTodo(todo: Todo) {
    putTodo(todo.copy(completed = !todo.completed))
}
