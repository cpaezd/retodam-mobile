package dam.grupo13.retodam.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import dam.grupo13.retodam.R
import dam.grupo13.retodam.http.HttpAPIService
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest

class RegisterActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContentView(R.layout.activity_register)
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}

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