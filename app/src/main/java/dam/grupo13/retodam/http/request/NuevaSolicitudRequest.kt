package dam.grupo13.retodam.http.request

import dam.grupo13.retodam.http.model.Usuario
import dam.grupo13.retodam.http.model.Vacante

data class NuevaSolicitudRequest (
	val archivo: String = "", // ??
	val comentario: String = "",
	val vacante: Vacante = Vacante(),
	val usuario: Usuario = Usuario()
)
