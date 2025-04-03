package dam.grupo13.retodam.http

import android.util.Log
import androidx.annotation.UiThread
import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.http.model.Usuario
import dam.grupo13.retodam.http.model.Vacante
import dam.grupo13.retodam.http.request.LoginRequest
import dam.grupo13.retodam.http.response.OperationResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpAPIService() {

	private fun getRetroFit(): Retrofit{
		return Retrofit.Builder()
			.baseUrl("http://192.168.1.94:8080/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	suspend fun login(username: String, passwd: String): String {
		val rf = this.getRetroFit();

		return withContext(Dispatchers.IO) {
			try {
				val call = rf.create(IHttpAPIService::class.java).login(LoginRequest(username, passwd))
				call.body()

				if(call.isSuccessful) {
					Log.i("DBG", "Correcto")

					"OK"
				} else {
					Log.i("DBG", "Fallo")

					"ERR01"
				}
			} catch(e: Exception) {
				"ERR404"
			}

		}
	}

	suspend fun signup(nuevo: NuevoUsuarioRequest): Usuario? {
		val rf = this.getRetroFit();
		var status: Usuario? = null

		return withContext(Dispatchers.IO) {
			val call = rf.create(IHttpAPIService::class.java).register(nuevo)
			status = call.body()

			if(call.isSuccessful) {
				Log.i("DBG", "OK!")
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