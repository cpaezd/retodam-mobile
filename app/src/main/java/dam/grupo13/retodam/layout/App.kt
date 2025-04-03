package dam.grupo13.retodam.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun App() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "Login") {
		composable("Inicio") { Inicio(navController) }
		composable("Login") { Login(navController) }
		composable("Register") { Register(navController) }
		composable("Register") { Register(navController) }
	}
}