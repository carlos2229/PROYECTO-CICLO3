const URL_API = "http://localhost:8080/equipos"

function get_data_form(event) {
    //No recargar pagina
    event.preventDefault();
    const form = event.target
    const equipo = {
        nombre_equipo: form.nombre_equipo.value,
        marca: form.marca.value,
        modelo: form.modelo.value,
        ubicacion: form.ubicacion.value,
        estatus: form.estatus.value,
    }
    create(equipo)
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

function set_form(form, equipo) {
    form.nombre.value = equipo.nombre
    form.marca.value = equipo.marca
    form.modelo.value = equipo.modelo
    form.ubicacion_id_ubicacion.ubicacion.value = equipo.ubicacion_id_ubicacion.ubicacion
    form.estatus_id_estatus.estatus.value = equipo.estatus_id_estatus.estatus
}

function get_params() {
    const search = window.location.searc
    const url = new URLSearchParams(search)
    const param_equipo = url.get("equipos")
    if(param_equipo) {
        const equipo = JSON.parse(param_equipo)
        const form = document.getElementById("form")
        set_form(form, equipo)
        update_data.update = true
        update_data.id = equipo.id
        document.getElementById("btn-form").innerText="Actualizar"
        document.getElementById("link-create").innerText="Actualizar mascota"
    }
}

get_data_form()