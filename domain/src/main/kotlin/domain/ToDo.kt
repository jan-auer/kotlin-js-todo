package domain

data class ToDo(
        val id: String,
        val title: String,
        val text: String = "",
        val completed: Boolean = false
)
