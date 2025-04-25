package dam.grupo13.retodam.http.response

import com.google.gson.annotations.SerializedName

data class OperationResponse (
	@SerializedName("statusCodeValue")
	val code: Int
)
