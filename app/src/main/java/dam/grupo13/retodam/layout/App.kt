package dam.grupo13.retodam.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dam.grupo13.retodam.layout.views.Inicio
import dam.grupo13.retodam.layout.views.Login
import dam.grupo13.retodam.layout.views.Register
import dam.grupo13.retodam.layout.views.ListaSolicitudes
import dam.grupo13.retodam.layout.views.VacanteView
import dam.grupo13.retodam.layout.views.VerVacante
import dam.grupo13.retodam.store.AppViewModel

@Composable
fun App() {
	val navController = rememberNavController()
	val avm = AppViewModel()

	NavHost(navController = navController, startDestination = "Login") {
		composable("Inicio") { Inicio(navController) }
		composable("Login") { Login(navController, avm) }
		composable("Register") { Register(navController) }
		composable("ListaSolicitudes") { ListaSolicitudes() }

		composable(
			"VerVacante/{id}",
			arguments = listOf(navArgument("id") { type = NavType.IntType })
		) { backStackEntry ->
			val id = backStackEntry.arguments?.getInt("id") ?: 0
			VerVacante(navController, avm, id)
		}
	}
}