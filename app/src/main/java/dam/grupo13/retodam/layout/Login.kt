package dam.grupo13.retodam.layout

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun Login(navController: NavController) {

	var usuario by remember { mutableStateOf(TextFieldValue("test3")) }
	var password by remember { mutableStateOf(TextFieldValue("123456")) }
	var loading by remember { mutableStateOf(false) }

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
						val login = http.login(
							usuario.text.toString(),
							password.text.toString()
						)

						when (login) {
							"OK" -> ""
							"ERR01" -> ""
							"ERR404" -> ""
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