package backend

import domain.Todo
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.bind.annotation.*
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@RestController
@CrossOrigin
@RequestMapping("/todo")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping("/")
    fun getTodos() = todoRepository.getAll()

    @GetMapping("/{id}")
    fun getToDo(@PathVariable id: String): Mono<ServerResponse> {
        val todo: Mono<Todo> = todoRepository.get(id)

        return todo
                .flatMap { ServerResponse.ok().contentType(APPLICATION_JSON).syncBody(it) }
                .switchIfEmpty(ServerResponse.notFound().build())
    }

    @PutMapping("/{id}")
    fun putToDo(@RequestBody todo: Todo) = todoRepository.put(todo)
}
