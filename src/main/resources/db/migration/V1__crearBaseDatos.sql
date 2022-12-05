CREATE TABLE IF NOT EXISTS usuarios (
	id SERIAL PRIMARY KEY,
	nombre varchar (100) NOT NULL,
	email varchar (200) UNIQUE NOT NULL,
	password varchar (50) NOT NULL,
	direccion varchar (50),
	departamento varchar(50),
	municipio varchar(50),
	rol integer NOT NULL,
	nit varchar(10),
	precio_Kilometro Real,
	precio_Kilogramo Real,
	precio_Metro_Cubico Real
	);

CREATE TABLE IF NOT EXISTS elementos (
	id SERIAL PRIMARY KEY,
	nombre varchar(100) NOT NULL,
	categoria integer NOT NULL,
	valor real NOT NULL,
	estado boolean NOT NULL,
	peso real NOT NULL,
	altura real NOT NULL,
	longitud real NOT NULL,
	anchura real NOT NULL,
	idUsuario integer REFERENCES usuarios (id) NOT NULL
);

CREATE TABLE IF NOT EXISTS trueques (
	id SERIAL,
	fecha date,
	estado integer NOT NULL,
	idUsuario1 integer REFERENCES usuarios (id) NOT NULL,
	idElemento1 integer REFERENCES elementos (id) NOT NULL,
	idUsuario2 integer REFERENCES usuarios (id) NOT NULL,
	idElemento2 integer REFERENCES elementos (id) NOT NULL,
	idUsuarioOL integer REFERENCES usuarios (id) NOT NULL,
	PRIMARY KEY (id, fecha)
	);

CREATE TABLE IF NOT EXISTS tokens (
	id SERIAL PRIMARY KEY,
	timestamp_generacion bigint NOT NULL,
	tiempo_expiracion integer NOT NULL,
	activo boolean NOT NULL,
	valor_token text NOT NULL,
	idUsuario integer REFERENCES usuarios (id)
	);

CREATE TABLE IF NOT EXISTS notificaciones (
	id SERIAL PRIMARY KEY,
	tipo_notificacion integer NOT NULL,
	fecha date NOT NULL,
	mensaje varchar (200) NOT NULL,
	idTrueque integer,
	fechaTrueque date,	
	idElemento integer REFERENCES elementos (id),
	idUsuario integer REFERENCES usuarios (id),
	FOREIGN KEY (id,fechaTrueque) REFERENCES trueques (id,fecha)
);
