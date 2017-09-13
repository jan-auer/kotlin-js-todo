package backend

import domain.Todo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import kotlin.collections.HashMap

@Repository
class TodoRepository {
    private val store = Collections.synchronizedMap(HashMap<String, Todo>())

    init {
        add(Todo(id = randomUUID(), title = "Bootstrap Project", completed = true))
        add(Todo(id = randomUUID(), title = "Coding Backend"))
        add(Todo(id = randomUUID(), title = "Coding Frontend"))
    }

    private final fun randomUUID() = UUID.randomUUID().toString()

    final fun getAll(): Flux<Todo> = Flux.fromIterable(store.values)
    final fun get(id: String): Mono<Todo> = Mono.justOrEmpty(store[id])
    final fun add(todo: Todo) = store.put(todo.id, todo)
}
