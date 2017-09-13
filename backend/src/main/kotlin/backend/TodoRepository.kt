package backend

import domain.ToDo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import kotlin.collections.HashMap

@Repository
class TodoRepository {
    private val store = Collections.synchronizedMap(HashMap<UUID, ToDo>())

    init {
        add(ToDo(title = "Bootstrap Project", completed = true))
        add(ToDo(title = "Coding Backend"))
        add(ToDo(title = "Coding Frontend"))
    }

    final fun getAll(): Flux<ToDo> = Flux.fromIterable(store.values)
    final fun get(id: UUID): Mono<ToDo> = Mono.justOrEmpty(store[id])
    final fun add(todo: ToDo) = store.put(todo.id, todo)
}
