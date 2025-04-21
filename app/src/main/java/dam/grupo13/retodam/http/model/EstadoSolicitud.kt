package dam.grupo13.retodam.http.model

enum class EstadoSolicitud(val valor: Int) {
	CREADA(0),
	ACEPTADA(1),
	RECHAZADA(2),
	CANCELADA(3);

	companion object {
		fun fromInt(valor: Int): EstadoSolicitud? {
			return EstadoSolicitud.entries.find { it.valor == valor }
		}
	}
}