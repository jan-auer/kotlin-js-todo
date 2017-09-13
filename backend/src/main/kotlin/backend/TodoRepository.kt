package backend

import domain.ToDo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import kotlin.collections.HashMap

@Repository
class TodoRepository {
    private val store = Collections.synchronizedMap(HashMap<String, ToDo>())

    init {
        add(ToDo(id = randomUUID(), title = "Bootstrap Project", completed = true))
        add(ToDo(id = randomUUID(), title = "Coding Backend"))
        add(ToDo(id = randomUUID(), title = "Coding Frontend"))
    }

    private final fun randomUUID() = UUID.randomUUID().toString()

    final fun getAll(): Flux<ToDo> = Flux.fromIterable(store.values)
    final fun get(id: String): Mono<ToDo> = Mono.justOrEmpty(store[id])
    final fun add(todo: ToDo) = store.put(todo.id, todo)
}
