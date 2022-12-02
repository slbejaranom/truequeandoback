CREATE TABLE IF NOT EXISTS usuarios (
	idUsuario integer PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	email varchar (200) UNIQUE NOT NULL,
	password varchar (50) NOT NULL,
	direccion varchar (50) NOT NULL,
	departamento varchar(50) NOT NULL,
	municipio varchar(50) NOT NULL
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


CREATE TABLE IF NOT EXISTS operadoresLogisticos (
	idOperadorLogistico integer PRIMARY KEY,
	nombre varchar (200) NOT NULL,
	nit integer NOT NULL,
	email varchar (200) UNIQUE NOT NULL,
	password varchar (50) NOT NULL,
	precioPorKilometro Real NOT NULL, 
	precioPorKilogramo Real NOT NULL,
	precioPorMetroCubico Real NOT NULL
	);

CREATE TABLE IF NOT EXISTS administradores (
	idAdministrador integer PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	email varchar (200) UNIQUE NOT NULL,
	password varchar (50) NOT NULL
	);
	
CREATE TABLE IF NOT EXISTS trueques (
	idTrueque integer,
	fechaTrueque date,
	estado smallint NOT NULL,
	idUsuario1 integer REFERENCES usuarios (idUsuario) NOT NULL, 
	idElemento1 integer REFERENCES elementos (idElemento) NOT NULL,
	idUsuario2 integer REFERENCES usuarios (idUsuario) NOT NULL,
	idElemento2 integer REFERENCES elementos (idElemento) NOT NULL,
	idOperadorLogistico integer REFERENCES operadoresLogisticos (idOperadorLogistico) NOT NULL,
	PRIMARY KEY (idTrueque, fechaTrueque)
	);

CREATE TABLE IF NOT EXISTS tokens (
	idToken varchar(50) PRIMARY KEY,
	timestampGeneracion varchar (50) NOT NULL,
	expirationTime varchar (50) NOT NULL,
	active varchar (50) NOT NULL,
	idUsuario integer REFERENCES usuarios (idUsuario),
	idAdministrador integer REFERENCES administradores (idAdministrador),
	idOperadorLogistico integer REFERENCES operadoresLogisticos (idOperadorLogistico)
	);
	
CREATE TABLE IF NOT EXISTS notificacionesElemento (
	idNotificacionElemento integer PRIMARY KEY,
	tipo boolean NOT NULL,
	mensaje varchar (200) NOT NULL,
	idAdministrador integer REFERENCES administradores (idAdministrador)NOT NULL,
	idElemento integer REFERENCES elementos (idElemento) NOT NULL
);

CREATE TABLE IF NOT EXISTS notificacionesTrueque (
	idNotificacionTrueque integer PRIMARY KEY,
	idAdministrador integer REFERENCES administradores (idAdministrador)NOT NULL,
	idTrueque integer NOT NULL,
	fechaTrueque date NOT NULL,
	FOREIGN KEY (idTrueque,fechaTrueque) REFERENCES trueques (idTrueque,fechaTrueque)
);
	

