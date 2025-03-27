package dam.grupo13.retodam.http

import androidx.annotation.UiThread
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.http.request.LoginRequest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpAPIService() {

	private fun getRetroFit(): Retrofit{
		return Retrofit.Builder()
			.baseUrl("http://192.168.90.22:8080/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	suspend fun login(username: String, passwd: String): String {
		val rf = this.getRetroFit();
		val status: String

		try {
			return withContext(Dispatchers.IO) {
				val call = rf.create(IHttpAPIService::class.java).login(LoginRequest(username, passwd))
				call.body()

				if(call.isSuccessful) {
					"OK"
				} else {
					"ERR"
				}
			}
		} catch (e: Exception) {

		}

		return ""
	}

	suspend fun signup(nuevo: NuevoUsuarioRequest): String? {
		val rf = this.getRetroFit();
		var status: String? = null

		return withContext(Dispatchers.IO) {
			val call = rf.create(IHttpAPIService::class.java).register(nuevo)
			status = call.body()

			if(call.isSuccessful) {
				status
			} else {
				null
			}
		}
	}

	fun getSolicitudes(): List<Solicitud> {
		return emptyList()
	}

	fun getLastVacantes(): List<Vacante> {
		return emptyList()
	}

	fun getVacantesByQuery(value: String = "", opt: String): List<Vacante> {
		return emptyList()
	}

	fun applyVacante(vacante: Int): Boolean {
		return true;
	}

	fun cancelarVacante(vacante: Int): Boolean {
		return true;
	}
}