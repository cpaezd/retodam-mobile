package dam.grupo13.retodam.http.request

data class NuevoUsuarioRequest(
	val username: String,
	val nombre: String,
	val apellidos: String,
	val email: String,
	val passwd: String
)
