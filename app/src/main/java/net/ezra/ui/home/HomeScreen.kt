package net.ezra.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_HOME
import net.ezra.R
import net.ezra.navigation.ROUTE_CATTLE

@Composable
fun HomeScreen(navController: NavHostController) {
Box(modifier = Modifier
    .fillMaxSize()
    .background(Color.White)
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(modifier = Modifier.fillMaxWidth())
            {
                Column (horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(5.dp)
                    )
                {
                    Card (
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(2.dp, Color.Transparent),
                        modifier = Modifier
                            .width(35.dp)
                            .height(45.dp)
                            .background(Color.Transparent)
                            .fillMaxSize()
                        ,
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xffd7f9dc)
                        ),
                        elevation = CardDefaults.cardElevation(15.dp)

                    ) {
                        IconButton(onClick = { /*TODO*/ })
                        {
                            Icon(imageVector = Icons.Default.Menu, contentDescription ="drawer" )
                        }

                    }

                }

                Spacer(modifier = Modifier.width(100.dp))

                Column(horizontalAlignment = Alignment.End,
                  // modifier = Modifier
                      // .padding(5.dp)
                )
                {
                     Text(text = "MY FARM",
                         color = Color(0xff00b806),
                         modifier = Modifier.padding(20.dp))

                }

                Spacer(modifier = Modifier.width(80.dp))

                Column (horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(5.dp))
                {

                Card (
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(35.dp)
                        .height(45.dp)
                        .background(Color.Transparent)
                        .fillMaxSize()
                    ,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffd7f9dc)
                    ),
                    elevation = CardDefaults.cardElevation(15.dp)

                ) {
                    IconButton(onClick = { /*TODO*/ })
                    {
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription ="accounts" )
                    }
                }

                }
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Today's weather", fontFamily = FontFamily.Serif, modifier = Modifier.padding(10.dp))
            }
            Row(modifier = Modifier.fillMaxWidth()) {

                Card (
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(400.dp)
                        .height(150.dp)
                        .background(Color.Transparent)
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xff34f8ec)
                    ),
                    elevation = CardDefaults.cardElevation(15.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .height(120.dp)
                       )
                    {
                        Column (
                            modifier = Modifier
                                .absolutePadding(0.dp)
                        ){
                            Image(painter = painterResource(R.drawable.weather), contentDescription ="",modifier = Modifier.fillMaxSize() )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .height(30.dp)
                    ) {
                        Column (
                            modifier = Modifier
                                .absolutePadding(170.dp)
                        ){
                            Text(text = "WEATHER", color = Color.Black)
                        }
                    }
                }
            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
            Text(text = "Manage your farm")
            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "My cattle")
            }
            Row(modifier = Modifier.fillMaxWidth()) {

                Card (
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(500.dp)
                        .height(150.dp)
                        .background(Color.Transparent)
                        .fillMaxSize()
                        .clickable {
                            navController.navigate(ROUTE_CATTLE) {
                                popUpTo(ROUTE_HOME) { inclusive = true }
                            }
                        }

                    ,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffd7f9dc)
                    ),
                    elevation = CardDefaults.cardElevation(15.dp)

                ) {
                    Row (
                        modifier = Modifier
                            .height(120.dp)
                    ){
                        Column (
                            modifier = Modifier
                                .absolutePadding(1.dp)
                        ){
                            Image(painter = painterResource(R.drawable.cow), contentDescription ="" , modifier = Modifier.fillMaxSize())
                        }
                    }
                    Row(
                        modifier = Modifier
                            .height(30.dp)
                    ) {
                        Column (
                            modifier = Modifier
                                .absolutePadding(160.dp)
                        ){
                            Text(text = "MY CATTLE", color = Color.Black)
                        }
                    }

                }
            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "My equipment")
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Card (
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(500.dp)
                        .height(150.dp)
                        .background(Color.Transparent)
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffd7f9dc)
                    ),
                    elevation = CardDefaults.cardElevation(500.dp)

                ) {
                    Row (
                        modifier = Modifier
                            .height(120.dp)
                    ){
                        Column(
                            modifier = Modifier
                                .absolutePadding(14.dp)
                        ) {
                            Image(painter = painterResource(R.drawable.tractor), contentDescription ="" , modifier = Modifier.fillMaxSize())
                        }
                    }
                    Row(
                        modifier = Modifier
                            .height(30.dp)
                    ) {
                        Column (
                            modifier = Modifier
                                .absolutePadding(160.dp)
                        ){
                            Text(text = "MY EQUIPMENT", color = Color.Black)
                        }
                    }


                }

            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "My crops")
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Card (
                    shape = RoundedCornerShape(30.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(500.dp)
                        .height(150.dp)
                        .background(Color.Transparent)
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffd7f9dc)
                    ),
                    elevation = CardDefaults.cardElevation(15.dp)

                ) {
                    Row (
                        modifier = Modifier
                            .height(120.dp)
                    ){
                        Column(
                            modifier = Modifier
                                .absolutePadding(14.dp)
                        ) {
                            Image(painter = painterResource(R.drawable.crops), contentDescription ="" , modifier = Modifier.fillMaxSize())
                        }
                    }
                    Row(
                        modifier = Modifier
                            .height(30.dp)
                    ) {
                        Column (
                            modifier = Modifier
                                .absolutePadding(160.dp)
                        ){
                            Text(text = "MY CROPS", color = Color.Black)
                        }
                    }



                }



                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "MY FARM",
                        color = Color.Transparent

                    )

                }


            }
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,

                ){
                Card (
                    shape = RoundedCornerShape(90.dp),
                    border = BorderStroke(2.dp, Color.Transparent),
                    modifier = Modifier
                        .width(150.dp)
                        .height(55.dp)
                        .background(Color.Transparent)
                        .fillMaxSize()
                        .absolutePadding(0.dp, 15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xffd7f9dc)
                    ),
                    elevation = CardDefaults.cardElevation(25.dp)

                ) {

                        Row(modifier = Modifier
                            .fillMaxSize()
                            .absolutePadding(5.dp, 5.dp)
                        ) {
                            Column {
                                IconButton(onClick = { /*TODO*/ })
                                {
                                    Image(painter = painterResource(R.drawable.cloudy), contentDescription ="" , modifier = Modifier.fillMaxSize())

                                }

                            }
                            Column {
                                IconButton(onClick = { /*TODO*/ })
                                {
                                    Image(painter = painterResource(R.drawable.homee), contentDescription ="" , modifier = Modifier.fillMaxSize())

                                }

                            }
                            Column {
                                IconButton(onClick = { /*TODO*/ })
                                {
                                    Image(painter = painterResource(R.drawable.acc), contentDescription ="" , modifier = Modifier.fillMaxSize())

                                }

                            }

                        }




                }

            }


            }





        }

    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    HomeScreen(rememberNavController())
}

