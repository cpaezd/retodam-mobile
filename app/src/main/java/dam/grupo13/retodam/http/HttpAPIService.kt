package dam.grupo13.retodam.http

import android.util.Log
import androidx.annotation.UiThread
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.http.model.Usuario
import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.http.request.LoginRequest
import dam.grupo13.retodam.http.response.OperationResponse
import dam.grupo13.retodam.http.response.SolicitudResponse
import dam.grupo13.retodam.http.response.VacanteResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpAPIService() {

	private fun getRetroFit(): Retrofit{
		return Retrofit.Builder()
			.baseUrl("http://192.168.90.22:8080/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	suspend fun login(loginRequest: LoginRequest): String {
		val rf = this.getRetroFit();
		var res = "ERR"

		try {
			val call = rf.create(IHttpAPIService::class.java).login(loginRequest)
			call.body()

			res = if (call.isSuccessful) "OK" else "ERR"

		} catch (e: Exception) {
			res = "404"
		}

		return res
	}

	suspend fun signup(nuevo: NuevoUsuarioRequest): String {
		val rf = this.getRetroFit();
		var res = "ERR"

		try {
			val call = rf.create(IHttpAPIService::class.java).register(nuevo)
			call.body()

			res = if (call.isSuccessful) "OK" else "ERR"

		} catch (e: Exception) {
			res = "404"
		}

		return res
	}

	suspend fun getSolicitudes(): SolicitudResponse? {
		val rf = this.getRetroFit();
		var res: SolicitudResponse? = SolicitudResponse()

		try {
			val call = rf.create(IHttpAPIService::class.java).getSolicitudes()

			if(call.isSuccessful) {
				res = call.body()
			}

		} catch (e: Exception) {
			res?.add(Solicitud())
		}

		return res
	}

	suspend fun getVacantes(): List<Vacante> {
		val rf = this.getRetroFit();
		var res: VacanteResponse? = VacanteResponse()

		try {
			val call = rf.create(IHttpAPIService::class.java).getVacantes()

			if(call.isSuccessful) {
				res = call.body()
			}

		} catch (e: Exception) {
			res?.add(Vacante())
			Log.i("DBG", e.message.toString())
		}

		return res as List<Vacante>
	}

	suspend fun getVacantesByQuery(filtro: String, valor: String): List<Vacante> {
		val rf = getRetroFit()
		var vacantesFiltradas: VacanteResponse? = VacanteResponse()
		var call: Response<VacanteResponse>? = null

		try {
			if(filtro == "Empresa") {
				call = rf.create(IHttpAPIService::class.java).getVacantesByEmpresa(valor)
			}

			if(filtro == "Categoria") {
				Log.i("DBG", "En categoria")
				call = rf.create(IHttpAPIService::class.java).getVacantesByCategoria(valor)
			}

			if(call?.isSuccessful == true) {
				vacantesFiltradas = call.body()
			}
		} catch(e: Exception) {

		}

		return vacantesFiltradas as List<Vacante>
	}

	suspend fun getVacante(vacante: Int): Vacante? {
		val rf = getRetroFit()
		var vacanteInfo: Vacante? = null

		try {
			val call = rf.create(IHttpAPIService::class.java).getVacante(vacante)

			if(call.isSuccessful) {
				vacanteInfo = call.body()
			}
		} catch (e: Exception) {
			Log.i("DBG", e.message.toString())
		}

		return vacanteInfo
	}

	suspend fun applyVacante(vacante: Int): String {
		val rf = this.getRetroFit();
		var res = "ERR"

		try {
			val call = rf.create(IHttpAPIService::class.java).getVacante(vacante)
			call.body()

			res = if (call.isSuccessful) "OK" else "ERR"

		} catch (e: Exception) {
			res = "404"
		}

		return res
	}

	suspend fun cancelarSolicitud(solicitud: Int): String {
//		val rf = this.getRetroFit();
//		var res = "ERR"
//
//		try {
//			val call = rf.create(IHttpAPIService::class.java).getVacante(vacante)
//			call.body()
//
//			res = if (call.isSuccessful) "OK" else "ERR"
//
//		} catch (e: Exception) {
//			res = "404"
//		}
//
//		return res

		return ""
	}
}