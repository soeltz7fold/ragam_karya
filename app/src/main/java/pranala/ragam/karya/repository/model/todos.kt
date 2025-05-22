package pranala.ragam.karya.repository.model

import com.google.gson.annotations.SerializedName

//data class TodoResponse(
//    val todos: List<Todos>,
//)

//data class Todos(
//    val userId: Int,
//    val id: Int,
//    val title: String,
//    val completed: Boolean,
//)
class Todos {

    @SerializedName("userId")
    val userId: Int? = null;
    @SerializedName("id")
    val id: Int? = null;
    @SerializedName("title")
    val title: String? = null;
    @SerializedName("completed")
    val completed: Boolean = false;
}

//  Sample data structure
//                    {
//                        "userId": 1,
//                        "id": 3,
//                        "title": "fugiat veniam minus",
//                        "completed": false
//                    },
