package pranala.ragam.karya.pages

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pranala.ragam.karya.repository.model.Todos
import pranala.ragam.karya.view_model.TodosVM


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TodosView() {

    val vm = TodosVM()
    val todos = vm.advice.observeAsState(initial = emptyList())
    val its = todos.value.size


    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Todo Items")}) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                vm.fetchList()
            }) {
                Icon(
                    imageVector = Icons.Default.Refresh, contentDescription = "Fetch"
                )
            }
        }, modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {


            if (its > 0) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    itemsIndexed(todos.value) { idx, item ->
                        TodosCard(idx, item)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            } else {
                Column {
                    NoDataView()
//            FooterAction(vm)
                }
            }
//            Text(todos.value.size.toString())
        }

    }


}


@Composable
fun NoDataView() {
    Text("NO DATA")
}

@Composable
fun TodosCard(idx: Int, item: Todos) {
//    val isCompleted = if (item[idx]!.completed) "ON" else "OFF";
    val clr = if (item.completed) Color.Green else Color.Red
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, clr),
//        onClick = {}
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            horizontalAlignment = Alignment.End,
        ) {
            Checkbox(checked = item.completed, onCheckedChange = {})
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(item.title ?: "No Title")
            Spacer(modifier = Modifier.height(10.dp))
            Text("ID = ${item.id.toString()}");
            Text("User ID = ${item.userId.toString()}");

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp),
                horizontalAlignment = Alignment.Start,
            ) {

                Spacer(modifier = Modifier.height(16.dp))
            }

        }
    }
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