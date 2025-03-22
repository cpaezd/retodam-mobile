package dam.grupo13.retodam.http.model

data class Solicitud(
	val id: Int,
	val fecha: String, // ??
	val archivo: String,
	val comentarios: String,
	val estado: Int,
	val vacante: Int,
	val username: String
)
