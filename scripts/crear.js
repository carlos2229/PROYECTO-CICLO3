const URL_API = "http://localhost:8080/softgeb"

function get_data_form(event) {
    event.preventDefault();
    const form = event.target
    const equipo = {
        nombre_equipo: form.nombre_equipo.value,
        marca: form.marca.value,
        modelo: form.modelo.value,
        ubicacion: form.ubicacion.value,
        estatus: form.estatus.value,
        observacion: form.observacion.value
    }
    create(mascota)
}


async function create(equipo) {
    // Solicitar peticion POST
    const respuesta = await fetch(URL_API,{
        method: "POST",
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringyfy(equipo)
    })

    const text = await respuesta.text()
    alert(text)
}