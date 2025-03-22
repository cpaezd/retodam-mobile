package dam.grupo13.retodam.http.request

data class NuevaSolicitudRequest (
	val vacante: Int,
	val usuario: String,
	val archivo: String, // ??
	val comentario: String
)
