import domain.Todo

fun deserializeTodo(json: dynamic) = Todo(json.id, json.title, json.text, json.completed)

fun <T> mapJson(json: dynamic, transform: (dynamic) -> T) = (json as Array<T>).map(transform)
