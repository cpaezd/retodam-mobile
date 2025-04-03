package dam.grupo13.retodam.http.model

data class Usuario (
	val username: String?,
	val nombre: String?,
	val apellidos: String?,
	val email: String?,
	val password: String?,
	val activado: Boolean,
	val fecha_registro: String?,
	val solicitudes: List<Solicitud> = emptyList<Solicitud>()
)
