function mostrarAlertaAñadirLibro(event) {
	event.preventDefault();
	swal({
		title: "¡Atención!",
		text: "Antes de añadir un libro, debe haber registrado su autor previamente",
		icon: "warning",
		buttons: {
			cancel: "Cancelar",
			confirm: "Continuar"
		},
        }).then((value) => {
		if (value) {
			window.location.href = '/libros/nuevo';
		}
	});
}

function mostrarAlertaEliminar(elemento) {
	swal({
		title: "¿Está seguro?",
		text: "Esta acción no se puede deshacer",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			var form = elemento.nextElementSibling;
			form.submit();
			swal("Registro eliminado exitosamente!", {
				icon: "success",
			});
			} else {
			swal("Ningún registro fue eliminado");
		}
	});
}

function mostrarAlertaEliminarAutor(elemento) {
	swal({
		title: "¡Atención!",
		text: "No es posible eliminar un autor sin haber eliminado previamente sus libros. Si ya fueron eliminados, presione OK, de lo contrario, Cancelar",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			var form = elemento.nextElementSibling;
			form.submit();
			swal("Registro eliminado exitosamente!", {
				icon: "success",
			});
			} else {
			swal("Puede utilizar el cuadro de búsqueda para encontrar todos los libros registrados de un" +
			" autor");
		}
	});
}

function mostrarAlertaEliminarLibro(elemento) {
	swal({
		title: "¡Atención!",
		text: "No es posible eliminar un Libro si no figuran devueltos todos sus ejemplares. Si " +
		"ya fueron devueltos, presione OK, de lo contrario, Cancelar",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
	.then((willDelete) => {
		if (willDelete) {
			var form = elemento.nextElementSibling;
			form.submit();
			swal("Registro eliminado exitosamente!", {
				icon: "success",
			});
			} else {
			swal("Puede verificar los préstamos vigentes de un Libro en el listado de Libros " +
			"Registrados");
		}
	});
}

