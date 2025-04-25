package dam.grupo13.retodam.layout.views

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.request.LoginRequest
import dam.grupo13.retodam.store.AppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Login(navController: NavController, appViewModel: AppViewModel) {

	var usuario by remember { mutableStateOf(TextFieldValue("test3")) }
	var password by remember { mutableStateOf(TextFieldValue("")) }
	var loading by remember { mutableStateOf(false) }

	val context = LocalContext.current

	ConstraintLayout(modifier = Modifier.fillMaxSize()) {
		var (columna) = createRefs()

		Column(
			modifier = Modifier
				.constrainAs(columna) {
					centerVerticallyTo(parent)
					centerHorizontallyTo(parent)
				},
			verticalArrangement = Arrangement.spacedBy(15.dp),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			TextField(
				value = usuario,
				onValueChange = { data -> usuario = data },
				label = { Text("Usuario") },
				enabled = !loading
			)

			TextField(
				value = password,
				label = { Text("Contraseña") },
				onValueChange = { data -> password = data },
				enabled = !loading
			)

			Button(
				enabled = !loading,
				onClick = {
					var http = HttpAPIService()
					loading = !loading

					CoroutineScope(Dispatchers.IO).launch {
						val login = http.login(LoginRequest(
							usuario.text.toString(),
							password.text.toString()
						))

						when (login) {
							"OK" -> {
								withContext(Dispatchers.Main) {
									appViewModel.setUsername(usuario.text)
									navController.navigate("Inicio")
								}
							}
							"ERR" -> {
								withContext(Dispatchers.Main) {
									Toast
										.makeText(
											context,
											"Usuario o contraseña incorreectos",
											Toast.LENGTH_SHORT
										)
										.show()
								}
							}
							"404" -> withContext(Dispatchers.Main) {
								Toast
									.makeText(
										context,
										"Error del servidor. Inténtelo más tarde",
										Toast.LENGTH_SHORT
									)
									.show()
							}
						}
					}

					loading = !loading
				}
			) { Text("Iniciar Sesión") }

			TextButton(
				onClick = { navController.navigate("Register")},

			) {
				Text(
					"Registrarse",
					textDecoration = TextDecoration.Underline,
					fontWeight = FontWeight.Bold
				)
			}
		}
	}


}