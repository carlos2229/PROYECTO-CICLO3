const URL_API = "http://localhost:8080/softgeb"


async function get_equipos() {
    // Enviar peticion
    const resp = await fetch(URL_API)
    // Obtener datos de la peticion
    const equipos = await resp.json()
    return equipos
}

function show(equipos) {
    const tbody = document.getElementById("tbody")
    let tr_body = ''
    // Iterar equipos
    for(let i = 0; i < equipos.length; i++){
        const obj = equipos[i]
        tr_body += `
            <tr>
                <td>${obj.id}</td>
                <td>${obj.nombre_equipo}</td>
                <td>${obj.marca}</td>
                <td>${obj.modelo}</td>
                <td>${obj.ubicacion}
                <td>${obj.estatus}</td>
            </tr>
        `
    }

    tbody.innerHTML = tr_body

}

async function main() {
    const equipos = await get_equipos()
    show(equipos)
}

main()