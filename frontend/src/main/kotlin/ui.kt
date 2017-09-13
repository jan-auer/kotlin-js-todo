import domain.Todo
import kotlinx.html.*
import kotlinx.html.js.onChangeFunction

fun <T, C : kotlinx.html.TagConsumer<T>> C.Todos(todos: List<Todo>) = div {
    h1 { +"TODO Application" }
    ul {
        todos.forEach { todo ->
            li {
                label {
                    checkBoxInput {
                        checked = todo.completed
                        onChangeFunction = { toggleTodo(todo) }
                    }

                    +todo.title
                }
            }
        }
    }
}

