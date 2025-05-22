package pranala.ragam.karya.repository.interfaces

import pranala.ragam.karya.repository.model.Todos
import retrofit2.http.GET

interface TodoServices {

    @GET("todos")
//    suspend fun getTodos(): TodoResponse
    suspend fun getTodos(): List<Todos>
}