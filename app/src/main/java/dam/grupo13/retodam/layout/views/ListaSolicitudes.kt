package dam.grupo13.retodam.layout.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.Solicitud

@Composable
fun ListaSolicitudes(nav: NavController, id: String) {
	var solicitudes by remember { mutableStateOf<List<Solicitud>>(emptyList()) }

	LaunchedEffect(Unit) {
		var http = HttpAPIService()

	}

	LazyColumn {
		items(solicitudes.size) {
			s -> ""
		}
	}
}