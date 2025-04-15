package dam.grupo13.retodam.layout.views

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.layout.components.VacanteCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun Inicio(navController: NavController) {
	val filtros = listOf<String>("Empresa", "Categoria")
	var query by remember { mutableStateOf(TextFieldValue("")) }
	var filtro by remember { mutableStateOf(filtros[0]) }
	var vacantes by remember { mutableStateOf<List<Vacante>>(emptyList()) }
	var cargando by remember { mutableStateOf(false) }

	LaunchedEffect(Unit) {
		var http = HttpAPIService()

		vacantes = http.getVacantes()
	}

	ConstraintLayout(modifier = Modifier.fillMaxSize()) {
		var (busqueda, listadoVacantes) = createRefs()

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.13f)
				.constrainAs(busqueda) {
					top.linkTo(parent.top)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					bottom.linkTo(listadoVacantes.top)
				}
		) {
			Column(
				modifier = Modifier.fillMaxSize(),

			) {
				Box(
					modifier = Modifier
						.fillMaxWidth()
						.fillMaxHeight(0.5f),
					contentAlignment = Alignment.Center
				) {
					TextField(
						value = query,
						onValueChange = { q -> query = q },
						label = { Text("Búsqueda") },
						trailingIcon = {
							IconButton(
								onClick = {
									var http = HttpAPIService()

									CoroutineScope(Dispatchers.IO).launch {
										vacantes = http.getVacantesByQuery(filtro, query.text.toString())
									}

								}
							) {
								Icon(Icons.Rounded.Search, "Buscar")
							}
						}
					)
				}

				Box(
					modifier = Modifier.fillMaxSize(),
				) {
					Row(
						modifier = Modifier.fillMaxSize(),
						verticalAlignment = Alignment.CenterVertically
					) {
						for(f in filtros) {
							RadioButton(
								selected = filtro == f,
								onClick = {	filtro = f }
							)
							Text(f)
						}
					}
				}
			}
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.87f)
				.constrainAs(listadoVacantes) {
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					top.linkTo(busqueda.bottom)
					bottom.linkTo(parent.bottom)
				}
		) {
			LazyColumn {
				items(vacantes.size) { i ->
					VacanteCard(navController,vacantes[i])
				}
			}
		}
	}
}