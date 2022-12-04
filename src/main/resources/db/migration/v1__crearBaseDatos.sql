CREATE TABLE IF NOT EXISTS usuarios (
	idUsuario integer PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	email varchar (200) UNIQUE NOT NULL,
	password varchar (50) NOT NULL,
	direccion varchar (50),
	departamento varchar(50),
	municipio varchar(50),
	rol smallint NOT NULL,
	nit varchar(10),
	precioPorKilometro Real, 
	precioPorKilogramo Real,
	precioPorMetroCubico Real 
	);

CREATE TABLE IF NOT EXISTS elementos (
	idElemento integer PRIMARY KEY,
	nombre varchar(100) NOT NULL,
	categoria integer NOT NULL,
	valor real NOT NULL,
	estado boolean NOT NULL,
	peso real NOT NULL,
	alto real NOT NULL,
	largo real NOT NULL,
	ancho real NOT NULL,
	idUsuario integer REFERENCES usuarios (idUsuario) NOT NULL
);


CREATE TABLE IF NOT EXISTS trueques (
	idTrueque integer,
	fecha date,
	estado smallint NOT NULL,
	idUsuario1 integer REFERENCES usuarios (idUsuario) NOT NULL, 
	idElemento1 integer REFERENCES elementos (idElemento) NOT NULL,
	idUsuario2 integer REFERENCES usuarios (idUsuario) NOT NULL,
	idElemento2 integer REFERENCES elementos (idElemento) NOT NULL,
	idUsuarioOL integer REFERENCES usuarios (idUsuario) NOT NULL,
	PRIMARY KEY (idTrueque, fecha)
	);

CREATE TABLE IF NOT EXISTS tokens (
	idToken varchar(50) PRIMARY KEY,
	timestampGeneracion varchar (50) NOT NULL,
	expirationTime varchar (50) NOT NULL,
	active varchar (50) NOT NULL,
	valorToken text NOT NULL,
	idUsuario integer REFERENCES usuarios (idUsuario),
	);

CREATE TABLE IF NOT EXISTS notificaciones (
	idNotificacionElemento integer PRIMARY KEY,
	tipo boolean NOT NULL,
	fecha date NOT NULL,
	mensaje varchar (200) NOT NULL,
	idTrueque integer,
	fechaTrueque date,
	fechaNotificacion date NOT NULL,
	idElemento integer REFERENCES elementos (idElemento),
	FOREIGN KEY (idTrueque,fechaTrueque) REFERENCES trueques (idTrueque,fecha)
);

