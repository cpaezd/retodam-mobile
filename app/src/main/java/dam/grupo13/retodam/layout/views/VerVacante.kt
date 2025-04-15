package dam.grupo13.retodam.layout.views

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun VerVacante() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(Color.White)
			.verticalScroll(rememberScrollState())
	) {
		Row (
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.06f)
		) {
			Box(
				modifier = Modifier
					.fillMaxHeight()
					.weight(0.75f)
			) {
				Text("Puesto")
			}

			Box(
				modifier = Modifier
					.fillMaxHeight()
					.weight(0.75f)
			) {
				Button(
					onClick = {}
				) {
					Text("Aplicar")
				}
			}
		}

		Row(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.04f)
		) {
			Box(
				modifier = Modifier
					.fillMaxHeight()
					.weight(0.5f)
			) {
				Text("Empresa")
			}

			Box(
				modifier = Modifier
					.fillMaxHeight()
					.weight(0.5f)
			) {
				Text("15/04/2025")
			}
		}

		Box(
			modifier = Modifier
				.fillMaxWidth()
				.fillMaxHeight(0.04f)
		) {}

		Box(
			modifier = Modifier
				.fillMaxWidth()
		) {}

		Box(
			modifier = Modifier
				.fillMaxWidth()
		) {}

	}
}