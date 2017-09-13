package backend

import domain.ToDo
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import java.util.*

@RestController
@CrossOrigin
@RequestMapping("/todo")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping("/")
    fun getTodos() = todoRepository.getAll()

    @GetMapping("/{id}")
    fun getToDo(@PathVariable id: String): Mono<ServerResponse> {
        val uuid = UUID.fromString(id)
        val toDo: Mono<ToDo> = todoRepository.get(uuid)

        return toDo
                .flatMap { ServerResponse.ok().contentType(APPLICATION_JSON).syncBody(it) }
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    @PutMapping("/{id}")
    fun putToDo(todo: ToDo) = todoRepository.add(todo)
}
