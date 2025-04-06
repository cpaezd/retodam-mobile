package dam.grupo13.retodam.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dam.grupo13.retodam.layout.views.Inicio
import dam.grupo13.retodam.layout.views.Login
import dam.grupo13.retodam.layout.views.Register
import dam.grupo13.retodam.layout.views.SolicitudView
import dam.grupo13.retodam.layout.views.VacanteView

@Preview
@Composable
fun App() {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "Login") {
		composable("Inicio") { Inicio() }
		composable("Login") { Login(navController) }
		composable("Register") { Register(navController) }

		composable(
			"SolicitudView/{id}",
			arguments = listOf(navArgument("id") { type = NavType.StringType })
		) { backStackEntry ->
			val id = backStackEntry.arguments?.getString("id") ?: ""
			SolicitudView(navController, id)
		}

		composable(
			"VacanteView/{id}",
			arguments = listOf(navArgument("id") { type = NavType.StringType })
		) { backStackEntry ->
			val id = backStackEntry.arguments?.getString("id") ?: ""
			VacanteView(navController, id)
		}
	}
}