package dam.grupo13.retodam.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dam.grupo13.retodam.R

class SolicitudesActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_solicitudes)
//		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//			insets
//		}
	}
}