CREATE TABLE softgeb(
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_equipo VARCHAR(150) NOT NULL,
marca VARCHAR(80) NOT NULL,
modelo VARCHAR(80) NOT NULL,
ubicacion VARCHAR(150) NOT NULL,
estatus VARCHAR(20) NOT NULL,
observacion TEXT NOT NULL
);

SELECT * FROM softgeb;

INSERT INTO softgeb(nombre_equipo, marca, modelo, ubicacion, estatus, observacion)
VALUES("Davincci", "ElectroBrain", "TXZR", "Amazonas", "Funcional", "ninguna");
