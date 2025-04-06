package dam.grupo13.retodam.layout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import dam.grupo13.retodam.http.model.Vacante

@Preview
@Composable
fun VacanteCard(vacante: Vacante = Vacante(0, "Empresa", "Descripcion")) {
	Card(
		modifier = Modifier.fillMaxHeight(0.25f)
	) {
		ConstraintLayout (modifier = Modifier.fillMaxSize()) {
			var (nombreEmpresa, detalles, boton) = createRefs()

			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.15f)
					.background(Color.Cyan)
					.constrainAs(nombreEmpresa) {
						top.linkTo(parent.top)
						end.linkTo(parent.end)
						start.linkTo(parent.start)
						bottom.linkTo(detalles.top)
					}
			) {

			}

			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.70f)
					.background(Color.Magenta)
					.constrainAs(detalles) {
						top.linkTo(nombreEmpresa.bottom)
						end.linkTo(parent.end)
						start.linkTo(parent.start)
						bottom.linkTo(boton.top)
					}
			) {

			}


			Box(
				modifier = Modifier
					.fillMaxWidth()
					.fillMaxHeight(0.15f)
					.background(Color.Yellow)
					.constrainAs(boton) {
						top.linkTo(detalles.bottom)
						end.linkTo(parent.end)
						start.linkTo(parent.start)
						bottom.linkTo(parent.bottom)
					}
			) {

			}
		}
	}
}