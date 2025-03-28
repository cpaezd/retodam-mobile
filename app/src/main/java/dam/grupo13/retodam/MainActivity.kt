package dam.grupo13.retodam

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import dam.grupo13.retodam.databinding.ActivityMainBinding
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest

class MainActivity : ComponentActivity() {
	private lateinit var binding: ActivityMainBinding;

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_register)

		findViewById<Button>(R.id.registroBoton).setOnClickListener {
			val http = HttpAPIService();

			val usuario = findViewById<EditText>(R.id.registroUsuarioText).text.toString()
			val nombre = findViewById<EditText>(R.id.registroNombreText).text.toString()
			val apellidos = findViewById<EditText>(R.id.registroApellidosText).text.toString()
			val email = findViewById<EditText>(R.id.registroEmailText).text.toString()
			val passwd = findViewById<EditText>(R.id.registroPasswdText).text.toString()

			val nuevo = NuevoUsuarioRequest(usuario, nombre, apellidos, email, passwd)



		}
	}
}
