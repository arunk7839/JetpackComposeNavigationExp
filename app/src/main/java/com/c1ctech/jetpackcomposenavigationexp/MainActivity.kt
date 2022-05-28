package com.c1ctech.jetpackcomposenavigationexp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import  androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.c1ctech.jetpackcomposenavigationexp.ui.theme.JetpackComposeNavigationExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNavigationExpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    //creating navController instance
    val navController = rememberNavController()

    //creating a NavHost
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        //You can add to your navigation structure by using the composable() method.
        //This method requires that you provide a route and the composable that should be linked to the destination.
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen(navController = navController)
        }
    }
}


@Composable
fun FirstScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Screen",
            fontSize = 40.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold
        )

        Button(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(all = Dp(8F)),
            onClick = {
                // navigate to second screen
                navController.navigate("second_screen")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        )
        {
            Text(text = "Go to Second Screen", fontSize = 25.sp)
        }

    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen",
            fontSize = 40.sp,
            color = Color.Magenta,
            fontWeight = FontWeight.Bold
        )

        Button(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(all = Dp(8F)),
            onClick = {
                //navigate to third screen
                navController.navigate("third_screen")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.White
            )
        )
        {
            Text(text = "Go to Third Screen", fontSize = 25.sp)
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third Screen",
            fontSize = 40.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )

        Button(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(all = Dp(8F)),
            onClick = {
                // navigate to first screen
                navController.navigate("first_screen")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            )
        )
        {
            Text(text = "Go to First Screen", fontSize = 25.sp)
        }
    }
}


