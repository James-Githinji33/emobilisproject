package net.ezra.ui.cattle

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_CATTLE
import net.ezra.navigation.ROUTE_CATTLE2
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.navigation.ROUTE_STUDENT_LIST


data class Item(

    val imageUrl: String? = "",
    val Cowname: String? = "",
    val Cowbreed: String? = "",
    val Cowid: String? ="",
    val Cowage : String? =""

)


class FirestoreViewModel : ViewModel() {

    private val firestore = Firebase.firestore
    private val itemsCollection = firestore.collection("Students")

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        itemsCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Log.e("FirestoreViewModel", "Error fetching items", error)
                return@addSnapshotListener
            }

            val itemList = mutableListOf<Item>()
            snapshot?.documents?.forEach { document ->
                val item = document.toObject(Item::class.java)?.copy(Cowname = document.id)
                item?.let {
                    itemList.add(it)
                }
            }
            _items.value = itemList
        }
    }
}


@Composable
fun ItemList(items: List<Item>) {

    Column {

    Row(modifier = Modifier.fillMaxWidth()) {

        Card (
            shape = RoundedCornerShape(30.dp),
            border = BorderStroke(2.dp, Color.Transparent),
            modifier = Modifier
                .width(500.dp)
                .height(150.dp)
                .background(Color.Transparent)
                .fillMaxSize()

            ,
            colors = CardDefaults.cardColors(
                containerColor = Color(0xff34f8ec)
            ),
            elevation = CardDefaults.cardElevation(15.dp)

        ) {
            Row(
                modifier = Modifier
                    .height(60.dp)
            )
            {
                Column (
                    modifier = Modifier
                        .absolutePadding(0.dp)
                ){
                    Text("Register cow")
                }
            }
        }

    }
        Text(text = "Student List")


        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(10.dp)
        ) {

            items.forEach { item ->
                item {
                    Column {


                        SubcomposeAsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.imageUrl)
                                .crossfade(true)
                                .build(),
                            loading = {
                                CircularProgressIndicator()
                            },
                            contentDescription = item.Cowname,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(RoundedCornerShape(10))
                        )

                        item.Cowname?.let { Text(text = it) }
                        item.Cowbreed?.let { Text(text = it) }
                        item.Cowid?.let { Text(text = it) }
                        item.Cowage?.let { Text(text = it) }
                    }

                }
            }


        }
    }
}



@Composable
fun Viewmilkingcow (navController: NavHostController, viewModel: FirestoreViewModel) {
    val items by viewModel.items.observeAsState(initial = emptyList())

    // Fetch items when the composable is first created
    LaunchedEffect(viewModel, key2 = true) {
        viewModel.fetchItems()
    }

    Column {




    }


}


