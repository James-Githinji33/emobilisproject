package net.ezra.ui.cattle


import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HOME
import java.util.UUID
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import net.ezra.R
import net.ezra.navigation.ROUTE_REGISTERMILKCOW

@Composable
fun AddStudents(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.im3),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop

        )



        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {

                Column(

                    modifier = Modifier.padding(15.dp),

                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(painter = painterResource(R.drawable.homee), contentDescription = "",                        modifier = Modifier
                        .clickable {
                            navController.navigate(ROUTE_HOME) {
                                popUpTo(ROUTE_REGISTERMILKCOW) { inclusive = true }
                            }
                        },
                    )

                    Text(text = "Register milking cow")

                    var photoUri: Uri? by remember { mutableStateOf(null) }
                    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                        photoUri = uri
                    }

                    var CowName by rememberSaveable {
                        mutableStateOf("")
                    }

                    var Cowbreed by rememberSaveable {
                        mutableStateOf("")
                    }

                    var Cowid by rememberSaveable {
                        mutableStateOf("")
                    }

                    var Cowage by rememberSaveable {
                        mutableStateOf("")
                    }

                    OutlinedTextField(
                        value = CowName,
                        onValueChange = { CowName = it },
                        label = { Text(text = "Name") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = Cowbreed,
                        onValueChange = { Cowbreed= it },
                        label = { Text(text = "Breed") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = Cowid,
                        onValueChange = { Cowid= it },
                        label = { Text(text = "Cow ID") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = Cowage,
                        onValueChange = { Cowage= it },
                        label = { Text(text = "Age") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    )




                    OutlinedButton(
                        onClick = {
                            launcher.launch(
                                PickVisualMediaRequest(
                                    //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                    //Or use .VideoOnly if you only want videos.
                                    mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        }
                    ) {
                        Text("Select Image")
                    }


                    if (photoUri != null) {
                        //Use Coil to display the selected image
                        val painter = rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(data = photoUri)
                                .build()
                        )

                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(5.dp)
                                .size(150.dp)
                                .fillMaxWidth()
                                .border(1.dp, Color.Gray),
                            contentScale = ContentScale.Crop,

                            )
                    }


                    OutlinedButton(onClick = {
                        photoUri?.let { uploadImageToFirebaseStorage(it, CowName, Cowbreed, Cowid,Cowage) }

                    }) {

                        Text(text = "Register")


                    }











                }
            }
        }
    }


}



fun uploadImageToFirebaseStorage(imageUri: Uri, CowName: String, Cowbreed: String,Cowid: String, Cowage: String) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(downloadUri.toString(), CowName, Cowbreed, Cowid, Cowage)
        } else {


        }
    }
}

fun saveToFirestore(imageUrl: String, CowName: String,Cowbreed: String, Cowid: String, Cowage: String) {
    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "CowName" to CowName,
        "Cowbreed" to Cowbreed,
        "CowId" to Cowid,
        "Cowage" to Cowage



    )




    db.collection("Milkingcows")
        .add(imageInfo)
        .addOnSuccessListener {



        }
        .addOnFailureListener {
            // Handle error
        }
}








@Composable
fun Registermilkcow(navController: NavHostController) {

    Registermilkcow (rememberNavController())
}



