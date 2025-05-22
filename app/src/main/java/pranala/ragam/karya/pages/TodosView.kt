package pranala.ragam.karya.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pranala.ragam.karya.view_model.TodosVM



@Composable
fun TodosView() {

    val vm = TodosVM()
    val todos = vm.dataList.value

    val its = todos?.size ?: 0
    if (its > 0) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            itemsIndexed(todos!!) { idx, item ->
                val isCompleted = if (item.completed) "ON" else "OFF";
                Card() {
                    Column() {
                        Text("ID = ${item.id.toString()}");
                        Text("User ID = ${item.id.toString()}");
                        Text(item.title ?: "No Title")
                        Text("Status = $isCompleted")
                    }
                }

//        TodosCard(vm)
            }
        }
    } else {
        Column {
            NoDataView()
            FooterAction(vm)
        }
    }


}


@Composable
fun NoDataView() {
    Text("NO DATA")
}

@Composable
fun TodosCard(vm: TodosVM) {
    Text(
        text = "todos?.count().toString()",
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(8.dp, 10.dp)
    )
}

@Composable
fun FooterAction(vm: TodosVM) {
    Spacer(modifier = Modifier.height(10.dp))
    Button(onClick = {
        vm.fetchList()
    }) {
        Text("Fetch Now = ")
    }
}