package dam.grupo13.retodam.http

import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.response.SolicitudResponse
import dam.grupo13.retodam.http.response.VacanteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface IHttpAPIService {
	@POST("/usuario/login/")
	suspend fun login(): Response<String> // TODO: Revisar qué debe deolver
	@POST()
	suspend fun register(nuevo: NuevoUsuarioRequest): Response<String>

	@GET("/solicitud/")
	suspend fun getSolicitudes(): Response<SolicitudResponse>

	@GET("/vacante/")
	suspend fun getLastVacantes(): Response<VacanteResponse>
	@GET("/vacante/query/")
	suspend fun getVacantesByQuery(value: String, opt: String): Response<VacanteResponse>

	@POST()
	suspend fun applyVacante(vacante: Int): Response<String>
	@PUT()
	suspend fun cancelarVacante(vacante: Int): Response<String>
}