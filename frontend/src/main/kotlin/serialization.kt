import domain.Todo

/**
 * Converts a plain [json] object into a [Todo]
 *
 * Note that this function does not validate the JSON before converting.
 * Incomplete data, such as a missing id or title could cause errors later
 * in the program. Kotlin does not runime-check dynamic values at all.
 */
fun deserializeTodo(json: dynamic) = Todo(json.id, json.title, json.text, json.completed)

/**
 * Converts a plain [json] object into an array of [Todo]s.
 *
 * Note that this function does not validate the JSON before converting. The
 * cast to Array<T> is unsafe and will always succeed. Calling map on the
 * result can crash during runtime, however, if the [json] parameter does
 * not implement a compatible map method. Kotlin neither runtime-checks the
 * cast nor the result type.
 */
fun <T> mapJson(json: dynamic, transform: (dynamic) -> T) = (json as Array<T>).map(transform)
