package pranala.ragam.karya.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pranala.ragam.karya.repository.RetroApi
import pranala.ragam.karya.repository.model.Todos

class TodosVM : ViewModel() {
    // or using mutable live data MutableLiveData
    val dataList = MutableLiveData<List<Todos>?>(null)
    private var error: String = "";

    init {
//        fetchList()
    }

    fun fetchList() {

        viewModelScope.launch {
            if (error.isNotEmpty()) {
                error = ""
            }
            try {
                // api retrofit here
                val response = RetroApi.api.getTodos()

                // update state here
//                dataList.value.apply { response.todos }
                if (response.isNotEmpty()) {
                    dataList.value = response
                }
                Log.i("RESPONSE", dataList.value?.count().toString())
            } catch (exc: Exception) {
                val what = exc.message

                Log.e("RESPONSE", what ?: "ERROR")

                error = what ?: "ERROR DATA FETCH"
                dataList.value = null
            }
//            finally {
//                Log.i("RESPONSE", dataList.value?.count().toString())
//            }

        }

    }

}