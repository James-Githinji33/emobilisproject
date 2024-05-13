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
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import net.ezra.navigation.ROUTE_HOME


@Composable
fun CattleScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    )  {
       Image(painter = painterResource(R.drawable.coww),
            contentDescription = "",
            modifier = Modifier.fillMaxSize()
            )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column (
                    modifier = Modifier.fillMaxSize()
                ){
                    Row (
                        modifier = Modifier.absolutePadding(0.dp,100.dp)
                    ){
                        Image(painter = painterResource(R.drawable.cowpage),
                            contentDescription = "",
                             modifier = Modifier.fillMaxSize()
                        )

                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(130.dp),
                        Arrangement.Center

                    ){
                        Text(text = "CATTLE" ,
                            fontSize = (30.sp),
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.absolutePadding(0.dp,30.dp,120.dp)

                        )


                        
                    }

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(100.dp),
                        Arrangement.Center

                    ){
                        Text(text = "MANAGER" ,
                            fontSize = (30.sp),
                            color = Color.Black,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.absolutePadding(0.dp,10.dp,80.dp)

                        )

                    }
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .absolutePadding(0.dp, 20.dp, 0.dp)
                    ){
                        Card(
                            shape = RoundedCornerShape(30.dp),
                            border = BorderStroke(2.dp, Color.Transparent),
                            modifier = Modifier
                                .width(500.dp)
                                .height(70.dp)
                                .background(Color.Transparent)
                                .fillMaxSize()
                                .absolutePadding(20.dp, 0.dp, 20.dp)
                                .clickable {
                                    navController.navigate(ROUTE_CATTLE2) {
                                        popUpTo(ROUTE_CATTLE) { inclusive = true }
                                    }
                                }

                            ,
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xffd7f9dc)
                            ),
                            elevation = CardDefaults.cardElevation(15.dp) ,
                        )
                         {
                            Text(text = "Start",
                                modifier = Modifier.absolutePadding(140.dp,20.dp,120.dp,20.dp),
                                fontSize = (25.sp),
                                color = Color.Black,
                                fontFamily = FontFamily.Cursive,
                                fontWeight = FontWeight.ExtraBold,
                                )

                        }
                    }

                    Card(
                        shape = RoundedCornerShape(30.dp),
                        border = BorderStroke(2.dp, Color.Transparent),
                        modifier = Modifier
                            .width(500.dp)
                            .height(70.dp)
                            .background(Color.Transparent)
                            .fillMaxSize()
                            .absolutePadding(20.dp, 0.dp, 20.dp)
                            //.clickable {
                                //navController.navigate(ROUTE_CATTLE2) {
                               //     popUpTo(ROUTE_CATTLE) { inclusive = true }
                             //   }
                           // }

                        ,
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        elevation = CardDefaults.cardElevation(0.dp) ,
                    )
                    {
                        Text(text = "Get started",
                            modifier = Modifier.absolutePadding(130.dp,20.dp,120.dp,20.dp),
                            fontSize = (25.sp),
                            color = Color.Transparent,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.ExtraBold,
                        )

                    }











                }


            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CattleScreen() {
    CattleScreen(rememberNavController())
}

