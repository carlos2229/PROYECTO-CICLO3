const URL_API = "http://localhost:8080/softgeb"


function get_data_form(evt) {
    evt.preventDefault()
    const form = evt.target
    const equipo = {
        nombre_equipo: form.nombre_equipo.value,
        marca: form.marca.value,
        modelo: form.modelo.value,
        ubicacion: form.ubicacion.value,
        estatus: form.estatus.value
    }

   create(equipo)

}

async function create(equipo){
    // Enviar peticion
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(equipo)
    })

    const text = await resp.text()
    alert(text)
}