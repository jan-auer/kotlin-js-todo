package domain

data class Todo(
        val id: String,
        val title: String,
        val text: String = "",
        val completed: Boolean = false
)
