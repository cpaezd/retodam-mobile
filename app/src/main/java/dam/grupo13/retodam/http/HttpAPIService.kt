package dam.grupo13.retodam.http

import dam.grupo13.retodam.http.request.NuevoUsuarioRequest
import dam.grupo13.retodam.http.model.Solicitud
import dam.grupo13.retodam.http.model.Vacante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HttpAPIService {
	private fun getRetroFit(): Retrofit{
		return Retrofit.Builder()
			.baseUrl("")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}

	suspend fun login(username: String, passwd: String): Boolean {
		val rf = this.getRetroFit();

		return withContext(Dispatchers.IO) {
			val call = rf
				.create(IHttpAPIService::class.java)
				.login()
			val res: String? = call.body()

			return@withContext call.isSuccessful && res.equals("OK", true)
		}
	}

	fun signup(nuevo: NuevoUsuarioRequest) {

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