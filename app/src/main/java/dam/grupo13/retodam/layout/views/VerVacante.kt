package dam.grupo13.retodam.layout.views

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.http.request.NuevaSolicitudRequest
import dam.grupo13.retodam.store.AppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun VerVacante(
	navController: NavController,
	avm: AppViewModel,
	idVacante: Int,
) {
	var vacante by remember { mutableStateOf(Vacante()) }
	var boton by remember { mutableStateOf(true) }
	val context = LocalContext.current

	LaunchedEffect(Unit) {
		var http = HttpAPIService()

		vacante = http.getVacante(idVacante) ?: Vacante()
	}

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.verticalScroll(rememberScrollState())
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.1f)
		) {
			IconButton(
				onClick = { navController.navigate("Inicio") }
			) {
				Icon(Icons.AutoMirrored.Rounded.ArrowBack, "Atrás")
			}
		}

		Card(
			modifier = Modifier.padding(8.dp)
		) {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.1f)
					.padding(8.dp)
			) {
				Text(
					text = vacante.nombre
				)
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.04f)
					.padding(8.dp)
			) {
				Box(
					modifier = Modifier
						.fillMaxHeight()
						.weight(0.5f)
				) {
					Text(
						text = vacante.empresa
					)
				}

				Box(
					modifier = Modifier
						.fillMaxHeight()
						.weight(0.5f)
				) {
					Text(
						text = vacante.fecha
					)
				}
			}

			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.04f)
					.padding(8.dp)
			) {
				Text(
					text = vacante.salario.toString(),
					textAlign = TextAlign.Justify
				)
			}
		}

		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp),
		) {
			Text(
				text = vacante.descripcion,
				textAlign = TextAlign.Justify,
				modifier = Modifier
					.padding(16.dp)
			)
		}

		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(8.dp)
		) {
			Text(
				text = vacante.detalles ?: "No hay detalles",
				textAlign = TextAlign.Justify,
				modifier = Modifier
					.padding(16.dp)
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.1f),
			contentAlignment = Alignment.Center
		) {
			Button(
				enabled = boton,
				onClick = {
					boton = !boton

					var http = HttpAPIService()
					var nsr = NuevaSolicitudRequest()
					var res = false

					nsr.vacante.id = idVacante
					nsr.usuario.username = avm.getUsername() ?: "test3"

					CoroutineScope(Dispatchers.IO).launch {
						res = http.applyVacante(nsr) == "OK"

						withContext(Dispatchers.Main) {
							Toast.makeText(
								context,
								if (res) "Vacante aplicada correctamente" else "Fallo al aplicar vacante",
								Toast.LENGTH_SHORT
							).show()

							boton = !res
						}
					}
				},
				modifier = Modifier
					.fillMaxWidth(0.65f)
			) {
				Text("Aplicar")
			}
		}

	}
}