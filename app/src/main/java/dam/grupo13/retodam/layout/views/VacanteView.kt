package dam.grupo13.retodam.layout.views

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.http.model.Vacante

//@Preview
@Composable
fun VacanteView(navController: NavController, id: Int) {
	var vacante: Vacante? by remember { mutableStateOf(Vacante()) }

	LaunchedEffect(Unit) {
		var http = HttpAPIService()

		vacante = http.getVacante(id)

		Log.i("DBG", vacante.toString())
	}

	ConstraintLayout {
		var (nombreBox, empresaBox, descripcionBox, detallesBox) = createRefs()

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.05f)
				.background(Color.Magenta)
				.constrainAs(nombreBox) {
					top.linkTo(parent.top)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					bottom.linkTo(empresaBox.top)
				}
		) {
			Text(vacante?.nombre.toString())
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.05f)
				.constrainAs(empresaBox) {
					top.linkTo(nombreBox.bottom)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					bottom.linkTo(descripcionBox.top)
				}
		) {
			Row {
				Box(
					modifier = Modifier
						.fillMaxHeight()
						.weight(0.5f)
						.background(Color.Blue)
				) {
					Text(
						text = vacante?.fecha.toString(),

					)
				}

				Box(
					modifier = Modifier
						.fillMaxHeight()
						.weight(0.5f)
						.background(Color.Cyan)
				) {
					Text(vacante?.empresa.toString())
				}
			}
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Red)
				.fillMaxHeight(0.20f)
				.constrainAs(descripcionBox) {
					top.linkTo(empresaBox.bottom)
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					bottom.linkTo(detallesBox.top)
				}
		) {
			Text(
				vacante?.descripcion.toString(),
				textAlign = TextAlign.Justify
			)
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.70f)
				.background(Color.Gray)
				.constrainAs(detallesBox) {
					start.linkTo(parent.start)
					end.linkTo(parent.end)
					top.linkTo(descripcionBox.bottom)
					bottom.linkTo(parent.bottom)
				}
		) {
			Text(
				text = vacante?.detalles.toString(),
				textAlign = TextAlign.Justify
			)
		}
	}
}