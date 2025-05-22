package pranala.ragam.karya.repository

import pranala.ragam.karya.constants.BASE_URL
import pranala.ragam.karya.repository.interfaces.TodoServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetroApi {

    val api: TodoServices by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoServices::class.java)
    }
}