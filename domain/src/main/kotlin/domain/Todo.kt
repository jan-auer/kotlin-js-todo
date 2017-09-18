package domain

/**
 * Shared domain object for Todos.
 *
 * Note that we're allowed to use all basic data types as well as types
 * defined in kotlin-stdlib-common. We could also implement behavior here,
 * as long as we don't rely on platform-specific code.
 *
 * For platform-specific behavior, we would have to create "header"
 * declarations and "impl" them for all targets in their respective
 * sub-projects. See https://vimeo.com/215556547#t=868s for more information.
 */
data class Todo(
        val id: String,
        val title: String,
        val text: String = "",
        val completed: Boolean = false
)
