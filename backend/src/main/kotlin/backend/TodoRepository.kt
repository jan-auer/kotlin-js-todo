package backend

import domain.Todo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import kotlin.collections.ArrayList

@Repository
class TodoRepository {
    private val store = Collections.synchronizedList(ArrayList<Todo>())

    init {
        put(Todo(id = randomUUID(), title = "Bootstrap Project", completed = true))
        put(Todo(id = randomUUID(), title = "Coding Backend"))
        put(Todo(id = randomUUID(), title = "Coding Frontend"))
    }

    private final fun randomUUID() = UUID.randomUUID().toString()

    final fun getAll(): Flux<Todo> = Flux.fromStream(store.stream())
    final fun get(id: String): Mono<Todo> = Mono.justOrEmpty(store.firstOrNull { it.id == id })
    final fun put(todo: Todo) {
        store.removeAll({ it.id == todo.id })
        store.add(todo)
    }
}
