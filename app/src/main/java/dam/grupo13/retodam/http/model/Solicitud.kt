package dam.grupo13.retodam.http.model

import com.google.gson.annotations.SerializedName

data class Solicitud(
	@SerializedName("id_solicitud")
	var id: Int = 0,
	var fecha: String = "03/05/1999",
	var archivo: String = "",
	var comentarios: String = "",
	var estado: Int = 0,
	var vacante: Vacante = Vacante()
)
