package dam.grupo13.retodam.http

import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.http.request.LoginRequest
import dam.grupo13.retodam.http.request.NuevaSolicitudRequest
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.response.OperationResponse
import dam.grupo13.retodam.http.response.SolicitudResponse
import dam.grupo13.retodam.http.response.VacanteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IHttpAPIService {

	@GET("usuario/{username}")
	suspend fun getDatos(@Path("username") username: String): Response<String>

	@POST("usuario/login")
	// TODO: Revisar qué debe devolver
	suspend fun login(@Body login: LoginRequest): Response<OperationResponse>

	@POST("usuario/registro")
	suspend fun register(@Body nuevo: NuevoUsuarioRequest): Response<OperationResponse>

	@GET("solicitud/usuario/{username}")
	suspend fun getSolicitudes(@Path("username") username: String): Response<SolicitudResponse>

	@GET("solicitud/{id}")
	suspend fun getSolicitud(@Path("id") id: Int): Response<SolicitudResponse>

	@GET("vacante")
	suspend fun getVacantes(): Response<VacanteResponse>

	@GET("vacante/ver/{id}")
	suspend fun getVacante(@Path("id") id: Int): Response<Vacante>

	@GET("vacante/empresa/{empresa}")
	suspend fun getVacantesByEmpresa(@Path("empresa") empresa: String): Response<VacanteResponse>

	@GET("vacante/categoria/{categoria}")
	suspend fun getVacantesByCategoria(@Path("categoria") categoria: String): Response<VacanteResponse>

	@POST("solicitud/nueva")
	suspend fun applyVacante(@Body nueva: NuevaSolicitudRequest): Response<OperationResponse>

	@PUT("solicitud/cancelar/{id}")
	suspend fun cancelarSolicitud(@Path("id") solicitud: Int): Response<OperationResponse>
}