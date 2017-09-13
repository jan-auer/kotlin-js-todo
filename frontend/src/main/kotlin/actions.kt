import domain.Todo
import org.w3c.fetch.RequestInit
import kotlin.browser.window
import kotlin.js.Math

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

fun createTodo(title: String) {
    val id = Math.random().toString()
    val todo = Todo(id = id, title = title)
    putTodo(todo)
}

fun toggleTodo(todo: Todo) {
    putTodo(todo.copy(completed = !todo.completed))
}
