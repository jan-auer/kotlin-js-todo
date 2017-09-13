import domain.Todo
import kotlinx.html.*
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement

fun <T, C : kotlinx.html.TagConsumer<T>> C.Todo(todo: Todo) = label {
    checkBoxInput {
        checked = todo.completed
        onChangeFunction = { toggleTodo(todo) }
    }

    +todo.title
}

fun <T, C : kotlinx.html.TagConsumer<T>> C.Todos(todos: List<Todo>) = div {
    id = "todos"

    h1 { +"TODO Application" }
    ul {
        todos.forEach { todo ->
            li {
                Todo(todo)
            }
        }
    }

    textInput {
        onChangeFunction = { event ->
            val input = event.target!! as HTMLInputElement
            createTodo(input.value)
            input.value = ""
        }
    }
}

