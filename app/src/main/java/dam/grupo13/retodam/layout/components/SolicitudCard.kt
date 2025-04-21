package dam.grupo13.retodam.layout.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.EstadoSolicitud
import dam.grupo13.retodam.http.model.Solicitud
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun SolicitudCard(solicitud: Solicitud) {
	Log.i("DBG", solicitud.id.toString())

	Card(
		modifier = Modifier
			.fillMaxHeight(0.15f)
			.fillMaxWidth()
	) {
		Column(modifier = Modifier.padding(7.dp)) {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.4f),
				contentAlignment = Alignment.CenterStart
			) {
				Text(
					text = solicitud.vacante.nombre
				)
			}

			Row(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.6f)

			) {
				Box(
					modifier = Modifier
					.fillMaxHeight()
					.weight(0.5f),
					contentAlignment = Alignment.CenterStart
				) {
					Text(
						text = solicitud.fecha,

					)
				}

				Box(
					modifier = Modifier
						.fillMaxHeight()
						.weight(0.5f),
					contentAlignment = Alignment.CenterStart
				) {
					if(
						solicitud.estado == EstadoSolicitud.CREADA.valor
					)
					{
						Button(
							onClick = {
								var http = HttpAPIService()

								CoroutineScope(Dispatchers.IO).launch {
									http.cancelarSolicitud(solicitud.id)
								}
							},
							modifier = Modifier
								.fillMaxHeight()
								.fillMaxWidth()
						) {
							Text("Cancelar")
						}
					}
				}
			}
		}
	}
}