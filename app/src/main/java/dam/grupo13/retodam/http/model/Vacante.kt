package dam.grupo13.retodam.http.model

import com.google.gson.annotations.SerializedName

data class Vacante(
	@SerializedName("id_vacante")
	var id: Int = 0,
	var nombre: String = "Puesto Génerico",
	var descripcion: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus maximus, felis ac ultrices fermentum, nisi ex faucibus magna, at finibus dui sapien nec mauris. Sed ac massa tellus. Curabitur libero odio, malesuada pellentesque ornare ac, suscipit ac ante. Quisque ut mattis urna. In tempus, nunc non blandit ultricies, purus tortor congue dolor, ac finibus nisl purus eu nisl. Praesent fringilla eget augue non mollis. Suspendisse ac urna finibus, semper lacus in, malesuada nunc. Curabitur mattis nisl sed lacus imperdiet consectetur. Phasellus porttitor ipsum eget blandit feugiat. Sed nec eros ac ligula mattis lobortis",
	var salario: Float = 0.0f,
	var detalles: String? = "n sed metus dolor. Fusce tincidunt diam ex, quis consequat dolor congue a. Vivamus feugiat mauris ornare, sagittis ex ut, consectetur risus. Mauris erat tortor, convallis in lectus vitae, faucibus ullamcorper ante. Curabitur luctus nec libero ac imperdiet. Pellentesque eu lorem urna. Integer finibus maximus blandit. Suspendisse sit amet ligula ac justo feugiat auctor. Nunc pretium tellus a sem aliquet venenatis. Proin non felis justo. Proin volutpat dapibus tortor. Nulla facilisi.",
	var imagen: String = "",
	var destacado: Boolean = false,
	var fecha: String = "1999-05-03",
	@SerializedName("razonSocial")
	var empresa: String = "Empresa Genérica",
	//var categoria: String = "Categoria genérica"
)
