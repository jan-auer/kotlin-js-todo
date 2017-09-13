
import org.w3c.fetch.RequestInit
import kotlin.browser.window

fun toggleTodo(todo: Todo) {
    launch {
        window.fetch("http://192.168.1.82:8080/todo/${todo.id}", object : RequestInit {
            override var method: String? = "PUT"
            override var body: dynamic = JSON.stringify(todo)
        }).await()

//        val changedTodo = deserializeTodo(response.json().await())
//        println("TODO Changed: ${todo}")
    }
}
