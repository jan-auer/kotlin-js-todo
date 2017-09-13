
import domain.Todo
import kotlinx.html.*
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement

fun <T, C : kotlinx.html.TagConsumer<T>> C.Todo(todo: Todo) = div {
    onClickFunction = { toggleTodo(todo) }

    checkBoxInput(classes = "toggle") {
        checked = todo.completed
    }

    label {
        +todo.title
    }
}

fun <T, C : kotlinx.html.TagConsumer<T>> C.Todos(todos: List<Todo>) = div {
    id = "todos"

    h1 { +"Todos" }

    header(classes = "header") {
        textInput(classes = "new-todo") {
            placeholder = "What would you like TODO?"
            onChangeFunction = { event ->
                val input = event.target!! as HTMLInputElement
                createTodo(input.value)
                input.value = ""
            }
        }
    }

    ul(classes = "todo-list") {
        todos.forEach { todo ->
            li {
                Todo(todo)
            }
        }
    }
}

