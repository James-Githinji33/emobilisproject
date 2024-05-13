package net.ezra.ui.cattle

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_CATTLE
import net.ezra.navigation.ROUTE_CATTLE2
import net.ezra.navigation.ROUTE_DRYCOW
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MILKINGCOW
import net.ezra.ui.home.HomeScreen


@Composable
fun CattleScreen2(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    )  {
        // Image(painter = painterResource(R.drawable.coww),
        //   contentDescription = "",
        // modifier = Modifier.fillMaxSize()
        //)
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
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
                                Text(text = "MY CATTLE",
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
                                        Icon(imageVector = Icons.Default.Person, contentDescription ="ACC" )
                                    }
                                }

                            }
                        }
                        Row(modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(text = "Lets farm", fontFamily = FontFamily.Serif, modifier = Modifier.padding(10.dp))
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
                                        navController.navigate(ROUTE_MILKINGCOW) {
                                            popUpTo(ROUTE_CATTLE2) { inclusive = true }
                                        }
                                    }

                                ,
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
                                        Image(painter = painterResource(R.drawable.milkingcow), contentDescription ="",modifier = Modifier.fillMaxSize() )
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
                                        Text(text = "MILKING COWS", color = Color.Black)
                                    }
                                }
                            }
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
                                        navController.navigate(ROUTE_DRYCOW) {
                                            popUpTo(ROUTE_CATTLE2) { inclusive = true }
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
                                        Image(painter = painterResource(R.drawable.bull), contentDescription ="" , modifier = Modifier.fillMaxSize())
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
                                        Text(text = "DRY CATTLE", color = Color.Black)
                                    }
                                }

                            }
                        }



                    }





                }




            }
        }

    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun CattleScreenPreviewLight(){
    CattleScreen2(rememberNavController())
}


