import domain.Todo
import org.w3c.fetch.RequestInit
import kotlin.browser.window

fun toggleTodo(todo: Todo) {
    launch {
        window.fetch("http://localhost:8080/todo/${todo.id}", object : RequestInit {
            override var method: String? = "PUT"
            override var body: dynamic = JSON.stringify(todo.copy(completed = !todo.completed))
            override var headers: dynamic = JSON.parse("""{"Content-Type": "application/json"}""")
        }).await()
    }
}
