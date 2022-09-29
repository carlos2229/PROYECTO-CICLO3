const URL_API = "http://localhost:8080/softgeb"

async function get_mascotas(){
    // ENVIAR SOLICITUD GET
    const respuesta = await fetch(URL_API)
    const softgebs = await respuesta.json()
    return softgebs
}

function show_equipos(equipos){
    const tbody = document.getElementById("tbody")
    let tr = ""
    // Obtener los equipos iternado
    for(let i = 0; i < equipos.length; i++){
        const objEquipo = equipos[i]
        tr += `
            <tr>
                <td>${objEquipo.id}</td>
                <td>${objEquipo.nombre_equipo}</td>
                <td>${objEquipo.marca}</td>
                <td>${objEquipo.modelo}</td>
                <td>${objEquipo.ubicacion}</td>
                <td>${objEquipo.estatus}</td>
                <td>${objEquipo.observacion}</td>
                <td>
                    <button class="btn btn-warning" >Actualizar</button>
                    &nbsp;
                    <button class="btn btn-danger">Eliminar</button>
                </td>
            </tr>
        `
    }
    tbody.innerHTML = tr
}

async function main() {
    const equipos = await get_mascotas()
    show_equipos(equipos)
}

main()