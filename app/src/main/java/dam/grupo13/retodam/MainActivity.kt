package dam.grupo13.retodam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import dam.grupo13.retodam.layout.App
import dam.grupo13.retodam.ui.theme.RetoDAMTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()

		WindowCompat.setDecorFitsSystemWindows(window, true)

		setContent {
			RetoDAMTheme {
				App()
			}
		}
	}
}
