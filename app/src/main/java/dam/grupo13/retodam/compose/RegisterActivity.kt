package dam.grupo13.retodam.compose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Preview
@Composable
fun Register() {
	ConstraintLayout(modifier = Modifier.fillMaxSize()) {
		val (columna) = createRefs()

		var usuario by remember { mutableStateOf(TextFieldValue("cpaez")) }
		var nombre by remember { mutableStateOf(TextFieldValue("Carlos")) }
		var apellidos by remember { mutableStateOf(TextFieldValue("Paez")) }
		var email by remember { mutableStateOf(TextFieldValue("cpaez@dam.es")) }
		var password by remember { mutableStateOf(TextFieldValue("12345")) }
		var loading by remember { mutableStateOf(false) }

		Column (
			modifier = Modifier
				.constrainAs(columna) {
				centerVerticallyTo(parent)
				centerHorizontallyTo(parent)
			},
			verticalArrangement = Arrangement.spacedBy(24.dp)
		) {

			TextField(
				value = usuario,
				label = { Text("Usuario") },
				onValueChange = { data -> usuario = data },
				enabled = !loading
			)

			TextField(
				value = nombre,
				label = { Text("Nombre") },
				onValueChange = { data -> nombre = data },
				enabled = !loading
			)

			TextField(
				value = apellidos,
				label = { Text("Apellidos") },
				onValueChange = { data -> apellidos = data },
				enabled = !loading
			)

			TextField(
				value = email,
				label = { Text("Correo Electrónico") },
				onValueChange = { data -> email = data },
				enabled = !loading
			)

			TextField(
				value = password,
				label = { Text("Contraseña") },
				onValueChange = { data -> password = data },
				enabled = !loading
			)

			Button(
				onClick = {
					val http = HttpAPIService()
					loading = !loading

					CoroutineScope(Dispatchers.IO).launch {
						val t = http.signup(NuevoUsuarioRequest(
							usuario.text.toString(),
							nombre.text.toString(),
							apellidos.text.toString(),
							email.text.toString(),
							password.text.toString()
						))

						Log.i("DBG", t.toString())
					}


				},
				enabled = !loading
			) {
				Text("Enviar")
			}
		}
	}
}