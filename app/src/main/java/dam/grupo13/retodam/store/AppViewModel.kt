package dam.grupo13.retodam.store

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
	private var _username = mutableStateOf<String>("")
	var username: State<String> = _username

	fun getUsername(): String? = username.value

	fun setUsername(usuario: String) {
		_username.value = usuario
	}
}