package dam.grupo13.retodam.layout.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.layout.components.SolicitudCard
import dam.grupo13.retodam.store.AppViewModel

@Preview
@Composable
fun ListaSolicitudes() {
	var avm = AppViewModel()
	var solicitudes by remember { mutableStateOf<List<Solicitud>>(emptyList()) }

	LaunchedEffect(Unit) {
		var http = HttpAPIService()

		solicitudes = http.getSolicitudes(avm.getUsername().toString())
	}

	Column(
		modifier = Modifier.fillMaxSize()
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.05f)
		) {
			Text("Lista de Solicitud")
		}

		LazyColumn {
			items(solicitudes.size) {
					s -> SolicitudCard(solicitudes[s])
			}
		}
	}
}
