package dam.grupo13.retodam.layout.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import dam.grupo13.retodam.http.model.Vacante

//@Preview
@Composable
fun VacanteCard(navController: NavController, vacante: Vacante) {
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp),
		elevation = CardDefaults.cardElevation(4.dp)
	) {
		ConstraintLayout(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentHeight()
				.padding(16.dp)
		) {
			val (nombreEmpresa, descripcion, boton) = createRefs()

			Text(
				text = vacante.nombre,
				modifier = Modifier
					.fillMaxWidth()
					.constrainAs(nombreEmpresa) {
						top.linkTo(parent.top)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					}
			)

			Text(
				text = vacante.descripcion.toString(),
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 8.dp)
					.constrainAs(descripcion) {
						top.linkTo(nombreEmpresa.bottom)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
					}
			)

			Button(
				onClick = {
					navController.navigate("VerVacante/${vacante.id}")
				},
				modifier = Modifier
					.fillMaxWidth()
					.padding(top = 16.dp)
					.constrainAs(boton) {
						top.linkTo(descripcion.bottom)
						start.linkTo(parent.start)
						end.linkTo(parent.end)
						bottom.linkTo(parent.bottom)
					}
			) {
				Text("Más Información")
			}
		}
	}
}
