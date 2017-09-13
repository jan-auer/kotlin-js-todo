package backend

import domain.Todo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Repository
class TodoRepository {
    private val store = Collections.synchronizedMap(HashMap<String, Todo>())

    init {
        put(Todo(id = randomUUID(), title = "Bootstrap Project", completed = true))
        put(Todo(id = randomUUID(), title = "Coding Backend"))
        put(Todo(id = randomUUID(), title = "Coding Frontend"))
    }

    private final fun randomUUID() = UUID.randomUUID().toString()

    final fun getAll(): Flux<Todo> = Flux.fromIterable(store.values).sort { o1, o2 -> -o1.id.compareTo(o2.id) }
    final fun get(id: String): Mono<Todo> = Mono.justOrEmpty(store[id])
    final fun put(todo: Todo) = store.put(todo)
}
