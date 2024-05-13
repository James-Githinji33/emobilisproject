package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.SplashScreen
import net.ezra.ui.about.AboutScreen
import net.ezra.ui.auth.LoginScreen
import net.ezra.ui.auth.SignupScreen
import net.ezra.ui.cattle.CattleScreen
import net.ezra.ui.cattle.CattleScreen2
import net.ezra.ui.cattle.DryCow
import net.ezra.ui.cattle.MilkingCow
import net.ezra.ui.cattle.Registermilkcow
import net.ezra.ui.cattle.Viewmilkingcow
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.evening.EveningScreen
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.mit.MitScreen
import net.ezra.ui.products.ProductsScreen
import net.ezra.ui.services.ServicesScreen
import net.ezra.ui.students.AddStudents
import net.ezra.ui.students.StudentList

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {


        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }


        composable(ROUTE_SIGNUP) {
            SignupScreen(navController)
        }


        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }


        composable(ROUTE_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUTE_SERVICES) {
            ServicesScreen(navController)
        }

        composable(ROUTE_MIT) {
            MitScreen(navController)
        }

        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }

      //  composable(ROUTE_SHOP) {
         //   ShopScreen(navController)
        //}

        composable(ROUTE_PRODUCTS) {
            ProductsScreen(navController)
        }

        composable(ROUTE_EVENING) {
            EveningScreen(navController)
        }
        composable(ROUTE_ADD_STUDENTS) {
            AddStudents(navController)
        }

        composable(ROUTE_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUTE_STUDENT_LIST) {
            StudentList(navController=navController, viewModel = viewModel())
        }
        composable(ROUTE_CATTLE) {
            CattleScreen(navController=navController)
        }
        composable(ROUTE_CATTLE2) {
            CattleScreen2 (navController=navController)
        }
        composable(ROUTE_MILKINGCOW) {
           MilkingCow(navController=navController)
        }
        composable(ROUTE_DRYCOW) {
            DryCow (navController=navController)
        }
        composable(ROUTE_REGISTERMILKCOW) {
            Registermilkcow (navController=navController)
        }
        composable(ROUTE_VIEWMILKINGCOW) {
            Viewmilkingcow (navController=navController, viewModel= viewModel())
        }


































    }
}